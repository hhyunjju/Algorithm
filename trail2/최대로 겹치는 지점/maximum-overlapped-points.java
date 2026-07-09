import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[101];

        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            for(int j = x1 ; j <= x2 ; j++){
                arr[j] += 1;
            }
        }

        int max = 0;
        for(int l = 0 ; l < arr.length ; l++){
            max = Math.max(max, arr[l]);
        }
        System.out.println(max);
    }
}