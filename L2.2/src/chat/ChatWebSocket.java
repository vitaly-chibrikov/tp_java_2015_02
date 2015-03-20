package chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.Set;

@WebSocket
public class ChatWebSocket {
    static final Logger logger = LogManager.getLogger(ChatWebSocket.class);
    private Set<ChatWebSocket> users;
    private Session session;

    public ChatWebSocket(Set<ChatWebSocket> users) {
        this.users = users;
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        for (ChatWebSocket user : users) {
            try {
                user.getSession().getRemote().sendString(data);
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        logger.info("onMessage: " + data);
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        users.add(this);
        setSession(session);
        logger.info("onOpen");
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        users.remove(this);
        logger.info("onClose");
    }
}
