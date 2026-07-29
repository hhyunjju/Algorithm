import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[] abilities = new int[6];
        // 2명씩 3팀 -> 능력 총합의 차 최소화할 떄의 차 출력
        int sum = 0;
        for(int i = 0 ; i < 6 ; i++){
            abilities[i] = sc.nextInt();
            sum += abilities[i];
        }

        int min = Integer.MAX_VALUE;

        // 0번 개발자와 같은 팀을 맺을 팀1을 먼저 결정한다.
        for(int i = 1 ; i < 6; i++){
            int sum1 = abilities[0] + abilities[i];

            int[] remains = new int[4];
            int idx = 0;
            for(int j = 0 ; j < 6; j++){
                if(j == 0 || j == i){
                    continue;
                }
                remains[idx++] = abilities[j];
            }

            // 4명을 2팀으로 나눈다. -> remains[0] 과 같은 팀을 할 1명을 구한다.
            for(int k = 1 ; k < 4 ; k++){
                int sum2 = remains[0] + remains[k];
                int sum3 = sum - sum1 - sum2;
                int teamMax = Math.max(sum1, Math.max(sum2, sum3));
                int teamMin = Math.min(sum1, Math.min(sum2, sum3));
                min = Math.min(min, teamMax - teamMin);
            }
        }
        System.out.println(min);        
    }
}