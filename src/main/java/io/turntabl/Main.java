package io.turntabl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PrivateClient privateClient = new PrivateClient("Jones", "34dsad", ServiceLevel.Gold);

        System.out.println(privateClient.toString());
    }
}
