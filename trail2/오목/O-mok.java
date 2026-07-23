import java.util.*;

public class Main {
    private static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
    private static boolean isRange(int r, int c, int n){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = 19;
        // 1: 검정 , 2: 흰색, 0: 빈자리
        int[][] go = new int[n][n];

        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                go[r][c] = sc.nextInt();
            }
        }

        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n; c++){
                for(int i = 0 ; i < 8 ; i++){
                    int x1 = go[r][c];
                    if(x1 == 0){
                        continue;
                    }
                    boolean isWin = true;

                    for(int j = 0 ; j < 4 ; j++){
                        if(!isRange(r+dr[i]*(j+1), c+dc[i]*(j+1), n) || x1 != go[r+dr[i]*(j+1)][c+dc[i]*(j+1)]){
                            isWin = false;
                        }
                    }
                    if(isWin){
                        // 연속 수 발견
                        int midR = r+2*dr[i];
                        int midC = c+2*dc[i];
                        System.out.println(x1);
                        System.out.println((midR+1) + " " + (midC+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}