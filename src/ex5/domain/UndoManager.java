package ex5.domain;

import java.util.Stack;

/**
 * Менеджер для керування історією виконаних команд з можливістю скасування (undo).
 * Реалізований за шаблоном Singleton, щоб забезпечити єдину точку управління.
 */
public class UndoManager {
    /** Єдиний екземпляр UndoManager */
    private static UndoManager instance;
    /** Стек історії виконаних команд */
    private final Stack<Command> history = new Stack<>();

    /** Приватний конструктор для запобігання створенню об'єктів ззовні */
    private UndoManager() {}

    /**
     * Повертає єдиний екземпляр UndoManager.
     * @return інстанс UndoManager
     */
    public static UndoManager getInstance() {
        if (instance == null) {
            instance = new UndoManager();
        }
        return instance;
    }

    /**
     * Виконує команду і додає її до історії для можливого скасування.
     * @param command команда для виконання
     */
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    /**
     * Скасовує останню виконану команду, якщо вона є в історії.
     * Якщо історія порожня, виводить відповідне повідомлення.
     */
    public void undo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("Немає команд для скасування.");
        }
    }
}
