package accountServer;


public class AccountServerController implements AccountServerControllerMBean {
    private final AccountServerI accountServer;

    public AccountServerController(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsers() {
        return accountServer.getUsersCount();
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit(int bla) {
        accountServer.setUsersLimit(bla);
    }
}
