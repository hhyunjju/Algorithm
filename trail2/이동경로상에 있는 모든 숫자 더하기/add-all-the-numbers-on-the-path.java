import java.util.*;

public class Main {
    private static int[][] grid;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static int[] lMove = {2, 3, 1, 0}; // u -> l -> d -> r -> u
    private static int[] rMove = {3, 2, 0, 1}; // u -> r -> d -> l -> u

    private static boolean isRange(int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        grid = new int[n][n];

        char[] arr = sc.next().toCharArray();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int r = n/2;
        int c = n/2;
        int dir = 0;
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            if(i == 0){
                sum+=grid[r][c];
            }
 
            // 다음 r 설정
            if(arr[i] == 'L'){
                dir = lMove[dir];
            }else if(arr[i] == 'R'){
                dir = rMove[dir];
            }else{
                //F
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if(isRange(nr, nc)){
                    r = nr;
                    c = nc;
                    sum+=grid[r][c];
                }
            }
        }
        System.out.println(sum);
    }
}