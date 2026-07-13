import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        int max = 0;
        int prev = -1;
        for(int i = 0 ; i < n; i++){
            int cur = sc.nextInt();
            if(i==0 || prev == cur){
                cnt++;
                max = Math.max(max, cnt);
            }else{
                cnt = 1;
            }
            prev = cur;
        }
        System.out.println(max);
    }
}