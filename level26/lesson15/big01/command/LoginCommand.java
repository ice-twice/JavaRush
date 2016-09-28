package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String sLogin = ConsoleHelper.readString();
            String sPassword = ConsoleHelper.readString();
            if (sLogin != null && sPassword != null && sLogin.length() == 12 && sPassword.length() == 4) {
                try {
                    Long.parseLong(sLogin);
                    Integer.parseInt(sPassword);
                    if (validCreditCards.containsKey(sLogin) && validCreditCards.getString(sLogin).equals(sPassword)) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sLogin));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), sLogin));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {

                }
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), sLogin));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
