package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public final class CommandExecutor {
    private static Map<Operation, Command> commandMap = new HashMap<>();

    static {
        commandMap.put(Operation.DEPOSIT, new DepositCommand());
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
        commandMap.put(Operation.LOGIN, new LoginCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        commandMap.get(operation).execute();
    }
}
