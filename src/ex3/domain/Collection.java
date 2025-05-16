package ex3.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для зберігання та обробки колекції об'єктів, які реалізують інтерфейс Displayable.
 * Забезпечує додавання об'єктів, серіалізацію та десеріалізацію колекції.
 */
public class Collection implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Список об'єктів для відображення */
    private List<Displayable> dataList = new ArrayList<>();

    /**
     * Додає об'єкт Displayable до колекції.
     * @param data об'єкт для додавання
     */
    public void add(Displayable data) {
        dataList.add(data);
    }

    /**
     * Повертає всі об'єкти колекції.
     * @return список об'єктів Displayable
     */
    public List<Displayable> getAll() {
        return dataList;
    }

    /**
     * Зберігає поточну колекцію у файл.
     * @param filename ім'я файлу для збереження
     */
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні колекції: " + e.getMessage());
        }
    }

    /**
     * Завантажує колекцію з файлу.
     * @param filename ім'я файлу для завантаження
     * @return об'єкт Collection або null у разі помилки
     */
    public static Collection loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Collection) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при завантаженні колекції: " + e.getMessage());
            return null;
        }
    }

    /**
     * Формує список рядків із форматованими результатами кожного об'єкта Displayable.
     * @return список рядків з результатами
     */
    public List<String> getDisplayStrings() {
        List<String> result = new ArrayList<>();
        for (Displayable data : dataList) {
            result.add(data.getFormattedResult());
        }
        return result;
    }

    /**
     * Виводить у консоль усі форматовані результати об'єктів у колекції.
     */
    public void printAll() {
        for (String line : getDisplayStrings()) {
            System.out.println(line);
        }
    }
    /**
     * Видаляє останній доданий елемент з колекції.
     */
    public void removeLast() {
        if (!dataList.isEmpty()) {
            dataList.remove(dataList.size() - 1);
        }
    }
}
