package main.bean;

import java.sql.Date;

public class Car {
    private int id;
    private Model model;
    private String type;
    private String brand;
    private int price;
    private String engine;
    private String placeofbirth;
    private Date year;
    private String transmission;
    private String fueltype;
    private String details;

    public Car(int id, Model model, String type, String brand, String color, int price, String engine, String placeofproduction, Date year, String transmission, String fueltype, String details) {
    }

    public Car(int id, Model model, String type, String brand, int price, String engine, String placeofbirth, Date year, String transmission, String fueltype, String details) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.engine = engine;
        this.placeofbirth = placeofbirth;
        this.year = year;
        this.transmission = transmission;
        this.fueltype = fueltype;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model=" + model +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", engine='" + engine + '\'' +
                ", placeofbirth='" + placeofbirth + '\'' +
                ", year=" + year +
                ", transmission='" + transmission + '\'' +
                ", fueltype='" + fueltype + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
