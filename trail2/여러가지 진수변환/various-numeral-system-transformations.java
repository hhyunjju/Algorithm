import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[10];
        int i = 0;
        while(true){
            arr[i] = n % b;
            n /= b;
            if(n == 0){
                break;
            }
            i++;
        }
        for(int j = i; j >= 0 ; j--){
            System.out.print(arr[j]);
        }
    }
}