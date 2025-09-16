import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] split = sc.nextLine().split(" ");
            if (split[0].equals("0")) {
                return;
            }
            int[] list = Arrays.stream(split).mapToInt(Integer::parseInt).sorted().toArray();
            int a = list[0];
            int b = list[1];
            int c = list[2];
            if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}