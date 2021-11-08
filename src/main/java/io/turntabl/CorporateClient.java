package io.turntabl;

public class CorporateClient extends Client {
    private AccountManager accountManager;

    public CorporateClient(String name, String id, ServiceLevel serviceLevel, AccountManager accountManager) {
        super(name, id, serviceLevel);
        this.accountManager = accountManager;
    }


    @Override
    public String getClientName() {
        return accountManager.getName();
    }
}
