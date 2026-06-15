import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 홀수 번째의 원소가 주어질 때마다 지금까지 입력받은 값의 중앙값을 출력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            arr[i] = x;
            if((i+1) % 2 != 0){
                Arrays.sort(arr, 0 , i+1);
                int mid = arr[i/2];
                System.out.print(mid + " ");
            }
        }
    }
}