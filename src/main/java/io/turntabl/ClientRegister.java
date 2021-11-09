package io.turntabl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientRegister {

    private List<Client> corporateClients;
    private List<Client> privateClients;

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
    public String getCountOfAllClientsAtEveryServiceLevel() {
        int goldClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Gold)).count();
        int platinumClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Platinum)).count();
        int premiumClientsCount = (int) getAllClientsList().stream().filter(client -> client.getServiceLevel().equals(ServiceLevel.Premium)).count();

        return "There are " + goldClientsCount + " gold clients, "
                + platinumClientsCount + " platinum clients and "
                + premiumClientsCount + " premium clients in our catalogue";
    }

}
