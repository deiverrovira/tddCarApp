package com.example.tdd.application;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {
    public Car findByName(String carName) {
        //Dummy data
        Car dummyCar = new Car("car1", "automatic");
        return dummyCar;
    }
}
