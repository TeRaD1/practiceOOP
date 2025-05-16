package ex6.test;

import ex3.domain.Collection;
import ex3.domain.Displayable;
import ex4.domain.FactoryExtended;
import ex5.domain.AddEnergyCommand;
import ex6.domain.CommandWorker;
import ex6.domain.ParallelProcessor;

import java.util.List;

/**
 * Тестовий клас для демонстрації паралельної обробки та Worker Thread.
 */
public class ParallelAndWorkerTest {

    public static void main(String[] args) throws InterruptedException {
        Collection collection = new Collection();
        FactoryExtended factory = new FactoryExtended();

        // Додаємо кілька елементів у колекцію
        collection.add(factory.createTableDisplay(10, 20));
        collection.add(factory.createTableDisplay(15, 10));
        collection.add(factory.createTableDisplay(7, 5));
        collection.add(factory.createTableDisplay(30, 12));

        // Створюємо обробник для паралельних операцій
        ParallelProcessor processor = new ParallelProcessor(collection);

        System.out.println("=== Паралельна обробка колекції ===");
        System.out.println("Мінімальна маса: " + processor.findMinMass());
        System.out.println("Максимальна маса: " + processor.findMaxMass());
        System.out.println("Середня маса: " + processor.averageMass());

        System.out.println("Фільтрація елементів з масою > 10:");
        List<Displayable> filtered = processor.filter(d -> d.getMass() > 10);
        for (Displayable d : filtered) {
            System.out.println(d.getFormattedResult());
        }

        System.out.println("Статистика маси:");
        System.out.println(processor.getMassStatistics());

        // Демонструємо Worker Thread для команд
        System.out.println("\n=== Робота Worker Thread ===");
        CommandWorker worker = new CommandWorker();
        worker.start();

        // Створюємо нові об'єкти для додавання через команду
        Displayable d1 = factory.createTableDisplay(20, 25);
        Displayable d2 = factory.createTableDisplay(5, 15);

        // Додаємо команди в чергу на виконання
        worker.submitCommand(new AddEnergyCommand(collection, d1));
        worker.submitCommand(new AddEnergyCommand(collection, d2));

        
        Thread.sleep(500);

        System.out.println("Колекція після виконання команд:");
        collection.printAll();

        // Зупиняємо робочий потік
        worker.shutdown();
    }
}
