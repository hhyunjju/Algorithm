import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[6];
        int total = 0;
        for(int i = 0 ; i < arr.length ;i++){
            arr[i] = sc.nextInt();
            total+=arr[i];
        }
        // 총합의 차 최소화
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                for(int k = j+1; k < arr.length ; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    int diff = Math.abs(total-sum-sum);
                    min = Math.min(min, diff);
                }
            }
        }
        System.out.println(min);
    }
}