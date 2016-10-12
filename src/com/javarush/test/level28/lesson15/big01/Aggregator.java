package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new Strategy() {
            @Override
            public List<Vacancy> getVacancies(String searchString) {
                return null;
            }
        });
        Controller controller = new Controller(provider);
        controller.scan();
    }
}

