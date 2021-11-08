package io.turntabl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientRegister {

    List<Client> corporateClients = new ArrayList<>();
    List<Client> privateClients = new ArrayList<>();

    public ClientRegister(List<Client> corporateClients, List<Client> privateClients) {
        this.corporateClients = corporateClients;
        this.privateClients = privateClients;
    }

    // retrieve total collection of clients
    public List<Client> getAllClientsList() {
        return Stream.concat(corporateClients.stream(), privateClients.stream())
                .collect(Collectors.toList());
    }

    // get a list of the contact names of all gold clients
    public List<String> getContactNamesOfGoldClients() {
        return getAllClientsList().stream()
                .filter(client -> client.getServiceLevel().equals(ServiceLevel.Gold))
                .map(Client::getClientName)
                .collect(Collectors.toList());
    }

    // get a list of the client's name by their id
    public String getContactNameByClientId(String id) {
        return getAllClientsList().stream()
                .filter(client -> client.getId().equals(id))
                .map(Client::getClientName)
                .findAny()
                .orElse("");
    }

    // a count of all clients at every service level
    public void getCountOfAllClientsAtEveryServiceLevel() {
        int goldClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Gold)).count();
        int platinumClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Platinum)).count();
        int premiumClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Premium)).count();

//        List<Integer> clientsRecordCount
        System.out.println("There are " + goldClientsCount + " clients at the gold service level");
        System.out.println("There are " + platinumClientsCount + " clients at the platinum service level");
        System.out.println("There are " + premiumClientsCount + " clients at the premium service level");

    }

}
