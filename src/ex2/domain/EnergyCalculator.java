package domain;

/**
 * Клас {@code EnergyCalculator} використовується для обчислення
 * кінетичної енергії фізичного тіла на основі маси та швидкості.
 * <p>
 * Формула обчислення: <br>
 * E = 0.5 * mass * velocity²
 * </p>
 */
public class EnergyCalculator {
    /** Об'єкт, що містить параметри та результат обчислення енергії */
    private EnergyData data;

    /**
     * Конструктор класу {@code EnergyCalculator}.
     *
     * @param data об'єкт {@link EnergyData}, що містить масу, швидкість і результат
     */
    public EnergyCalculator(EnergyData data) {
        this.data = data;
    }

    /**
     * Метод виконує обчислення кінетичної енергії та зберігає результат у {@link EnergyData}.
     */
    public void calculate() {
        double result = 0.5 * data.getMass() * Math.pow(data.getVelocity(), 2);
        data.setEnergy(result);
    }
}
