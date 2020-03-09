package main.bean;

public class CarSkill {
    private int car_skill_id;
    private Car car_skill_car_id;
    private Skill car_skill_skill_id;
    private int car_skill_rate;

    public CarSkill() {
    }

    public CarSkill(int car_skill_id, Car car_skill_car_id, Skill car_skill_skill_id, int car_skill_rate) {
        this.car_skill_id = car_skill_id;
        this.car_skill_car_id = car_skill_car_id;
        this.car_skill_skill_id = car_skill_skill_id;
        this.car_skill_rate = car_skill_rate;
    }

    public int getCar_skill_id() {
        return car_skill_id;
    }

    public void setCar_skill_id(int car_skill_id) {
        this.car_skill_id = car_skill_id;
    }

    public Car getCar_skill_car_id() {
        return car_skill_car_id;
    }

    public void setCar_skill_car_id(Car car_skill_car_id) {
        this.car_skill_car_id = car_skill_car_id;
    }

    public Skill getCar_skill_skill_id() {
        return car_skill_skill_id;
    }

    public void setCar_skill_skill_id(Skill car_skill_skill_id) {
        this.car_skill_skill_id = car_skill_skill_id;
    }

    public int getCar_skill_rate() {
        return car_skill_rate;
    }

    public void setCar_skill_rate(int car_skill_rate) {
        this.car_skill_rate = car_skill_rate;
    }

    @Override
    public String toString() {
        return "CarSkill{" +
                "car_skill_id=" + car_skill_id +
                ", car_skill_car_id=" + car_skill_car_id +
                ", car_skill_skill_id=" + car_skill_skill_id +
                ", car_skill_rate='" + car_skill_rate + '\'' +
                '}';
    }
}
