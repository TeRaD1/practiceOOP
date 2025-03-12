public class args {
    public static void main(String[] args) {
        System.out.println("Аргументи командного рядка:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + ": " + args[i]);
        }
    }
}