package com.project.AdvanceProgProject;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
@Table(name = "rental_records")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private entity_car car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    private LocalDate rentalDate;
    private LocalDate returnDate;

    public RentalEntity() {}

    public RentalEntity(entity_car car, CustomerEntity customer, LocalDate rentalDate, LocalDate returnDate) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public entity_car getCar() { return car; }
    public void setCar(entity_car car) { this.car = car; }

    public CustomerEntity getCustomer() { return customer; }
    public void setCustomer(CustomerEntity customer) { this.customer = customer; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}


