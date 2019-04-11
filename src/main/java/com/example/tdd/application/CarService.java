package com.example.tdd.application;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;

    }

    public Car getCarDetails(String carName) {
        Car car = carRepository.findByName(carName);
        if(car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
