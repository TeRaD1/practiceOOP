package ex2.domain;

import java.io.Serializable;

/**
 * Клас {@code EnergyData} представляє дані для розрахунку кінетичної енергії.
 * Містить масу, швидкість, обчислену енергію, а також додаткове тимчасове поле.
 * <p>
 * Реалізує інтерфейс {@link Serializable} для можливості серіалізації стану об'єкта.
 * </p>
 */
public class EnergyData implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Маса тіла (в кг) */
    private double mass;

    /** Швидкість тіла (в м/с) */
    private double velocity;

    /** Обчислена кінетична енергія (в Джоулях) */
    private double energy;

    /** Тимчасова примітка (не серіалізується) */
    private transient String tempNote;

    /**
     * Конструктор, що ініціалізує масу та швидкість тіла.
     *
     * @param mass     маса тіла
     * @param velocity швидкість тіла
     */
    public EnergyData(double mass, double velocity) {
        this.mass = mass;
        this.velocity = velocity;
    }

    /**
     * Повертає масу тіла.
     *
     * @return маса
     */
    public double getMass() {
        return mass;
    }

    /**
     * Повертає швидкість тіла.
     *
     * @return швидкість
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Повертає обчислену кінетичну енергію.
     *
     * @return енергія
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Встановлює значення обчисленої кінетичної енергії.
     *
     * @param energy енергія
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * Повертає тимчасову примітку.
     *
     * @return tempNote
     */
    public String getTempNote() {
        return tempNote;
    }

    /**
     * Встановлює тимчасову примітку.
     *
     * @param tempNote примітка
     */
    public void setTempNote(String tempNote) {
        this.tempNote = tempNote;
    }

    /**
     * Повертає рядкове представлення об'єкта {@code EnergyData}.
     *
     * @return інформація про масу, швидкість, енергію та тимчасову примітку
     */
    @Override
    public String toString() {
        return "EnergyData{" +
               "mass=" + mass +
               ", velocity=" + velocity +
               ", energy=" + energy +
               ", tempNote='" + tempNote + '\'' +
               '}';
    }
}
