import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m ;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        int cnt = 0;

        for(int i = 0 ; i < n-m+1 ; i++){
            // 정렬해서 동일한지 확인
            int[] temp = Arrays.copyOfRange(a, i, i+m);
            Arrays.sort(temp);
            if(Arrays.equals(b, temp)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}