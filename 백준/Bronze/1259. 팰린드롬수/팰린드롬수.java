import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("0")) {
                return;
            }
            StringBuilder sb = new StringBuilder(str);
            if (sb.reverse().toString().equals(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}