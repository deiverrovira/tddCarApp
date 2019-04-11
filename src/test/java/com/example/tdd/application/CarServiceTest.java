package com.example.tdd.application;

import javafx.scene.text.FontPosture;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Before
    public void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_ReturnWithDetails() {

        //setup
        given(carRepository.findByName("car1")).willReturn(new Car("car1", "automatic"));

        //act
        Car car = carService.getCarDetails("car1");

        //assert
        Assertions.assertThat(car.getName()).isEqualTo("car1");
        Assertions.assertThat(car.getType()).isEqualTo("automatic");

    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_CarNotFound() throws Exception {

        given(carRepository.findByName("car1")).willReturn(null);

        carService.getCarDetails("car1");

    }
}