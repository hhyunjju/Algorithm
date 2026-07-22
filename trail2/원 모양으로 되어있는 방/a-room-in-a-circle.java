import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ;i++){
            int dis = 0;
            for(int j = 0 ; j < n ; j++){
                if(j==i){
                    continue;
                }
                if(j > i){
                    dis += arr[j] * (Math.abs(i-j));
                }else{
                    // 반시계방향
                    dis += arr[j] * (Math.abs(n-i+j));
                }
            }
            min = Math.min(min, dis);
        }
        System.out.println(min);
    }
}