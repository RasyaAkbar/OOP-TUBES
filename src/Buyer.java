class Buyer extends Person {
    private double budget;

    public Buyer(String name, double budget) {
        super(name);
        this.budget = budget;
    }

    public boolean canBuy(double price) {
        return price <= budget;
    }

    public void purchase(double price) {
        if (price <= budget) {
            budget -= price;
        } else {
            System.out.println("Not enough budget!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Buyer: " + name + " | Remaining Budget: $" + budget);
    }
}

