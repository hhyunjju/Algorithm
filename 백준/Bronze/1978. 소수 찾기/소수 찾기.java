import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] numArr = sc.nextLine().split(" ");
        ArrayList<Integer> temp = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(numArr[i]);
            if (isPrime(num)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isPrime(Integer num) {
        if(num < 2) {
            return false;
        }
        for (int j = 2; j <= Math.floor(Math.sqrt(num)); j++) {
            if(num % j == 0) {
                return false;
            }
        }
        return true;
    }
}