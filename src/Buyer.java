public class Buyer extends Person {
    private double budget;


    public Buyer(int id, String name, double budget) {
        super(id, name);
        this.budget = budget;
    }

    public Buyer (){
        budget = 0;
    }

    public boolean canBuy(double price) {
        return price <= budget;
    }

    public boolean purchase(double price) {
        if (price <= budget) {
            this.budget = budget - price;
            return true;
        } else {
            System.out.println("Not enough budget!");
            return false;
        }
    }

    
    public int getId() {
        return id;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + " | Buyer: " + name + " | Remaining Budget: $" + budget);
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}

