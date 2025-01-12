import java.util.ArrayList;
import java.util.Scanner;

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

    /*public void viewItem() {
        System.out.println("==============================");
        for (Item item : items) {
            item.displayItem();
        }
        System.out.println("==============================");
    }*/

    public void viewItem() {
        System.out.println("==============================");
        for(Seller seller: getSellers()){
            seller.viewInventory();
        }
        System.out.println("==============================");
    }

    public void viewBuyers() {
        System.out.println("==============================");
        System.out.println("Buyers:");
        for (Buyer buyer : getBuyers()) {
            buyer.displayInfo();
        }
        System.out.println("==============================");
    }

    public void viewSellers() {
        System.out.println("==============================");
        System.out.println("Sellers:");
        for (Seller seller : getSellers()) {
            seller.displayInfo();
        }
        System.out.println("==============================");
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
    



    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public void setBuyers(ArrayList<Buyer> buyers) {
        this.buyers = buyers;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void makeTransaction() {
        Scanner scanner = new Scanner(System.in);

        
        viewItem();
        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();

        viewBuyers();

        int buyerIndex = 0;
        while(true){
            System.out.print("Enter buyer index : ");
            buyerIndex = scanner.nextInt();
            if(buyerIndex>0 && buyerIndex <= getBuyers().size()){
                break;
            }
            System.out.println("Buyer don't exist");
        }

        viewSellers();
        int sellerIndex = 0;
        while(true){
            System.out.print("Enter seller index : ");
            sellerIndex = scanner.nextInt();
            if(sellerIndex>0 && sellerIndex <= getSellers().size()){
                break;
            }
            System.out.println("Seller don't exist");
        }
        
        scanner.nextLine();
        int quantity = 0;
        while (true) {
            System.out.print("Enter desired quantity: ");
            quantity = scanner.nextInt();
            if (quantity > 0) break;
            System.out.println("Quantity must be a positive number!");
        }
        scanner.nextLine();

        Item itemToBuy = null;
        Seller seller = getSellers().get(sellerIndex-1);
        Buyer buyer = getBuyers().get(buyerIndex-1);
        // Find the item
        for(int i=0; i<seller.getInventory().size(); i++){
            if(seller.getInventory().get(i).getId()==itemId){
                itemToBuy=seller.getInventory().get(i);
            }
        }
        //scanner.close();
        if (itemToBuy == null) {
            System.out.println("Item not found!");
            return;
        }else if (quantity > itemToBuy.getStock()) {
            System.out.println("Stock is not enough. Stock available: " + itemToBuy.getStock());
            return;
        }else if (!buyer.canBuy(itemToBuy.getPrice())) {
            System.out.println("Buyer cannot afford this item!");
            return;
        }else if(itemToBuy.getStock() == 0){
            System.out.println("Item stock is 0");
            return;
        }

        // Complete transaction
        if(!buyer.purchase(itemToBuy.getPrice()*quantity)) return;
        
        seller.incrementItemsSold(quantity);
        itemToBuy.setStock(itemToBuy.getStock()-quantity);

        System.out.println("Transaction successful! " + buyer.name + " purchased " + itemToBuy.getItemName() + " from " + seller.name);
        
    }

    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter item condition: ");
        String itemCondition = scanner.nextLine();
        System.out.print("Enter item stock: ");
        int itemStock = scanner.nextInt();
        scanner.nextLine();

        Item newItem = new Item(getItems().size()+1, itemName, itemPrice, itemCondition, itemStock);
        addItem(newItem);

        viewSellers();

        int sellerIndex = 0;
        while(true){
            System.out.print("Pick seller to assign the item to: ");
            sellerIndex = scanner.nextInt();
            if(sellerIndex>0 && sellerIndex <= getSellers().size()){
                break;
            }
            System.out.println("Seller don't exist");
        }
        getSellers().get(sellerIndex-1).addItem(newItem);
        System.out.println("item added");
        //scanner.close();
    }

    public void addBuyer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter buyer name: ");
        String buyerName = scanner.nextLine();
        System.out.print("Enter buyer's balance: ");
        float buyerBalance = scanner.nextFloat();

        scanner.nextLine();
        addBuyer(new Buyer(getBuyers().size()+1, buyerName, buyerBalance));
        System.out.println("Buyer added");
        ////scanner.close();
    }

    public void addSeller() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter seller name: ");
        String sellerName = scanner.nextLine();
        addSeller(new Seller(getSellers().size()+1, sellerName));
        System.out.println("Seller added");
        //scanner.close();
    }
}

