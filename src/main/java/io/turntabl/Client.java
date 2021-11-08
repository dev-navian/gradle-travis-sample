package io.turntabl;

public abstract class Client {
    private String name;
    private String id;
    private ServiceLevel serviceLevel;

    public Client(String name, String id, ServiceLevel serviceLevel) {
        this.name = name;
        this.id = id;
        this.serviceLevel = serviceLevel;
    }

    // get name
    public String getName() {
        return name;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // get id
    public String getId() {
        return id;
    }

    // set id
    public void setId(String id) {
        this.id = id;
    }

    // get service level
    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    // set service level
    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", serviceLevel=" + serviceLevel +
                '}';
    }

    public abstract String getClientName();
}
