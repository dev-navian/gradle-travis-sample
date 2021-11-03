package io.turntabl;

public class CorporateClient extends Client {
    AccountManager accountManager;

    public CorporateClient(String name, String id, ServiceLevel serviceLevel, AccountManager accountManager) {
        super(name, id, serviceLevel);
        this.accountManager = accountManager;
    }

    @Override
    public String getName() {
        return accountManager.getName();
    }

}
