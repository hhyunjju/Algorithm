import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        System.out.println(f(n, arr, 1));
    }
    public static int f(int x, int[] arr, int max){
        if(x == 0){
            return max;
        }
        return f(x-1, arr, Math.max(arr[x-1], max));
    }
}