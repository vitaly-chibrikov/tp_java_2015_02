package chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author v.chibrikov
 */
public class ChatWebSocketCreator implements WebSocketCreator {
    static final Logger logger = LogManager.getLogger(ChatWebSocketCreator.class);
    private Set<ChatWebSocket> users;

    public ChatWebSocketCreator() {
        this.users = Collections.newSetFromMap(new ConcurrentHashMap<ChatWebSocket, Boolean>());
    }

    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
        ChatWebSocket socket = new ChatWebSocket(users);
        logger.info("Socket created");
        return socket;
    }
}
