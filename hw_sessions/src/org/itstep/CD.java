package org.itstep;

public class CD {
    private String name;
    private double cost;

    public CD(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public CD() {
        this.name = "";
        this.cost = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Cost: " + cost +
                "\n\n";
    }
}
