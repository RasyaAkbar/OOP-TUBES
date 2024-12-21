import java.util.ArrayList;

public class Transaction {
    private ArrayList<Seller> sellers;
    private ArrayList<Buyer> buyers;
    private ArrayList<Item> items;

    

    public Transaction(ArrayList<Seller> sellers, ArrayList<Buyer> buyers, ArrayList<Item> items) {
        this.sellers = sellers;
        this.buyers = buyers;
        this.items = items;
    }

    public Transaction() {
        sellers = new ArrayList<>();
        buyers = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void viewItem() {
        for (Item item : items) {
            item.displayItem();
        }
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void makeTransaction(int itemId, Buyer buyer, Seller seller) {
        Item itemToBuy = null;

        // Find the item
        for(int i=0; i<items.size(); i++){
            if(i==itemId){
                itemToBuy=items.get(i);
            }
        }

        if (itemToBuy == null) {
            System.out.println("Item not found!");
            return;
        }else if (!buyer.canBuy(itemToBuy.getPrice())) {
            System.out.println("Buyer cannot afford this item!");
            return;
        }else if(itemToBuy.getStock() == 0){
            System.out.println("Item stock is 0");
            return;
        }

        // Complete transaction
        buyer.purchase(itemToBuy.getPrice());
        seller.incrementItemsSold();
        itemToBuy.setStock(itemToBuy.getStock()-1);

        System.out.println("Transaction successful! " + buyer.name + " purchased " + itemToBuy.getItemName() + " from " + seller.name);
    }

    
}

