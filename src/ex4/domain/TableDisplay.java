package ex4.domain;

import ex2.domain.EnergyData;
import ex3.domain.Displayable;

/**
 * Клас, який реалізує табличне відображення кінетичної енергії.
 * Форматує дані у вигляді таблиці з можливістю кастомного форматування заголовку та рядків.
 */
public class TableDisplay implements Displayable {
    /** Дані кінетичної енергії для відображення */
    private final EnergyData data;

    /** Формат рядка заголовку таблиці */
    private final String headerFormat;

    /** Формат рядка з даними */
    private final String rowFormat;

    /**
     * Конструктор за замовчуванням, що встановлює прості формати заголовку та рядка.
     *
     * @param data об'єкт EnergyData з даними для відображення
     */
    public TableDisplay(EnergyData data) {
        this(data,
            "| Маса   | Швидкість | Енергія (Дж) |",
            "| %mass% | %velocity% | %energy%     |");
    }

    /**
     * Конструктор, що дозволяє задати власні формати заголовку та рядка.
     *
     * @param data об'єкт EnergyData з даними для відображення
     * @param headerFormat формат заголовку таблиці
     * @param rowFormat формат рядка з даними
     */
    public TableDisplay(EnergyData data, String headerFormat, String rowFormat) {
        this.data = data;
        this.headerFormat = headerFormat;
        this.rowFormat = rowFormat;
    }

    /**
     * Повертає опис типу відображення.
     *
     * @return опис відображення
     */
    @Override
    public String getDescription() {
        return "Табличне подання кінетичної енергії";
    }

    /**
     * Повертає форматований рядок з результатами у вигляді таблиці.
     *
     * @return рядок з заголовком і відформатованими даними
     */
    @Override
    public String getFormattedResult() {
        String header = headerFormat;
        String row = rowFormat
            .replace("%mass%", String.format("%.2f", data.getMass()))
            .replace("%velocity%", String.format("%.2f", data.getVelocity()))
            .replace("%energy%", String.format("%.2f", data.getEnergy()));

        return header + "\n" + row;
    }

    /**
     * Повертає масу об'єкта.
     *
     * @return маса
     */
    @Override
    public double getMass() {
        return data.getMass();
    }
}
