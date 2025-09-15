import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        System.out.printf("%d %d", intSummaryStatistics.getMin(), intSummaryStatistics.getMax());
    }
}