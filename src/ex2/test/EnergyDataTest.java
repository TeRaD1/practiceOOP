package ex2.test;

import ex2.domain.EnergyData;
import ex2.domain.EnergyCalculator;


import java.io.*;

/**
 * Клас {@code EnergyDataTest} для тестування коректності обчислень
 * та серіалізації/десеріалізації об'єктів {@link EnergyData}.
 * <p>
 * Виконує два основні тести:
 * <ul>
 *     <li>Перевірка правильності розрахунку кінетичної енергії.</li>
 *     <li>Перевірка коректності серіалізації та десеріалізації,
 *     зокрема, поведінки transient-поля {@code tempNote}.</li>
 * </ul>
 * </p>
 */
public class EnergyDataTest {
    /** Ім'я файлу для тестової серіалізації */
    private static final String TEST_FILE = "test_energy.ser";

    /**
     * Точка входу у тест.
     * Запускає тести розрахунку енергії та серіалізації.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        testCalculationCorrectness();
        testSerialization();
    }

    /**
     * Тестує правильність обчислення кінетичної енергії.
     * Порівнює очікуване значення з фактичним.
     */
    private static void testCalculationCorrectness() {
        EnergyData data = new EnergyData(2.0, 3.0); // Е = 0.5 * 2 * 9 = 9
        EnergyCalculator calc = new EnergyCalculator(data);
        calc.calculate();

        double expected = 9.0;
        double actual = data.getEnergy();

        System.out.println("Тест обчислення енергії:");
        if (Math.abs(expected - actual) < 1e-6) {
            System.out.println("✅ Успішно: Очікувано = " + expected + ", Отримано = " + actual);
        } else {
            System.out.println("❌ Помилка: Очікувано = " + expected + ", Отримано = " + actual);
        }
    }

    /**
     * Тестує серіалізацію та десеріалізацію об'єкта {@code EnergyData}.
     * Перевіряє, чи збережені дані коректно відновлюються,
     * а також чи поле {@code tempNote}, позначене як transient,
     * не серіалізується.
     */
    private static void testSerialization() {
        EnergyData original = new EnergyData(5.0, 4.0); // Е = 0.5 * 5 * 16 = 40
        original.setTempNote("Це тимчасова нотатка");
        EnergyCalculator calc = new EnergyCalculator(original);
        calc.calculate();

        save(original);
        EnergyData loaded = load();

        System.out.println("\nТест серіалізації/десеріалізації:");
        if (loaded != null &&
            Math.abs(loaded.getMass() - original.getMass()) < 1e-6 &&
            Math.abs(loaded.getVelocity() - original.getVelocity()) < 1e-6 &&
            Math.abs(loaded.getEnergy() - original.getEnergy()) < 1e-6) {

            System.out.println("✅ Успішно: Дані збережені та відновлені коректно");
        } else {
            System.out.println("❌ Помилка: Некоректне відновлення даних");
        }

        System.out.println("Перевірка transient-поля (tempNote):");
        if (loaded != null && loaded.getTempNote() == null) {
            System.out.println("✅ transient поле не було серіалізовано (очікувано)");
        } else {
            System.out.println("❌ transient поле збереглось, що неправильно");
        }
    }

    /**
     * Зберігає об'єкт {@code EnergyData} у файл для тестування серіалізації.
     *
     * @param data об'єкт для збереження
     */
    private static void save(EnergyData data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEST_FILE))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні (тест): " + e.getMessage());
        }
    }

    /**
     * Завантажує об'єкт {@code EnergyData} з файлу для тестування десеріалізації.
     *
     * @return завантажений об'єкт або {@code null} у разі помилки
     */
    private static EnergyData load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEST_FILE))) {
            return (EnergyData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при завантаженні (тест): " + e.getMessage());
            return null;
        }
    }
}
