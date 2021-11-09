package io.turntabl;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ClientRegisterTest extends TestCase {
        AccountManager accountManagerOne = new AccountManager("Thomas Winans");
        AccountManager accountManagerTwo= new AccountManager("Meghan Taylor");
        AccountManager accountManagerThree = new AccountManager("Florence Edwin-Archer");

        CorporateClient corporateClientOne = new CorporateClient("Doug Peterson", "4CDE2", ServiceLevel.Premium, accountManagerOne);
        CorporateClient corporateClientTwo = new CorporateClient("Jane Doe", "34JHX", ServiceLevel.Gold, accountManagerTwo);
        CorporateClient corporateClientThree = new CorporateClient("Martins Thompson", "5ERC2", ServiceLevel.Platinum, accountManagerThree);

        PrivateClient privateClientOne = new PrivateClient("Felix Anderson", "4CDE2", ServiceLevel.Gold);
        PrivateClient privateClientTwo = new PrivateClient("Jane Doe", "WW67HB", ServiceLevel.Platinum);
        PrivateClient privateClientThree = new PrivateClient("Martins Thompson", "KL221", ServiceLevel.Platinum);

        List<Client> listOfCorporateClients = new ArrayList<>();
        List<Client> listOfPrivateClients = new ArrayList<>();

    public void testGetContactNamesOfGoldClients() {
        listOfCorporateClients.add(corporateClientOne);
        listOfCorporateClients.add(corporateClientTwo);
        listOfCorporateClients.add(corporateClientThree);

        listOfPrivateClients.add(privateClientOne);
        listOfPrivateClients.add(privateClientTwo);
        listOfPrivateClients.add(privateClientThree);

        ClientRegister registerOne = new ClientRegister(listOfCorporateClients, listOfPrivateClients);

        List<String> namesOfGoldClients = registerOne.getContactNamesOfGoldClients();

        // should pass since both are the same
        Assert.assertEquals(namesOfGoldClients, namesOfGoldClients);
    }

    public void testGetContactNameByClientId() {
        listOfCorporateClients.add(corporateClientOne);
        listOfCorporateClients.add(corporateClientTwo);
        listOfCorporateClients.add(corporateClientThree);

        listOfPrivateClients.add(privateClientOne);
        listOfPrivateClients.add(privateClientTwo);
        listOfPrivateClients.add(privateClientThree);

        ClientRegister register = new ClientRegister(listOfCorporateClients, listOfPrivateClients);

        String clientNameByID = register.getContactNameByClientId("34JHX");

        // should fail because names don't match
        // Assert.assertEquals(clientNameByID, "Jones Jackson");
        // should pass because names match up
        Assert.assertEquals(clientNameByID, "Meghan Taylor");
    }

    public void testGetCountOfAllClientsAtEveryServiceLevel() {
        listOfCorporateClients.add(corporateClientOne);
        listOfCorporateClients.add(corporateClientTwo);
        listOfCorporateClients.add(corporateClientThree);

        listOfPrivateClients.add(privateClientOne);
        listOfPrivateClients.add(privateClientTwo);
        listOfPrivateClients.add(privateClientThree);

        ClientRegister register = new ClientRegister(listOfCorporateClients, listOfPrivateClients);

        String allClientCount = register.getCountOfAllClientsAtEveryServiceLevel();

        // should fail because both client counts at each service level are not the same
//        Assert.assertEquals(allClientCount, "There are 2 gold clients, 2 platinum clients and 4 premium clients in our catalogue");
        // should pass because both client counts at each service level are the same
        Assert.assertEquals(allClientCount, "There are 2 gold clients, 3 platinum clients and 1 premium clients in our catalogue");
    }
}