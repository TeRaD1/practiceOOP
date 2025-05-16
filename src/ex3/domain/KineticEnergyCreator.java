package ex3.domain;

import ex2.domain.EnergyData;

/**
 * Реалізація інтерфейсу Creator для створення об'єктів кінетичної енергії.
 */
public class KineticEnergyCreator implements Creator {

    /**
     * Створює об'єкт EnergyData з заданою масою та швидкістю.
     *
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return новий об'єкт EnergyData
     */
    @Override
    public EnergyData create(double mass, double velocity) {
        return new EnergyData(mass, velocity);
    }
}
