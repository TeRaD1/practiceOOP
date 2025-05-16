package ex3.domain;

import ex2.domain.EnergyData;

/**
 * Інтерфейс фабрики для створення об'єктів кінетичної енергії
 * та їх відображення.
 */
public interface EnergyFactory {

    /**
     * Створює об'єкт EnergyData з заданою масою та швидкістю.
     *
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return створений об'єкт EnergyData
     */
    EnergyData createEnergy(double mass, double velocity);

    /**
     * Створює об'єкт, який реалізує інтерфейс Displayable
     * для відображення даних про енергію.
     *
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return об'єкт для відображення енергії
     */
    Displayable createDisplay(double mass, double velocity);
}
