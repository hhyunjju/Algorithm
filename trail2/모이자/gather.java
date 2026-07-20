import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        // 이동거리의 합이 최소
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 0 ; i < n; i++){
            arr[i+1] = sc.nextInt();
        }

        int[] dis = new int[n+1];
        for(int i = 0; i < n ; i++){
            int x = i+1;
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                sum+=Math.abs(x-(j+1))*arr[j+1];
            }
            dis[x] = sum;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(dis[i+1], min);
        }
        System.out.println(min);
    }
}