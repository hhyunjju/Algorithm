import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0 ; i < 5 ;i++){
            arr[i] = sc.nextInt();
            sum+= arr[i];
        }

        // 능력의 차이가 최소 ; 모든 팀의 능력치가 달라야함.
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 5 ; i++){
            // 1명팀을 먼저 선택
            for(int j = 0 ; j < 5 ; j++){
                if(j == i){
                    continue;
                }
                for(int k = 0 ; k < 5 ; k++){
                    if(k == j || k == i){
                        continue;
                    }
                    // arr[i] ; arr[j], arr[k], 나머지
                    int sum1 = arr[i];
                    int sum2 = arr[j] + arr[k];
                    int sum3 = sum - sum1 - sum2;
                    if(sum1 == sum2 || sum1 == sum3 || sum2 == sum3){
                        continue;
                    }
                    int teamMax = 0;
                    teamMax = Math.max(teamMax, Math.abs(sum1-sum2));
                    teamMax = Math.max(teamMax, Math.abs(sum1-sum3));
                    teamMax = Math.max(teamMax, Math.abs(sum2-sum3));

                    min = Math.min(min, teamMax);
                }
            }
        }
        int result = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(result);
    }
}