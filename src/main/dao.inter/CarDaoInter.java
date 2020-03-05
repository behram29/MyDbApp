package main.dao.inter;

import main.bean.Car;

import java.util.List;

public interface CarDaoInter {
    public List<Car> getAll();
    public Car getById(int id);
    public boolean addCar(Car car);
    public boolean updateCar(Car car);
    public boolean removeCar(int id);

}
