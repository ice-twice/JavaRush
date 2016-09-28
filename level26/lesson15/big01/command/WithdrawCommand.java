package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String sSum = ConsoleHelper.readString();
            try {
                int sum = Integer.parseInt(sSum);
                if (currencyManipulator.isAmountAvailable(sum)) {
                    try {
                        Map<Integer, Integer> withdrawAmountMap = currencyManipulator.withdrawAmount(sum);
                        ArrayList<Integer> nominations = new ArrayList<>();
                        nominations.addAll(withdrawAmountMap.keySet());
                        Collections.sort(nominations, Collections.reverseOrder());
                        for (int i : nominations) {
                            ConsoleHelper.writeMessage("\t" + i + " - " + withdrawAmountMap.get(i));
                        }
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currencyCode));
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                        continue;
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}