package com.project.AdvanceProgProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")

public class RentalController {

    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping
    public List<RentalEntity> getAllRentals() {
        return rentalRepository.findAll();
    }


    @GetMapping("/{id}")
    public RentalEntity getRentalById(@PathVariable Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental record not found"));
    }

    @PostMapping
    public RentalEntity addRental(@RequestBody RentalEntity rentalRecord) {
        return rentalRepository.save(rentalRecord);
    }

    @PutMapping("/{id}")
    public RentalEntity updateRental(@PathVariable Long id, @RequestBody RentalEntity updatedRental) {
        return rentalRepository.findById(id).map(rental -> {
            rental.setReturnDate(updatedRental.getReturnDate());
            return rentalRepository.save(rental);
        }).orElseThrow(() -> new RuntimeException("Rental record not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteRental(@PathVariable Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
            return "Rental record deleted successfully";
        } else {
            throw new RuntimeException("Rental record not found");
        }
    }
}
