import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            String s = Arrays.stream(split[1].split(""))
                    .reduce("", (a, b) -> a + b.repeat(Integer.parseInt(split[0])));
            sj.add(s);
        }
        System.out.println(sj);
    }
}