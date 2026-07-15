import java.util.*;

public class Main {
    private static int[][] arr;

    public static boolean isRange(int r, int c){
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];

        int curr = 0;
        int curc = 0;

        int[] dr = {0, 1, 0, -1}; // r d l u
        int[] dc = {1, 0, -1, 0};

        int dir = 0;
        int v = 1;
        arr[0][0] = v;
        while(!(n==1 && m == 1)){
            int nr = curr + dr[dir];
            int nc = curc + dc[dir];
            if(isRange(nr, nc) && arr[nr][nc] == 0){
                curr = nr;
                curc = nc;
                arr[nr][nc] = ++v;
                if(v == n*m){
                    break;
                }
            }else{
                // 방향변환
                dir = (dir+1)%4;
            }
        }
        for(int r = 0 ; r < arr.length; r++){
            for(int c = 0 ; c < arr[0].length; c++){
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
    }
}