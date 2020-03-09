package main.dao.impl;


import main.bean.Car;
import main.bean.CarSkill;
import main.bean.Model;
import main.bean.Skill;
import main.dao.inter.AbstractDAO;
import main.dao.inter.CarDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl extends AbstractDAO implements CarDaoInter {
    private Car getCar(ResultSet rs) throws  Exception{
        int id = rs.getInt("car_Id");
        int modelId = rs.getInt("car_Model_Id");
        String modelName = rs.getString("modelname");
        String type = rs.getString("car_Type_Id");
        String brand = rs.getString("car_Brand_Id");
        String color = rs.getString("car_Color");
        int price = rs.getInt("car_Price");
        String engine = rs.getString("car_Engine");
        String placeofproduction = rs.getString("car_PlaceofProduction_Id");
        Date year = rs.getDate("car_Year");
        String transmission = rs.getString("car_Transmission");
        String fueltype = rs.getString("car_Fuel_Type");
        String details = rs.getString("car_Details");

        Model model = new Model(modelId,modelName);

        return new Car(id, model, type, brand, color, price, engine, placeofproduction, year, transmission, fueltype, details);

    }

    private CarSkill getCarSkill(ResultSet rs) throws  Exception{
        int car_skill_Id = rs.getInt("car_skill_Id");
        int car_skill_Car_Id = rs.getInt("car_skill_Car_Id");
        String skill_name = rs.getString("skill_Name");
        int car_skill_Skill_Id = rs.getInt("car_skill_Skill_Id");
        int car_skill_Rate = rs.getInt("car_skill_Rate");

        return new CarSkill(car_skill_Id, new Car(car_skill_Car_Id), new Skill(car_skill_Skill_Id,skill_name), car_skill_Rate);
    }
    public List<Car> getAll() {
        List<Car> result = new ArrayList<>();
        try ( Connection conn = connect() ) {
            Statement stmt = conn.createStatement();
            stmt.execute("select c.*," +
                    "           m.model_name as modelname" +
                    "           from  cars c" +
                    "           left join models m on c.car_Model_Id = m.model_id;");
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                Car car = getCar(rs);
                result.add(car);
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
            stmt.execute("select c.*," +
                    "               m.model_name as modelname" +
                    "               from  cars c" +
                    "               left join models m on c.car_Model_Id = m.model_id where car_Id = "+car_Id);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                result = getCar(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addCar(Car car) {
        /*try(Connection conn = connect()) {

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
        }*/
        return true;
    }

    public boolean updateCar(Car car) {

        /*try(Connection conn = connect()) {

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
        } */
        return true;
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

    @Override
    public List<CarSkill> getAllCarSkillByCarId(int carId) {
        List<CarSkill> result = new ArrayList<>();
        try ( Connection conn = connect() ) {
            PreparedStatement stmt = conn.prepareStatement("select" +
                    "    c.*," +
                    "    cs.car_skill_Skill_Id," +
                    "    s.skill_Name as Skill_Name," +
                    "    cs.car_skill_Rate" +
                    "from" +
                    "    cars_skills cs" +
                    "left join cars c on cs.car_skill_Car_Id =c.car_Id" +
                    "left join skills s on cs.car_skill_Skill_Id = s.skill_Id" +
                    "where" +
                    "    cs.car_skill_Car_Id = ?;");
            stmt.setInt(1,carId);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                CarSkill carSkill = getCarSkill(rs);
                result.add(carSkill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
