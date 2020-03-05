package main.dao.impl;

import main.bean.Car;
import main.dao.inter.AbstractDAO;
import main.dao.inter.CarDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl extends AbstractDAO implements CarDaoInter {
    public List<Car> getAll() {

        List<Car> result = new ArrayList<>();

        try ( Connection conn = connect() ) {

            Statement stmt = conn.createStatement();
            stmt.execute("select * from cars");
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                int id = rs.getInt("car_Id");
                String model = rs.getString("car_Model");
                String type = rs.getString("car_Type");
                String brand = rs.getString("car_Brand");
                String price = rs.getString("car_Price");
                String engine = rs.getString("car_Engine");
                String year = rs.getString("car_Year");

                result.add(new Car(id, model, type, brand, price, engine, year));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Car getById(int car_Id) {
        Car result = null;

        try ( Connection conn = connect() ) {

            Statement stmt = conn.createStatement();
            stmt.execute("select * from cars where car_Id = "+car_Id);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                int id = rs.getInt("car_Id");
                String model = rs.getString("car_Model");
                String type = rs.getString("car_Type");
                String brand = rs.getString("car_Brand");
                String price = rs.getString("car_Price");
                String engine = rs.getString("car_Engine");
                String year = rs.getString("car_Year");

                result = new Car(id, model, type, brand, price, engine, year);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean addCar(Car car) {
        try(Connection conn = connect()) {

            //Statement stmt = conn.createStatement(); //SQL injectionun qarshisini almaq ucun create statementden istifade olunmamaq meslehet gorulur.
            PreparedStatement stmt = conn.prepareStatement("insert into cars (car_Model, car_Type," +
                    "                                                       car_Brand, car_Price, " +
                    "                                                       car_Engine, car_Year)" +
                    "                                                       values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1,car.getModel());
            stmt.setString(2,car.getType());
            stmt.setString(3,car.getBrand());
            stmt.setString(4,car.getPrice());
            stmt.setString(5,car.getEngine());
            stmt.setString(6, car.getYear());
            return stmt.execute();

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateCar(Car car) {

        try(Connection conn = connect()) {

            //Statement stmt = conn.createStatement(); //SQL injectionun qarshisini almaq ucun create statementden istifade olunmamaq meslehet gorulur.
            PreparedStatement stmt = conn.prepareStatement("update cars " +
                    "                                           set car_Model=?, car_Type=?," +
                    "                                               car_Brand=?, car_Price=?," +
                    "                                               car_Engine=?, car_Year=? where car_id=?");
            stmt.setString(1,car.getModel());
            stmt.setString(2,car.getType());
            stmt.setString(3,car.getBrand());
            stmt.setString(4,car.getPrice());
            stmt.setString(5,car.getEngine());
            stmt.setString(6,car.getYear());
            stmt.setInt(7,car.getId());
            return stmt.execute();

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeCar(int id) {
        try {
            Connection conn = connect();

            Statement stmt = conn.createStatement();
            stmt.execute("DELETE from cars where car_id ="+id);

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
