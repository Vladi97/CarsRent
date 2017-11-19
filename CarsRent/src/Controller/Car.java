/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

/**
 *
 * @author vmata
 */
public class Car {
    private Model.Car car;

    public Car() {
        car = new Model.Car();
    }

    public Car(Model.Car car) {
        this.car = car;
    }
    
    /**
     * 
     * @returns a boolean value to know if it really added/updated the car or is something failed
     * @throws Exception 
     */
    public boolean add() throws Exception {
        if (car.getAge() == 0) {
            throw new Exception("The age of the car is required, please, type it");
        }
        if (car.getBrand()==0) {
            throw new Exception("Please, select the brand of this car");
        }
        if (car.getLicense_plate().isEmpty()) {
            throw new Exception("Please, type the license plate of this car");
        }
        if (car.getModel()==0) {
            throw new Exception("Please, select the model of this car");
        }
        if (car.getPrice()==0) {
            throw new Exception("Please, add a price for this car");
        }
        if (car.getStyle()==0) {
            throw new Exception("Please, select the style of this car");
        }
        if (car.getTransmission().isEmpty()) {
            throw new Exception("Please, type the transmission of this car");
        }
        if (car.getId() > 0) {
            return car.update();
        } else {
            return car.add();
        }
    }

    /**
     * 
     * @returns a boolean value to know if it really deleted the car or is something failed
     * @throws Exception 
     */
    public boolean delete() throws Exception {
        if (car.getId() <= 0) {
            throw new Exception("Please, the id is required to delete");
        }
        return car.delete();
    }

    /**
     * 
     * @returns a list with all the cars 
     */
    public LinkedList<Model.Car> select() {
        return car.select();
    }
}
