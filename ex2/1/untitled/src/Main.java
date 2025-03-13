import java.io.*;

// Клас для збереження параметрів і результатів обчислень
class CalculationData implements Serializable {
    private static final long serialVersionUID = 1L;

    private double input;
    private double result;

    public CalculationData(double input) {
        this.input = input;
    }

    public double getInput() {
        return input;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Input: " + input + ", Result: " + result;
    }
}

// Клас, який знаходить рішення задачі (наприклад, обчислення квадрата числа)
class Solver {
    private CalculationData data;

    public Solver(CalculationData data) {
        this.data = data;
    }

    public void compute() {
        double result = Math.pow(data.getInput(), 2);
        data.setResult(result);
    }

    public CalculationData getData() {
        return data;
    }
}

// Головний клас для тестування
public class Main {
    public static void main(String[] args) {
        CalculationData data = new CalculationData(5);
        Solver solver = new Solver(data);
        solver.compute();

        System.out.println("Результат обчислень: " + solver.getData());

        // Серіалізація
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(data);
            System.out.println("Дані збережено.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізація
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"))) {
            CalculationData loadedData = (CalculationData) in.readObject();
            System.out.println("Завантажені дані: " + loadedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
