import java.util.Scanner;

public class Main {
    private static char[][] grid;
    private static int[] dr = {-1, 1, 0, 0}; // 위 아래 왼 오
    private static int[] dc = {0, 0, -1, 1};
    private static int[] slash = {3, 2, 1, 0}; // / -> 아래 -> 왼 / 오 -> 위 / 왼 -> 아래 / 위 -> 오
    private static int[] backslash = {2, 3 , 0, 1}; // \\ -> 아래 -> 오/ 왼 -> 위 / 위 -> 왼 / 아래 -> 오
    
    private static int dir;
    private static int r;
    private static int c;

    private static boolean isRange(int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    private static void initialzie(int startNum, int n){
        if(startNum <= n){
            dir = 1;
            r = 0;
            c = startNum -1;
        }else if(startNum <= 2*n){
            dir = 2;
            r = (startNum-n) -1;
            c = n-1;

        }else if(startNum <= 3*n){
            dir = 0;
            r = n-1;
            c = 3*n - startNum;
        }else{
            dir = 3;
            r = 4*n - startNum;
            c = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();
        // Please write your code here.
        initialzie(startNum, n);

        int cnt = 0;
        while(isRange(r, c)){
            cnt++;
            if(grid[r][c] == '/'){
                dir = slash[dir];
            }else{
                dir = backslash[dir];
            }
            r += dr[dir];
            c += dc[dir];
        }
        System.out.println(cnt);
    }
}