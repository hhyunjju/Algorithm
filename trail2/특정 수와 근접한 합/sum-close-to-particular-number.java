import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        // 제외할 2개의 값 정하기
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int t = sum - arr[i] - arr[j];
                min = Math.min(min, Math.abs(t - s));
            }
        }
        System.out.println(min);
    }
}