package AccountServer;

/**
 * Created by jim on 3/9/15.
 */
public class AccountServer {
    private int usersCount;
    private int usersLimit;

    public AccountServer(int usersLimit) {
        this.usersCount = 0;
        this.usersLimit = usersLimit;
    }

    public void addNewUser() {
        usersCount += 1;
    }

    public void removeUser() {
        usersCount -= 1;
    }

    public int getUsersLimit() {
        return usersLimit;
    }

    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    public int getUsersCount() {
        return usersCount;
    }
}
