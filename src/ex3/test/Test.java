package ex3.test;

import ex3.domain.*;
import ex2.domain.EnergyData;

/**
 * Клас для тестування роботи фабрики, колекції та відображення кінетичної енергії.
 * Виконує створення об'єктів, збереження та завантаження колекції.
 */
public class Test {
    /**
     * Головний метод запуску тесту.
     * Створює об'єкти кінетичної енергії, додає їх у колекцію,
     * виводить інформацію, зберігає колекцію у файл та завантажує її.
     *
     * @param args параметри командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        EnergyFactory factory = new KineticEnergyFactory();
        Collection collection = new Collection();

        // Створюємо об'єкт від фабрики і додаємо у колекцію
        Displayable displayable = factory.createDisplay(10.0, 5.0);
        collection.add(displayable);

        collection.printAll();
        
        // Збереження і завантаження
        collection.saveToFile("energy_collection.dat");
        Collection loaded = Collection.loadFromFile("energy_collection.dat");
        if (loaded != null) {
            loaded.printAll();
        }
    }
}
