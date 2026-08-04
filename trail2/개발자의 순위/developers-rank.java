import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] ranks = new int[k][n];
        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ; j < n ; j++){
                // > > > > 
                ranks[i][j] = sc.nextInt();
            }
        }

        // (a,b) 쌍을 다 구한 다음에 통과하는 a,b만?
        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == j){
                    continue;
                }
                int a = i;
                int b = j;
                // a>b인지 판단
                boolean isPermanent = true;

                for(int  r = 0 ; r < ranks.length ; r++){
                    int aIdx = -1;
                    int bIdx = -1;
                    for(int l = 0 ; l < ranks[0].length; l++){
                        if(ranks[r][l] == a){
                            aIdx = l;
                        }
                        if(ranks[r][l] == b){
                            bIdx = l;
                        }
                    }
                    if(aIdx > bIdx){
                        isPermanent = false;
                    }
                }
                if(isPermanent){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}