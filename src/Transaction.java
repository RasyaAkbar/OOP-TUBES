import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private ArrayList<Seller> sellers;
    private ArrayList<Buyer> buyers;
    private ArrayList<Item> items;

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
        for (Item item : seller.getInventory()) {
            if (item.getId() == itemId) {
                itemToBuy = item;
                break;
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
        }

        // Complete transaction
        buyer.purchase(itemToBuy.getPrice());
        seller.incrementItemsSold();
        itemToBuy.setStock(itemToBuy.getStock()-1);

        System.out.println("Transaction successful! " + buyer.name + " purchased " + seller.getName() + " from " + seller.name);
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction();

        // Adding initial data
        Seller seller1 = new Seller("Alice");
        Seller seller2 = new Seller("Bob");
        transaction.addSeller(seller1);
        transaction.addSeller(seller2);

        Buyer buyer1 = new Buyer("Charlie", 500);
        Buyer buyer2 = new Buyer("Diana", 300);
        transaction.addBuyer(buyer1);
        transaction.addBuyer(buyer2);

        seller1.addItem(new Item(1, "Laptop", 400, "Good", 2));
        seller2.addItem(new Item(2, "Chair", 50, "Fair", 1));
        seller1.addItem(new Item(3, "Smartphone", 300, "Like New", 2));

        // Main menu
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Item");
            System.out.println("2. Make a Transaction");
            System.out.println("3. View People Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if(choice == 1){
                for(Seller seller: transaction.sellers){
                    seller.viewInventory();
                }
            }
            else if(choice == 2){
                System.out.print("Enter item ID: ");
                int itemId = scanner.nextInt();
                System.out.print("Enter buyer index (0 for Charlie, 1 for Diana): ");
                int buyerIndex = scanner.nextInt();
                System.out.print("Enter seller index (0 for Alice, 1 for Bob): ");
                int sellerIndex = scanner.nextInt();

                transaction.makeTransaction(itemId, transaction.buyers.get(buyerIndex), transaction.sellers.get(sellerIndex));
            }
            else if(choice == 3){
                System.out.println("\nSellers:");
                for (Seller seller : transaction.sellers) {
                    seller.displayInfo();
                }
                System.out.println("\nBuyers:");
                for (Buyer buyer : transaction.buyers) {
                    buyer.displayInfo();
                }
            }
            else if(choice == 4){
                System.out.println("Exiting the system.");
                break;
            }else{
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}

