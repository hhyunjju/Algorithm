import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] split = sc.nextLine().split(" ");
            if (split[0].equals("0")) {
                return;
            }
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }
    }
}