import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 겹치는 조건: x1은 더 큰데 x2는 더 작은 선분이 있는 경우
        int[] x1s = new int[n];
        int[] x2s = new int[n];
        for(int i = 0 ; i < n ; i++){
            x1s[i] = sc.nextInt();
            x2s[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            boolean idOverlapped = true;
            for(int j = 0 ; j < n ; j++){
                if(i==j){
                    continue;
                }
                if((x1s[i] < x1s[j] && x2s[i] > x2s[j])||(x1s[i] > x1s[j] && x2s[i] < x2s[j])){
                    idOverlapped = false;
                }
            }
            if(idOverlapped){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}