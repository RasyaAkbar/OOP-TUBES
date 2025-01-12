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
            try{
                System.out.println("====== System for Selling Secondhand Item ======");
                System.out.println("\n==============================");
                System.out.println("Menu:");
                System.out.println("1. View Item");
                System.out.println("2. Make a Transaction");
                System.out.println("3. View People Info");
                System.out.println("4. Add Buyer");
                System.out.println("5. Add Seller");
                System.out.println("6. Add Item");
                System.out.println("7. Exit");
                System.out.println("==============================");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();


                if(choice == 1){
                    transaction.viewItem();
                }
                else if(choice == 2){
                    transaction.makeTransaction();
                }
                else if(choice == 3){
                    transaction.viewSellers();
                    transaction.viewBuyers();
                }
                else if (choice == 4){
                
                    transaction.addBuyer();
                    
                }
                else if (choice == 5){
                    transaction.addSeller();
                }
                else if (choice == 6){
                    transaction.addItem();    
                }
                else if(choice == 7){
                    System.out.println("Exiting the system.");
                    break;
                }
                else{
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Please enter the proper value!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
