import java.io.*;
import java.util.Scanner;

// Клас користувача, що серіалізується
class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password; // Поле не буде серіалізоване

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}

// Клас для демонстрації серіалізації в діалоговому режимі
public class SerializationDemo {
    private static final String FILE_NAME = "user.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Отримуємо дані від користувача
        System.out.print("Введіть ім'я користувача: ");
        String username = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
        System.out.println("\nОб'єкт перед серіалізацією: " + user);

        // 2. Серіалізація об'єкта
        serialize(user);

        // 3. Десеріалізація об'єкта
        User deserializedUser = deserialize();

        // 4. Вивід результату
        System.out.println("\nОб'єкт після десеріалізації: " + deserializedUser);
        System.out.println("Зверніть увагу: поле password стало null через transient!");
    }

    // Метод для серіалізації об'єкта
    private static void serialize(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(user);
            System.out.println("Об'єкт успішно серіалізовано у файл " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десеріалізації об'єкта
    private static User deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
