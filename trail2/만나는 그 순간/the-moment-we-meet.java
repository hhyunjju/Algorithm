import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // a
        int[] aArr = new int[1000_001];
        int curATime = 0;
        int curA = 0;
        for(int i = 0 ; i < n ; i++){
            // 움직인 방향
            String d = sc.next();
            // 초
            int t = sc.nextInt();

            for(int j = 0 ; j < t ; j++){
                if(d.equals("L")){
                    aArr[++curATime] = --curA;
                }else{
                    aArr[++curATime] = ++curA;
                }
            }
        }

        // b
        int[] bArr = new int[1000_001];
        int curBTime = 0;
        int curB = 0;
        for(int i = 0; i < m ; i++){
            // 움직인 방향
            String d = sc.next();
            // 초
            int t = sc.nextInt();

            for(int j = 0 ; j < t ; j++){
                if(d.equals("L")){
                    bArr[++curBTime] = --curB;
                }else{
                    bArr[++curBTime] = ++curB;
                }
            }
        }

        for(int i = 1; i <= curATime; i++){
            if(aArr[i] == bArr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}