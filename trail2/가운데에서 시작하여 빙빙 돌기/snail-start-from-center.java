import java.util.Scanner;

public class Main {
    private static int[][] grid;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[] moveDir = {2, 3, 1, 0};

    private static boolean isRange(int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        grid = new int[n][n];

        int r = n / 2 + 1 -1;
        int c = n / 2 + 1 -1;
        int num = 0;
        int dir = 3;
        int max = n*n;
        // 현재위치가 되냐안되냐가 아니라 다음으로 넘어갈 수 있냐아니냐의 문제.
        while(num < max){
            // 그리드 표시
            grid[r][c] = ++num;

            // 다음값 설정
            int nDir = moveDir[dir];
            int nr = r + dr[nDir];
            int nc = c + dc[nDir];
            if(num == 1 || grid[nr][nc] > 0){
                // dir 유지
            }else{
                // 방문한 적 없으면
                dir = nDir;
            }
            r += dr[dir];
            c += dc[dir];
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}