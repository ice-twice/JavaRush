package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private Provider[] providers;
    private List<Vacancy> vacancies = new ArrayList<>();

    public Controller(Provider... providers) {
        if (providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        for (Provider provider : providers) {
            List<Vacancy> vacs = provider.getJavaVacancies("киев");
            if (vacs != null) {
                vacancies.addAll(vacs);
            }
        }
        System.out.println(vacancies.size());
    }
}
