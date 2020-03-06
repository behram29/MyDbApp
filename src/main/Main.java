package main;

import main.bean.Car;
import main.dao.impl.CarDaoImpl;
import main.dao.inter.CarDaoInter;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        CarDaoInter carDao = Context.instanceCarDao();

        //Car car  = new Car(0,"Rio", "Liftback", "Kia", "12000", "1.5", "2009");

        //Car car = carDao.getById(2);
        //car.setModel("Avante Dizel");
        //carDao.updateCar(car);
        //carDao.getAll(car);
        //carDao.getById(car);
        //carDao.addCar(car);
        //carDao.removeCar(1);

        List<Car> cars = carDao.getAll();
        System.out.println("Cars="+cars);
        //System.out.println("------------------------------------------");
    }


}