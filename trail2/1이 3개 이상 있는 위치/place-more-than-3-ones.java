import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                arr[r][c] = sc.nextInt();
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0 , 1, -1};
        int result = 0;
        for(int r = 0 ; r < arr.length ; r++){
            for (int c = 0 ; c < arr[0].length ; c++){
                int cnt = 0;
                for (int i = 0 ; i < 4 ; i++){
                    if(isRange(r+dr[i], c+dc[i], arr) && arr[r+dr[i]][c+dc[i]] == 1){
                        cnt++;
                    }
                }
                if(cnt >= 3){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static boolean isRange(int r, int c, int[][] arr){
        return r >=0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
}