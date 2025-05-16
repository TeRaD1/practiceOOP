package ex6.domain;

import ex3.domain.Collection;
import ex3.domain.Displayable;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Клас для паралельної обробки елементів колекції.
 */
public class ParallelProcessor {

    private final Collection collection;

    public ParallelProcessor(Collection collection) {
        this.collection = collection;
    }

    /**
     * Пошук мінімального значення серед елементів (за масою, припустимо).
     * @return мінімальне значення маси або Double.NaN, якщо колекція порожня.
     */
    public double findMinMass() {
        return collection.getAll().parallelStream()
                .mapToDouble(Displayable::getMass)
                .min()
                .orElse(Double.NaN);
    }

    /**
     * Пошук максимального значення серед елементів (за масою).
     * @return максимальне значення маси або Double.NaN.
     */
    public double findMaxMass() {
        return collection.getAll().parallelStream()
                .mapToDouble(Displayable::getMass)
                .max()
                .orElse(Double.NaN);
    }

    /**
     * Обчислення середнього значення маси.
     * @return середнє значення маси або Double.NaN.
     */
    public double averageMass() {
        return collection.getAll().parallelStream()
                .mapToDouble(Displayable::getMass)
                .average()
                .orElse(Double.NaN);
    }

    /**
     * Фільтрація елементів за заданим критерієм.
     * @param predicate умова фільтрації
     * @return список відфільтрованих елементів
     */
    public List<Displayable> filter(Predicate<Displayable> predicate) {
        return collection.getAll().parallelStream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Статистична обробка маси (мінімум, максимум, середнє, сума, кількість).
     * @return статистика за масою
     */
    public DoubleSummaryStatistics getMassStatistics() {
        return collection.getAll().parallelStream()
                .mapToDouble(Displayable::getMass)
                .summaryStatistics();
    }
}
