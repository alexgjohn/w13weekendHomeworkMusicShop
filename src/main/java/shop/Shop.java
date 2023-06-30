package shop;

import behaviours.ISell;
import items.Item;
import items.StringInstrument;

import java.util.HashMap;

public class Shop {

    private HashMap<ISell, Integer> stock;

    private double dailyProfits;

    public Shop(){
        this.stock = new HashMap<>();
        this.dailyProfits = 0;
    }

    public HashMap<ISell, Integer> getStock() {
        return stock;
    }

    public double getDailyProfits() {
        return dailyProfits;
    }

    //this one could also take ISell as an argument.
    public void addItemToStock(ISell item) {
        if (!stock.containsKey(item)){
            stock.put(item, 1);
        } else {
            int currentNumberInStock = stock.get(item);
            stock.put(item, (currentNumberInStock + 1));
        }
    }

    public String sellItem(Item item) {
        if (!stock.containsKey(item)){
            return String.format("The %s is not in stock.", item.getDescription());
        } else {
            int currentNumberInStock = stock.get(item);
            stock.put(item, (currentNumberInStock - 1));
            if (stock.get(item) == 0){
                stock.remove(item);
            }
            dailyProfits += item.calculateMarkup();
            return String.format("Someone bought 1 %s.", item.getDescription());
        }
    }

    public double calculateTotalPotentialProfitForStock() {
        double totalPotentialProfit = 0;
        for (ISell item:getStock().keySet()){
            double potentialProfitForItem = (item.calculateMarkup() * stock.get(item));
            totalPotentialProfit += potentialProfitForItem;
        }
        return totalPotentialProfit;
    }
}
