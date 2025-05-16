package ex4.test;

import ex3.domain.Collection;
import ex3.domain.Displayable;
import ex4.domain.FactoryExtended;

import java.util.Scanner;

/**
 * Клас для тестування розширеної фабрики з підтримкою вибору формату виводу.
 * Дозволяє користувачу ввести масу, швидкість та обрати формат відображення:
 * текстовий або табличний (з можливістю власного форматування таблиці).
 */
public class TestTable {
    /**
     * Головний метод запуску тесту.
     * Зчитує вхідні дані від користувача, створює об'єкти відображення
     * за допомогою FactoryExtended та виводить їх на екран.
     *
     * @param args параметри командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        FactoryExtended factory = new FactoryExtended();
        Collection collection = new Collection();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть масу:");
        double mass = scanner.nextDouble();

        System.out.println("Введіть швидкість:");
        double velocity = scanner.nextDouble();

        System.out.println("Оберіть формат виводу: 1 - текстовий, 2 - таблиця");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очищаємо буфер після nextInt()

        Displayable displayable;

        if (choice == 2) {
            System.out.println("Бажаєте ввести власний формат таблиці? (так/ні):");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("так")) {
                System.out.println("Введіть заголовок таблиці (наприклад: | Маса | Швидкість | Енергія |):");
                String headerFormat = scanner.nextLine();

                System.out.println("Введіть формат рядка (використовуйте %mass%, %velocity%, %energy%):");
                String rowFormat = scanner.nextLine();

                displayable = factory.createTableDisplay(mass, velocity, headerFormat, rowFormat);
            } else {
                displayable = factory.createTableDisplay(mass, velocity);
            }
        } else {
            displayable = factory.createDisplay(mass, velocity);
        }

        collection.add(displayable);
        collection.printAll();

        scanner.close();
    }
}
