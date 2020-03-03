package main.bean;

public class Car {
    private int id;
    private String model;
    private String type;
    private String brand;
    private String price;
    private String engine;
    private String year;

    public Car() {
    }

    public Car(int id, String model, String type, String brand, String price, String engine, String year) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.engine = engine;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", engine='" + engine + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
