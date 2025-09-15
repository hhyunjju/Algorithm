import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(sc.nextLine());
            if (n >= max) {
                max = n;
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx+1);
    }
}