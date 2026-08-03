import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[] line = new char[1001];
        for(int i = 0 ; i < t ;i++){
            String c = sc.next(); // S or N
            int x = sc.nextInt();
            line[x] = c.charAt(0);
        }
        // 특별한 위치 = s랑 더 가깝거나 동일한 경우 
        // 특별한 위치의 수 구하기
        int cnt = 0;
        for(int i = a ; i <= b ; i++){
            int k = i;
            for(int j = 0 ; j < 1000 ; j++){
                int diff = j;
                if(line[k-diff] == 'S' || line[k+diff] == 'S'){
                    cnt++;
                    break;
                }else if(line[k-diff] == 'N' || line[k+diff] == 'N'){
                    break;
                }

            }
        }
        System.out.println(cnt);
    }
}