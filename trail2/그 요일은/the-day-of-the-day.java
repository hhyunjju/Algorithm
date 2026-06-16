import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String a = sc.next();

        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        // 나눈 몫 = 기본 등장 횟수.
        int diff = calculateDays(m2,d2) - calculateDays(m1,d1);
        int aIdx = Arrays.asList(days).indexOf(a);
        int remain = (aIdx <= (diff%7)) ? 1 : 0;
        int result = diff/7 + remain;
        System.out.println(result);
    }
    public static int calculateDays(int m, int d){
        int[] month_days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for(int i = 1; i < m ; i++){
            days+=month_days[i];
        }
        return days + d;
    }
}