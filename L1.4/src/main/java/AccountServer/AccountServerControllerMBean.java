package AccountServer;

/**
 * Created by jim on 3/9/15.
 */
@SuppressWarnings("UnusedDeclaration")
public interface AccountServerControllerMBean {
    public int getUsers();
    public int getUsersLimit();
    public void setUsersLimit(int usersLimit);
}
