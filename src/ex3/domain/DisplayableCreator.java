package ex3.domain;

/**
 * Інтерфейс для створення об'єктів, які реалізують Displayable,
 * на основі маси та швидкості.
 */
public interface DisplayableCreator {
    /**
     * Створює об'єкт Displayable з заданими параметрами маси та швидкості.
     *
     * @param mass маса
     * @param velocity швидкість
     * @return створений об'єкт, який реалізує Displayable
     */
    Displayable create(double mass, double velocity);
}
