public abstract class Person {
    protected int id;
    protected String name;

    

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(){
        id = 0;
        name = "";
    }

    public abstract void displayInfo();

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
