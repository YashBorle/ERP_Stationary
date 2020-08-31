/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author LoveYou3000
 */
public class Item {
    int ItemId;
    String ItemName;
    int stockAvailable;

    public Item() {
    }

    public Item(int id, String ItemName, int stockAvailable) {
        this.ItemId = id;
        this.ItemName = ItemName;
        this.stockAvailable = stockAvailable;
    }

    public int getId() {
        return ItemId;
    }

    public void setId(int id) {
        this.ItemId = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(int stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
    
    
    
}
