import java.util.*;

public class Main {
    private static int[][] visited;
    private static int[] dr = {-1, 1, 0, 0}; // 위 아래 왼 오
    private static int[] dc = {0, 0, -1, 1};

    private static int[] moveDir = {2, 3, 1, 0};

    private static boolean isRange(int r, int c){
        return r >= 0 && r < visited.length && c >= 0 && c < visited[0].length;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int rLen = sc.nextInt();
        int cLen = sc.nextInt();
        visited = new int[rLen][cLen];

        int r = 0;
        int c = 0;
        int dir = 1; // 아래방향에서 시작

        int cnt = 0;
        int max = rLen * cLen;

        while(cnt < max){
            visited[r][c] = ++cnt;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(!isRange(nr, nc) || visited[nr][nc] > 0){
                dir = moveDir[dir];
            }
            r += dr[dir];
            c += dc[dir];
        }

        for(int i = 0 ; i < rLen ; i++){
            for(int j = 0 ; j < cLen ; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}