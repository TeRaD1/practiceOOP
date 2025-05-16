package ex2.domain;

import java.io.*;
import java.util.Scanner;

/**
 * Клас {@code EnergySessionDemo} демонструє збереження та відновлення
 * стану об'єкта {@link EnergyData} за допомогою серіалізації.
 * <p>
 * Програма працює в діалоговому режимі, дозволяючи користувачу
 * ввести нові дані для розрахунку кінетичної енергії та зберегти їх,
 * або завантажити раніше збережені дані з файлу.
 * </p>
 * <p>
 * Особливість: поле {@code tempNote} класу {@link EnergyData} є transient і не зберігається.
 * </p>
 */
public class EnergySessionDemo {
    /** Ім'я файлу для збереження серіалізованих даних */
    private static final String FILE_NAME = "energy_session.ser";

    /**
     * Точка входу в програму.
     * Запитує користувача вибрати режим роботи,
     * зчитує дані, виконує розрахунок, зберігає або завантажує об'єкт {@code EnergyData}.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1 - Ввести нові дані та зберегти\n2 - Завантажити збережені дані\nВибір: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Введіть масу (кг): ");
            double mass = scanner.nextDouble();

            System.out.print("Введіть швидкість (м/с): ");
            double velocity = scanner.nextDouble();
            scanner.nextLine(); // зчитати залишок

            EnergyData data = new EnergyData(mass, velocity);

            System.out.print("Введіть службову нотатку (не буде збережена): ");
            String note = scanner.nextLine();
            data.setTempNote(note);

            EnergyCalculator calc = new EnergyCalculator(data);
            calc.calculate();

            saveData(data);
            System.out.println("Дані збережено:\n" + data);

        } else if (choice == 2) {
            EnergyData loaded = loadData();
            if (loaded != null) {
                System.out.println("Завантажені дані:\n" + loaded);
            }
        } else {
            System.out.println("Невірний вибір.");
        }
    }

    /**
     * Зберігає об'єкт {@code EnergyData} у файл за допомогою серіалізації.
     *
     * @param data об'єкт для збереження
     */
    private static void saveData(EnergyData data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні: " + e.getMessage());
        }
    }

    /**
     * Завантажує об'єкт {@code EnergyData} з файлу за допомогою десеріалізації.
     *
     * @return завантажений об'єкт або {@code null} у разі помилки
     */
    private static EnergyData loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (EnergyData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при завантаженні: " + e.getMessage());
            return null;
        }
    }
}
