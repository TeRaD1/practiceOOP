package ex3.domain;

import ex2.domain.EnergyData;

/**
 * Фабрика для створення об'єктів кінетичної енергії та їх відображень.
 * Реалізує інтерфейс EnergyFactory.
 */
public class KineticEnergyFactory implements EnergyFactory {

    /**
     * Створює об'єкт EnergyData з заданою масою та швидкістю.
     *
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return об'єкт EnergyData
     */
    @Override
    public EnergyData createEnergy(double mass, double velocity) {
        return new EnergyData(mass, velocity);
    }

    /**
     * Створює об'єкт Displayable для відображення кінетичної енергії.
     *
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return об'єкт Displayable, який обгортає EnergyData
     */
    @Override
    public Displayable createDisplay(double mass, double velocity) {
        EnergyData data = createEnergy(mass, velocity);
        return new EnergyDataDisplay(data);
    }
}
