import java.util.*;

public class Main {
    private static int[][] grid;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n-2 ; c++){
                // 겹치지 않으려면 무조건 다음 row
                for(int r2 = 0 ; r2 < n; r2++){
                    for(int c2 = 0 ; c2 < n-2 ; c2++){
                        if(r==r2 && Math.abs(c-c2) < 3){
                            continue;
                        }

                        int cnt = grid[r][c] + grid[r][c+1] + grid[r][c+2]
                        + grid[r2][c2] + grid[r2][c2+1] + grid[r2][c2+2];
                        max = Math.max(max, cnt);
                    }
                }
            }
        }

        System.out.println(max);
    }
}