package ex3.domain;

import ex2.domain.EnergyData;

/**
 * Інтерфейс для створення об'єктів типу EnergyData з заданими параметрами.
 */
public interface Creator {
    /**
     * Створює об'єкт EnergyData на основі маси та швидкості.
     * @param mass маса об'єкта
     * @param velocity швидкість об'єкта
     * @return новий об'єкт EnergyData
     */
    EnergyData create(double mass, double velocity);
}
