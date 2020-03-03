package main;

import main.bean.Car;
import main.dao.impl.CarDaoImpl;
import main.dao.inter.CarDaoInter;

public class Main {
    public static void main(String[] args) throws Exception {
        CarDaoInter carDao = Context.instanceCarDao();

        //List<Car> cars = carDao.getAll();
        //System.out.println("Cars="+cars);

        Car car = carDao.getById(2);
        car.setModel("Avante Dizel");
        carDao.updateCar(car);
        System.out.println("Car = "+car);
        System.out.println("------------------------------------------");
    }


}