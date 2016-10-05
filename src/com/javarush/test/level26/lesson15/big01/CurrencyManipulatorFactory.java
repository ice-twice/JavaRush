package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory {
    public static HashMap<String, CurrencyManipulator> manipulatorMap = new HashMap<>();

    public CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for (Map.Entry<String, CurrencyManipulator> entry : manipulatorMap.entrySet()) {
            if (entry.getKey().equals(currencyCode)) {
                return entry.getValue();
            }
        }
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
        manipulatorMap.put(currencyCode, currencyManipulator);
        return currencyManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulatorMap.values();
    }
}
