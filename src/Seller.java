import java.util.ArrayList;

public class Seller extends Person {
    private ArrayList<Item> inventory;
    private int itemsSold;

    public Seller(int id, String name) {
        super(id, name);
        this.inventory = new ArrayList<>();
        itemsSold = 0;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    /*public Item sellItem(int itemId) {
        for (Item item : inventory) {
            if (item.getId() == itemId) {
                item.setStock(item.getStock()-1);
                return item;
            }
        }
        return null; // Item not found
    }*/

    public void viewInventory() {
        System.out.println("Seller: "+name + " | ID: "+ id);
        for (Item item : inventory) {
            item.displayItem();
        }
    }

    
    public int getId() {
        return id;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void incrementItemsSold(){
        itemsSold++;
    }
    public void incrementItemsSold(int quantity){
        itemsSold+=quantity;
    }
    
    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + " | Seller: " + name + " | Items Sold: " + itemsSold);
    }

    public void displayNameAndId() {
        System.out.println("Seller: " + name + " ID: " + id);
    }

    public int getItemsSold() {
        return itemsSold;
    }
}
