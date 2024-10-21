package com.example.ex01;

public class Citizen {
    private int id;
    private String name;
    private String identification;
    private String address;

    public Citizen(String name, String identification, String address) {
        this.name = name;
        this.identification = identification;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public String getAddress() {
        return address;
    }
}
