import java.util.*;

public class Main {
    private static int n;
    private static boolean isNear(int a, int b){
        int diff = Math.abs(a-b);
        return Math.min(diff, n-diff) <= 2;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();

        // 1과 9가 인접한 걸 어떻게 표현?
        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(isNear(i, a1) && isNear(j, b1) && isNear(k, c1)){
                        cnt++;
                    }else if(isNear(i, a2) && isNear(j, b2) && isNear(k, c2)){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}