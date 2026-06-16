import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[17];
        // 나머지를 저장한다.
        int idx = 0;
        while(true){
            list[idx++] = n%2;
            if(n==1 || n==0){
                break;
            }
            n /= 2;
        }
        for(int i = idx-1 ; i >= 0 ; i--){
            System.out.print(list[i]);
        }
    }
}