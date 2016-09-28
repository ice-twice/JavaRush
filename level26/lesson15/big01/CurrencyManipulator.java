package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    public String currencyCode;
    public Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        denominations.put(denomination, denominations.containsKey(denomination) ? denominations.get(denomination) + count : count);
    }

    public int getTotalAmount() {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            count += entry.getKey() * entry.getValue();
        }
        return count;
    }

    public boolean hasMoney() {
        if (denominations.isEmpty()) {
            return false;
        }
        for (Integer integer : denominations.keySet()) {
            if (integer > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        ArrayList<HashMap<Integer, Integer>> variantsReceiveBanknotes = new ArrayList<>();
        ArrayList<Integer> nominations = new ArrayList<>();
        nominations.addAll(denominations.keySet());
        Collections.sort(nominations, Collections.reverseOrder());

        for (int i = 0; i < nominations.size(); i++) {
            HashMap<Integer, Integer> result = new HashMap<>();
            int totalAmount = 0;
            for (int j = i; j < nominations.size(); j++) {
                Integer nomination = nominations.get(j);
                int needCountBanknotes = (expectedAmount - totalAmount) / nomination;
                int countBanknotesInMap = denominations.get(nomination);
                if (needCountBanknotes > 0 && needCountBanknotes <= countBanknotesInMap) {
                    totalAmount += needCountBanknotes * nomination;
                    result.put(nomination, needCountBanknotes);
                } else if (needCountBanknotes > countBanknotesInMap) {
                    totalAmount += countBanknotesInMap * nomination;
                    result.put(nomination, countBanknotesInMap);
                }
                if (totalAmount == expectedAmount) {
                    variantsReceiveBanknotes.add(result);
                    break;
                }
            }
        }

        if (variantsReceiveBanknotes.isEmpty()) {
            throw new NotEnoughMoneyException();
        }

        int minBanknotes = Integer.MAX_VALUE;
        int indexMinBanknotes = 0;
        for (int i = 0; i < variantsReceiveBanknotes.size(); i++) {
            int countBanknotes = 0;
            for (int value : variantsReceiveBanknotes.get(i).values()) {
                countBanknotes += value;
            }
            if (minBanknotes > countBanknotes) {
                minBanknotes = countBanknotes;
                indexMinBanknotes = i;
            }
        }

        for (Map.Entry<Integer, Integer> entry : variantsReceiveBanknotes.get(indexMinBanknotes).entrySet()) {
            denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
        }

        return variantsReceiveBanknotes.get(indexMinBanknotes);
    }
}
