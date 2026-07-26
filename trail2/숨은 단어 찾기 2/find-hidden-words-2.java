import java.util.Scanner;
public class Main {
    private static char[][] grid;
    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    private static boolean isRange(int r, int c){
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] arr = sc.next().toCharArray();
            for(int j = 0 ; j < m ; j++){
                grid[i][j] = arr[j];
            }
        }
        // Please write your code here.
        int cnt = 0;
        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                for(int i = 0 ; i < 8 ; i++){
                    int r2 = r + dr[i];
                    int r3 = r + 2*dr[i];
                    int c2 = c + dc[i];
                    int c3 = c + 2*dc[i];
                    if(isRange(r2, c2) && isRange(r3, c3)){
                        if(grid[r][c] == 'L' && grid[r2][c2] == 'E' && grid[r3][c3] == 'E'){
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}