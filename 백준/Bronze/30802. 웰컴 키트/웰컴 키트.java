import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 참가자 수
        String[] applicantsPerSize = sc.nextLine().split(" "); // 사이즈별 신청자수
        String[] split = sc.nextLine().split(" ");// 정수 티셔츠 펜의 묶음 수
        int t = Integer.parseInt(split[0]); // 티셔츠
        int p = Integer.parseInt(split[1]); // 펜 묶음 수

        double totalTCnt = Arrays.stream(applicantsPerSize)
                .filter(a -> !"0".equals(a))
                .mapToDouble(Double::parseDouble)
                .map(a -> Math.ceil(a / t))
                .sum();
        System.out.println((int)totalTCnt);
        System.out.printf("%d %d", n/p, n%p);

    }
}