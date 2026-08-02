import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] ps = new int[n];
        for(int i = 0 ;  i < n ; i++){
            ps[i] = sc.nextInt();
        }
        // 최대 명수 구하기 > 조합이 중요할텐디.. > 작은 가격 순으로 오름차순
        Arrays.sort(ps);
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            // i 번째를 반값
            int sum = 0;
            int cnt = 0;

            int discounted = (int)(ps[i] * 0.5);
            if(discounted > b){
                continue;
            }
            sum+=discounted;
            cnt++;
            for(int j = 0 ;  j < n ; j++){
                if(j == i){
                    continue;
                }
                if(sum+ps[j] > b){
                    break;
                }
                sum+=ps[j];
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}