package io.turntabl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CorporateClientTest extends TestCase {

    public void testGetClientServiceLevel() {
        AccountManager accountManager = new AccountManager("Thomas Winans");
        CorporateClient corporateClient = new CorporateClient("Thomas Winans", "4CDE2", ServiceLevel.Platinum, accountManager);

        // getting client service level - should pass
        assertEquals(ServiceLevel.Platinum, corporateClient.getServiceLevel());
        // getting client service level - should fail
        assertEquals(ServiceLevel.Gold, corporateClient.getServiceLevel());
    }


    public void testGetAccountManagerName() {

        AccountManager accountManager = new AccountManager("James Riverson");
        CorporateClient corporateClient = new CorporateClient("Peter Andrews", "ACS21", ServiceLevel.Gold, accountManager);

        // getting the client name - should pass
        Assert.assertEquals("Peter Andrews", corporateClient.getName());
        // getting the client name - should fail
//        Assert.assertEquals("James Riversson", corporateClient.getName());


    }
}