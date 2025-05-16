package ex5.test;

import ex3.domain.Collection;
import ex3.domain.Displayable;
import ex4.domain.FactoryExtended;
import ex5.domain.*;

import java.util.Scanner;

/**
 * Клас для демонстрації роботи з командами через консольний діалоговий інтерфейс користувача.
 * Дозволяє додавати енергію, виводити всі елементи, скасовувати останню дію та виконувати макрокоманди.
 */
public class CommandTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection collection = new Collection();
        FactoryExtended factory = new FactoryExtended();
        UndoManager undoManager = UndoManager.getInstance();

        while (true) {
            System.out.println(
                "1. Додати енергію\n" +
                "2. Вивести всі\n" +
                "3. Скасувати останню дію\n" +
                "4. Макрокоманда (2 додавання)\n" +
                "0. Вихід\n" +
                "Ваш вибір: "
            );

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Displayable d = readDisplayable(scanner, factory);
                    Command cmd = new AddEnergyCommand(collection, d);
                    undoManager.executeCommand(cmd);
                    break;
                case 2: collection.printAll(); break;
                case 3: undoManager.undo(); break;
                case 4:
                    MacroCommand macro = new MacroCommand();
                    System.out.println("Перше додавання:");
                    macro.add(new AddEnergyCommand(collection, readDisplayable(scanner, factory)));
                    System.out.println("Друге додавання:");
                    macro.add(new AddEnergyCommand(collection, readDisplayable(scanner, factory)));
                    undoManager.executeCommand(macro);
                    break;
                case 0:
                    System.out.println("До побачення!");
                    return;
                default: System.out.println("Невірний вибір."); break;
            }
        }
    }

    /**
     * Зчитує дані маси та швидкості з консолі та створює об'єкт Displayable за допомогою фабрики.
     * @param scanner об'єкт Scanner для зчитування вводу користувача
     * @param factory фабрика для створення об'єкта Displayable
     * @return створений об'єкт Displayable
     */
    private static Displayable readDisplayable(Scanner scanner, FactoryExtended factory) {
        System.out.println("Введіть масу:");
        double mass = scanner.nextDouble();
        System.out.println("Введіть швидкість:");
        double velocity = scanner.nextDouble();

        return factory.createTableDisplay(mass, velocity);
    }
}
