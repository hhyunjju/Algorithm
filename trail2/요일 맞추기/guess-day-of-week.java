import java.util.*;

public class Main {
    public static int[] monthDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31,31, 30, 31, 30, 31};
    public static void main(String[] args) {
    
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    
        // 같은 요일이라면 7일차이 나야함.
        int diff = calculateDays(m2, d2) - calculateDays(m1, d1);
        int idx = diff%7 < 0 ? days.length + diff%7 : diff%7;
        System.out.println(days[idx]);
    }
    public static int calculateDays(int m, int d){
        int days = 0;
        for(int i = 1 ; i < m ; i++){
            days+=monthDays[i];
        }
        return days+d;
    }
}