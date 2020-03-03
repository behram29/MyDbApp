package main;

import main.dao.impl.CarDaoImpl;
import main.dao.inter.CarDaoInter;

public class Context {
    public static CarDaoInter instanceCarDao(){
        return new CarDaoImpl();
    }
}
