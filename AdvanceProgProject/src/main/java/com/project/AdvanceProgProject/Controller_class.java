package com.project.AdvanceProgProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cars")
public class Controller_class {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<entity_car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Optional<entity_car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public entity_car addCar(@RequestBody entity_car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public entity_car updateCar(@PathVariable Long id, @RequestBody entity_car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
