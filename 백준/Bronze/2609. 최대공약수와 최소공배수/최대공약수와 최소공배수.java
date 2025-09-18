import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    // 유클리드 호제법
    private static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min!=0) {
            int remainder = max % min;
            max = Math.max(remainder, min);
            min = Math.min(remainder, min);
        }
        return max;
    }

    private static int lcm(int a, int b) {
        return a*b / gcd(a, b);
    }
}