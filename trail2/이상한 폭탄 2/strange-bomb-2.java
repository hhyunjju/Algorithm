import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 폭발할 폭탄 중에 부여된 번호가 가장 큰 번호 출력
        int[] bombs = new int[n];
        for(int i = 0 ; i < n ; i++){
            bombs[i] = sc.nextInt();
        }

        // 매 번호마다 폭발 여부를 확인
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            int cur = bombs[i];
            for(int j = i+1; j < n ; j++){
                if(cur == bombs[j] && j-i <= k){
                    max = Math.max(max, cur);
                    break;
                }
            }
        }
        System.out.println(max);
    }
}