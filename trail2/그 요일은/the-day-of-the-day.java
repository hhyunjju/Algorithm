import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.
        int dates1 = calculateDates(m1, d1);
        int dates2 = calculateDates(m2, d2);
        String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; 
        int result = (dates2-dates1)/7;
        if((dates2-dates1)%7 >= Arrays.asList(DAYS).indexOf(A)){
            result++;
        }
        System.out.println(result);
    }
    public static int calculateDates(int m, int d){
        int[] MONTH_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = 0;
        for(int i = 1; i < m; i++){
            result += MONTH_DAYS[i];
        }
        return result + d;
    }
}