package entities;

public class Product {

    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
    private String observation;

    public Product(Integer id, String name, Integer quantity, Double price, String observation) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.observation = observation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
