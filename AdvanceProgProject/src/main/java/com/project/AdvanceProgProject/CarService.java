package com.project.AdvanceProgProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private repository carRepository;

    public List<entity_car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<entity_car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public entity_car addCar(entity_car car) {
        if (car.getBrand() == null) {
            car.setAvailable(false);
        }
        return carRepository.save(car);
    }

    public entity_car updateCar(Long id, entity_car carDetails) {
        return carRepository.findById(id).map(car -> {
            car.setModel(carDetails.getModel());
            car.setBrand(carDetails.getBrand());
            car.setPricePerDay(carDetails.getPricePerDay());
            car.setAvailable(carDetails.isAvailable());
            return carRepository.save(car);
        }).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}

