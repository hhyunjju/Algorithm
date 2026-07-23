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
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];
                    int sum = a+b+c;
                    boolean isCarry = false;
                    while(sum != 0){
                        // 자리수 비교
                        if(sum % 10 != ((a%10) + (b%10) + (c%10))){
                            isCarry = true;
                        }
                        sum /= 10;
                        a /= 10;
                        b /= 10;
                        c /= 10;
                    }
                    if(!isCarry){
                        max = Math.max(max, arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}