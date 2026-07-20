import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for(int r = 0; r < grid.length ; r++){
            for(int c= 0 ; c < grid.length -2 ; c++){
                max = Math.max(max, grid[r][c] + grid[r][c+1] + grid[r][c+2]);
            }
        }
        System.out.println(max);
    }
}