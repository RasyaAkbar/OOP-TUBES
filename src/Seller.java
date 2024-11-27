import java.util.ArrayList;

class Seller extends Person {
    private ArrayList<Item> inventory;
    private int itemsSold;

    public Seller(String name) {
        super(name);
        this.inventory = new ArrayList<>();
        itemsSold = 0;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public Item sellItem(int itemId) {
        for (Item item : inventory) {
            if (item.getId() == itemId) {
                item.setStock(item.getStock()-1);
                return item;
            }
        }
        return null; // Item not found
    }

    public void viewInventory() {
        System.out.println("Seller: "+name);
        for (Item item : inventory) {
            item.displayItem();
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void incrementItemsSold(){
        itemsSold++;
    }
    
    
    @Override
    public void displayInfo() {
        System.out.println("Seller: " + name + " | Items Sold: " + itemsSold);
    }

    public int getItemsSold() {
        return itemsSold;
    }
}
