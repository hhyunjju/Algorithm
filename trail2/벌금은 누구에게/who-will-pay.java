import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] students = new int[n+1];
        int result = -1;
        for(int i = 0 ; i < m ; i++){
            // 벌칙에 걸린 학생의 번호
            int x = sc.nextInt();
            students[x]++;
            if(students[x] >= k){
                result = x;
                break;
            }
        }
        System.out.println(result);
    }
}