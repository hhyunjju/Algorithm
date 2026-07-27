import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[101];

        for(int i = 0 ; i < n ; i++){
            int cnt = sc.nextInt();
            int idx = sc.nextInt();
            arr[idx] += cnt;
        }
        int max = 0;
        for(int c = 0 ; c < arr.length ; c++){
            int sum = 0;
            for(int i = c-k ; i <= c+k ; i++){
                if(i >= 0 && i < arr.length){
                    sum+=arr[i];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}