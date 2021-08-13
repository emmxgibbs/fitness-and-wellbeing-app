package com.team4.fitness_and_wellbeing.model;

import java.util.ArrayList;

public class Client {
    private String firstName;
    private String lastName;
    private String picUrl;
    public static ArrayList<Client> clientArrayList;

    public Client(String firstName, String lastName, String picUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.picUrl = picUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public static void populateList(){
        clientArrayList.add(new Client("clint", "clientman", "../img/pp4.png"));
        clientArrayList.add(new Client("carrie", "clientess", "../img/pp3.png"));
        clientArrayList.add(new Client("kelly", "clientane", "../img/pp2.png"));
        clientArrayList.add(new Client("hellen", "hillclient", "../img/pp1.png"));
    }
}
