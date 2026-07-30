import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0 ; i < n ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int min = 2000_000;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                int dis = (int)Math.pow(x[i]-x[j], 2) + (int)Math.pow((y[i]-y[j]),2);
                min = Math.min(min, dis);
            }
        }
        System.out.println(min);
    }
}