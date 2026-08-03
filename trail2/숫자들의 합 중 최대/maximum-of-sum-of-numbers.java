import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int max = 0;
        for(int i = x ; i <= y ; i++){
            // 각 자리의 숫자 합 구하기
            int sum = 0;
            int v = i;
            while(v!=0){
                sum += v%10;
                v/=10;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}