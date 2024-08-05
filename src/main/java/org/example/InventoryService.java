package org.example;

public class InventoryService {

    public boolean addItem(String item, int quantity) {
        // Method implementation here
        return true;
    }

    public boolean removeItem(String item) {
        if(getItemQuantity(item) > 0) {
            //remove item
        }
        return true;
    }

    public int getItemQuantity(String item) {
        // Method implementation here
        return 0;
    }


}
