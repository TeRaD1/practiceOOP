package ex5.domain;

import ex3.domain.Collection;
import ex3.domain.Displayable;

/**
 * Команда для додавання елемента у колекцію.
 * Реалізує патерн Команда (Command) з підтримкою скасування (undo).
 */
public class AddEnergyCommand implements Command {
    /** Колекція, до якої додається елемент */
    private final Collection collection;
    /** Об'єкт, який додається до колекції */
    private final Displayable displayable;

    /**
     * Конструктор команди додавання.
     * @param collection колекція для додавання
     * @param displayable об'єкт для додавання
     */
    public AddEnergyCommand(Collection collection, Displayable displayable) {
        this.collection = collection;
        this.displayable = displayable;
    }

    /**
     * Виконує команду — додає об'єкт до колекції.
     */
    @Override
    public void execute() {
        collection.add(displayable);
    }

    /**
     * Відміняє виконану команду — видаляє останній доданий об'єкт з колекції.
     */
    @Override
    public void undo() {
        collection.removeLast();
    }
}
