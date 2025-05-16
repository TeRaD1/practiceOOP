package ex3.domain;

/**
 * Інтерфейс, що описує об'єкт, який може бути відображений у вигляді тексту.
 */
public interface Displayable {
    /**
     * Повертає опис об'єкта.
     * @return текстовий опис.
     */
    String getDescription();

    /**
     * Повертає відформатований рядок з результатом для відображення.
     * @return відформатований текстовий результат.
     */
    String getFormattedResult();
}
