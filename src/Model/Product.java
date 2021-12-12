package Model;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private String addedBy;

    public Product(String id, String name, double price, String category, String addedBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.addedBy=addedBy;
    }

    public Product()
    {
        super();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
}
