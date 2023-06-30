package items;

import behaviours.ISell;

public abstract class Item implements ISell {

    private String description;

    private double boughtAt;

    private double soldFor;

    public Item(String description, double boughtAt, double soldFor){
        this.description = description;
        this.boughtAt = boughtAt;
        this.soldFor = soldFor;
    }

    public double calculateMarkup(){
        return soldFor - boughtAt;
    }

    public String getDescription() {
        return description;
    }

    public double getBoughtAt() {
        return boughtAt;
    }

    public double getSoldFor() {
        return soldFor;
    }
}
