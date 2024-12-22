class Item {
    private int id;
    private String itemName;
    private double price;
    private String condition;
    private int stock;
 


    public Item(int id, String itemName, double price, String condition, int stock) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.condition = condition;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void displayItem() {
        System.out.println("ID: " + id + " | Name: " + itemName + " | Price: $" + price + " | Condition: " + condition + " | Stock: "+ stock );
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}

