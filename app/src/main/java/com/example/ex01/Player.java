package com.example.ex01;

public class Player {
    private int id;
    private String name;
    private int number;
    private String address;

    public Player(String name, int number, String address) {
        this.name = name;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " - " + number + " - " + address; // Hiển thị thông tin cầu thủ
    }
}
