package com.example.assignment1;

public class BasketballPlayer {
    private int id;
    private String name;
    private int time;
    private int age;
    private String nationality;
    private double height;
    private double weight;
    private int points;
    private int assists;
    private int rebounds;

    public BasketballPlayer(int id, String name, int time, int age, String nationality, double height, double weight,
                            int points, int assists, int rebounds) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.age = age;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getPoints() {
        return points;
    }

    public int getAssists() {
        return assists;
    }

    public int getRebounds() {
        return rebounds;
    }
}
