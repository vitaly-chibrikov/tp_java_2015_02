package base;

/**
 * @author v.chibrikov
 */
public interface AuthService {
    String getUserName(String sessionId);

    void saveUserName(String sessionId, String name);
}
