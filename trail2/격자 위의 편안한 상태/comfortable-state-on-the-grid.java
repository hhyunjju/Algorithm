import java.util.*;

public class Main {
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0}; // U D L R
    private static int[] dc = {0, 0, -1, 1};
    private static boolean isRange(int r, int c){
        return r >= 1 && r < visited.length && c >=1 && c < visited[0].length;
    }
    private static boolean isComfortable(int r, int c){
        int cnt = 0;
        for(int i = 0; i < 4 ; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(isRange(nr, nc) && visited[nr][nc]){
                cnt++;
            }
        }
        return cnt == 3;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1][n+1];
        int curr = 0;
        int curc = 0;

        int result = 0;
        for(int i = 0 ; i < m ; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            visited[r][c] = true;
            result = isComfortable(r,c) ? 1 : 0;
            System.out.println(result);
        }
    }
}