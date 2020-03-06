package main.bean;

public class Model {
    private int model_id;
    private String model_name;

    public Model() {
    }

    public Model(int model_id, String model_name) {
        this.model_id = model_id;
        this.model_name = model_name;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model_id=" + model_id +
                ", model_name='" + model_name + '\'' +
                '}';
    }
}
