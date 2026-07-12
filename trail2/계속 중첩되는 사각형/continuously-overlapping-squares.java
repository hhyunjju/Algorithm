import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // r: 3 ; b: 2;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[200][200];
        int offset = 100;

        for(int k = 1 ; k <= n ; k++){
            int x1 = sc.nextInt();
            int y1= sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int color = k%2+2;
            for(int i = x1; i < x2; i++){
                for(int j = y1; j < y2; j++){
                    arr[i+offset][j+offset] = color;
                }
            }
        }
        // 2의 개수
        int cnt = 0;
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length; j++){
                if(arr[i][j] == 2){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}