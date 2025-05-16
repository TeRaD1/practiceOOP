package ex3.domain;

import java.io.Serializable;
import ex2.domain.EnergyData;

/**
 * Обгортка для класу EnergyData, яка реалізує інтерфейс Displayable
 * та додає можливість форматованого виведення інформації про кінетичну енергію.
 * Клас також є серіалізованим для збереження та завантаження.
 */
public class EnergyDataDisplay implements Displayable, Serializable {
    private static final long serialVersionUID = 1L;

    /** Об'єкт EnergyData, що містить дані про масу, швидкість та енергію. */
    private final EnergyData data;

    /**
     * Конструктор, який приймає об'єкт EnergyData для обгортки.
     * 
     * @param data об'єкт EnergyData
     */
    public EnergyDataDisplay(EnergyData data) {
        this.data = data;
    }

    /**
     * Повертає опис типу енергії.
     * 
     * @return рядок з описом енергії
     */
    @Override
    public String getDescription() {
        return "Кінетична енергія";
    }

    /**
     * Повертає форматований рядок з масою, швидкістю та енергією.
     * 
     * @return форматований рядок з інформацією про енергію
     */
    @Override
    public String getFormattedResult() {
        return String.format("%s: маса = %.2f, швидкість = %.2f, енергія = %.2f Дж",
                getDescription(),
                data.getMass(),
                data.getVelocity(),
                data.getEnergy());
    }

    /**
     * Повертає об'єкт EnergyData.
     * 
     * @return об'єкт EnergyData
     */
    public EnergyData getData() {
        return data;
    }
}
