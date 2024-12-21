import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        
        // Adding initial data
        Seller seller1 = new Seller(transaction.getSellers().size()+1, "Rasya");
        transaction.addSeller(seller1);
        Seller seller2 = new Seller(transaction.getSellers().size()+1, "Hakim");
        transaction.addSeller(seller2);

        Buyer buyer1 = new Buyer(transaction.getBuyers().size()+1, "Daru", 500);
        transaction.addBuyer(buyer1);
        Buyer buyer2 = new Buyer(transaction.getBuyers().size()+1, "Thiflan", 300);
        transaction.addBuyer(buyer2);


        Item item1 = new Item(transaction.getItems().size()+1, "Laptop", 400, "Good", 2);
        transaction.addItem(item1);
        Item item2 = new Item(transaction.getItems().size()+1, "Chair", 50, "Fair", 1);
        transaction.addItem(item2);
        Item item3 = new Item(transaction.getItems().size()+1, "Smartphone", 300, "Like New", 2);
        transaction.addItem(item3);

        seller1.addItem(item1);
        seller2.addItem(item2);
        seller1.addItem(item3);
        
        
        

        // Main menu
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Item");
            System.out.println("2. Make a Transaction");
            System.out.println("3. View People Info");
            System.out.println("4. Add Buyer");
            System.out.println("5. Add Seller");
            System.out.println("6. Add Item");
            System.out.println("7. Update Buyer");
            System.out.println("8. Update Item");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                for(Seller seller: transaction.getSellers()){
                    seller.viewInventory();
                }
            }
            else if(choice == 2){
                for (Item item : transaction.getItems()) {
                    item.displayItem();
                }
                System.out.print("Enter item ID: ");
                int itemId = scanner.nextInt();
                System.out.print("Enter buyer index (1 for Daru, 2 for Thiflan): ");
                int buyerIndex = scanner.nextInt();
                System.out.print("Enter seller index (1 for Rasya, 2 for Hakim): ");
                int sellerIndex = scanner.nextInt();

                transaction.makeTransaction(itemId-1, transaction.getBuyers().get(buyerIndex-1), transaction.getSellers().get(sellerIndex-1));
            }
            else if(choice == 3){
                System.out.println("\nSellers:");
                for (Seller seller : transaction.getSellers()) {
                    seller.displayInfo();
                }
                System.out.println("\nBuyers:");
                for (Buyer buyer : transaction.getBuyers()) {
                    buyer.displayInfo();
                }
            }
            else if (choice == 4){
            
                System.out.print("Enter buyer name: ");
                String buyerName = scanner.nextLine();
                System.out.print("Enter buyer's balance: ");
                float buyerBalance = scanner.nextFloat();

                scanner.nextLine();
                transaction.addBuyer(new Buyer(transaction.getBuyers().size()+1, buyerName, buyerBalance));
                System.out.println("Buyer added");
            }
            else if (choice == 5){
                System.out.print("Enter seller name: ");
                String sellerName = scanner.nextLine();
                transaction.addSeller(new Seller(transaction.getSellers().size()+1, sellerName));
                System.out.println("Seller added");
            }
            else if (choice == 6){
    
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
                Item newItem = new Item(transaction.getItems().size()+1, itemName, itemPrice, itemCondition, itemStock);
                transaction.addItem(newItem);
                System.out.println("\nSellers:");
                for (Seller seller : transaction.getSellers()) {
                    seller.displayInfo();
                }
                System.out.print("Pick seller to assign the item to: ");
                int idx = scanner.nextInt();
                transaction.getSellers().get(idx).addItem(newItem);
                System.out.println("item added");

            }else if(choice == 7){
                System.out.println("\nBuyers:");
                for (Buyer buyer : transaction.getBuyers()) {
                    buyer.displayInfo();
                }
                System.out.print("Select buyer you want to update: ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Update name: ");
                String name = scanner.nextLine();
                System.out.print("Update budget: ");
                double budget = scanner.nextDouble();
                scanner.nextLine();
                transaction.getBuyers().get(idx).setBudget(budget);
                transaction.getBuyers().get(idx).setName(name);
                System.out.println("Buyer updated.");
            }else if(choice == 8){
                System.out.println("\nSellers:");
                for (Seller seller : transaction.getSellers()) {
                    seller.displayInfo();
                }
                System.out.print("Select seller you want to update: ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Update name: ");
                String name = scanner.nextLine();
                scanner.nextLine();
                transaction.getSellers().get(idx).setName(name);
                System.out.println("Seller updated.");
            }
            else if(choice == 9){
                System.out.println("\nItems:");
                for (Item item : transaction.getItems()) {
                    item.displayItem();
                }
                System.out.print("Select item id to update: ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Update item name: ");
                String itemName = scanner.nextLine();
                System.out.print("Update item price: ");
                double itemPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Update item condition: ");
                String itemCondition = scanner.nextLine();
                System.out.print("Update item stock: ");
                int itemStock = scanner.nextInt();
                scanner.nextLine();

                transaction.getItems().get(idx).setItemName(itemName);
                transaction.getItems().get(idx).setPrice(itemPrice);
                transaction.getItems().get(idx).setCondition(itemCondition);
                transaction.getItems().get(idx).setStock(itemStock);
                
                System.out.println("Item updated");
            }else if(choice == 10){
                System.out.println("Exiting the system.");
                break;
            }else{
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
