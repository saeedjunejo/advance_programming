package com.project.AdvanceProgProject;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")

public class entity_car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String car_model;
    private String car_brand;
    private double car_pricePerDay=0;
    private boolean car_available= true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return car_model;
    }

    public void setModel(String model_car) {
        this.car_model = model_car;
    }

    public String getBrand() {
        return car_brand;
    }

    public void setBrand(String brand_car) {
        this.car_brand = brand_car;
    }

    public double getPricePerDay() {
        return car_pricePerDay;
    }

    public void setPricePerDay(double pricePerDay_car) {
        this.car_pricePerDay = 100.0;
    }

    public boolean isAvailable() {
        return car_available;
    }

    public void setAvailable(boolean available_car) {
        this.car_available = available_car;
    }
}
