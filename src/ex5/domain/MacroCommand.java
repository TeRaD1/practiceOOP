package ex5.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Макрокоманда — це колекція команд, які виконуються послідовно як одна операція.
 * Забезпечує можливість виконання та скасування всього набору команд.
 */
public class MacroCommand implements Command {
    /** Список команд, що входять до макрокоманди */
    private final List<Command> commands = new ArrayList<>();

    /**
     * Додає команду до макрокоманди.
     * @param command команда для додавання
     */
    public void add(Command command) {
        commands.add(command);
    }

    /**
     * Виконує усі команди послідовно.
     */
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    /**
     * Скасовує усі команди у зворотному порядку виконання.
     */
    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
