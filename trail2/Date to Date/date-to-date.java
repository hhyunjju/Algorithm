import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        System.out.println(calculateDays(m2, d2) - calculateDays(m1, d1)+1);

    }
    public static int calculateDays(int m, int d){
        int[] nums_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for(int i = 1 ; i < m ; i++){
            days+=nums_of_days[i];
        }
        return days+d;
    }
}