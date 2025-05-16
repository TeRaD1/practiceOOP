package ex4.domain;

import ex2.domain.EnergyData;
import ex2.domain.EnergyCalculator;
import ex3.domain.Displayable;
import ex3.domain.EnergyFactory;
import ex3.domain.EnergyDataDisplay;

/**
 * Розширена фабрика, що створює об'єкти кінетичної енергії та їх відображення,
 * включно з табличним поданням.
 * <p>
 * Виконує обчислення енергії перед створенням відображення.
 * </p>
 */
public class FactoryExtended implements EnergyFactory {

    /**
     * Створює об'єкт EnergyData з масою та швидкістю,
     * а також виконує обчислення кінетичної енергії.
     *
     * @param mass маса тіла
     * @param velocity швидкість тіла
     * @return об'єкт EnergyData з обчисленою енергією
     */
    @Override
    public EnergyData createEnergy(double mass, double velocity) {
        EnergyData data = new EnergyData(mass, velocity);
        EnergyCalculator calculator = new EnergyCalculator(data);
        calculator.calculate();
        return data;
    }

    /**
     * Створює відображення енергії у вигляді Displayable.
     *
     * @param mass маса тіла
     * @param velocity швидкість тіла
     * @return об'єкт Displayable для відображення енергії
     */
    @Override
    public Displayable createDisplay(double mass, double velocity) {
        EnergyData data = createEnergy(mass, velocity);
        return new EnergyDataDisplay(data);
    }

    /**
     * Створює табличне відображення енергії.
     *
     * @param mass маса тіла
     * @param velocity швидкість тіла
     * @return табличне відображення енергії у вигляді Displayable
     */
    public Displayable createTableDisplay(double mass, double velocity) {
        EnergyData data = createEnergy(mass, velocity);
        return new TableDisplay(data);
    }

    /**
     * Створює табличне відображення з власним форматом заголовку та рядка.
     *
     * @param mass маса тіла
     * @param velocity швидкість тіла
     * @param headerFormat форматування заголовку таблиці
     * @param rowFormat форматування рядків таблиці
     * @return табличне відображення енергії з вказаним форматуванням
     */
    public Displayable createTableDisplay(double mass, double velocity, String headerFormat, String rowFormat) {
        EnergyData data = createEnergy(mass, velocity);
        return new TableDisplay(data, headerFormat, rowFormat);
    }
}
