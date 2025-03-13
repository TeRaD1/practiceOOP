import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Маса (кг): ");
        double m = s.nextDouble();

        System.out.print("Висота (м): ");

        double h = s.nextDouble();
        final double g = 9.81;
        long e = Math.round(m * g * h);
        String b = Long.toBinaryString(e);
        int max1 = findMax1(b);

        System.out.println("\nЕнергія: " + e + " Дж");
        System.out.println("Двійковий: " + b);
        System.out.println("Макс 1: " + max1);
    }

    public static int findMax1(String b) {
        int max = 0, cur = 0;

        for (char c : b.toCharArray()) {
            if (c == '1') {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
