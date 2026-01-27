import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmfuel = br.readLine().split(" ");
        int n = Integer.parseInt(nmfuel[0]);
        int m = Integer.parseInt(nmfuel[1]);
        int fuel = Integer.parseInt(nmfuel[2]);

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] startPoint = br.readLine().split(" ");
        int startR = Integer.parseInt(startPoint[0]);
        int startC = Integer.parseInt(startPoint[1]);
        int[][] passengers = new int[m][4];
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");
            passengers[i][0] = Integer.parseInt(row[0]);
            passengers[i][1] = Integer.parseInt(row[1]);
            passengers[i][2] = Integer.parseInt(row[2]);
            passengers[i][3] = Integer.parseInt(row[3]);
        }
        System.out.println(solution(n, m, fuel, board, startR, startC, passengers));
    }
    private static int n;
    private static int m;
    private static long fuel;
    private static int[][] board;
    private static int visitedPassengerCnt;
    public static long solution(int n1, int m1, long fuel1, int[][] board1, int startR, int startC, int[][] passengers) {
        // n : 크기
        // m : 목표 승객 수
        // startR, startC : 운전시작칸
        n=n1;
        m=m1;
        fuel=fuel1;
        board=board1;
        boolean[] visitedPassengers = new boolean[passengers.length];
        visitedPassengerCnt = 0;
        int[] startPoint = new int[]{startR - 1, startC - 1};
        while(true){
            int[] nextPassenger = getNextPassenger(startPoint, passengers, visitedPassengers);
            if(nextPassenger==null){
                return -1;
            }

            fuel-=nextPassenger[4];
            if(fuel<=0){
                return -1;
            }

            int dis = bfs(nextPassenger[0], nextPassenger[1], nextPassenger[2], nextPassenger[3]);
            if (dis == -1) {
                return -1;
            }
            fuel-=dis;
            if (fuel < 0) {
                return -1;
            }

            fuel+=2*dis;
            if (visitedPassengerCnt == m) {
                return fuel;
            }
            startPoint = new int[]{nextPassenger[2], nextPassenger[3]};
        }
    }

    private static int bfs(int i, int i1, int i2, int i3) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int rowLen = board.length;
        int colLen = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowLen][colLen];
        queue.offer(new int[]{i, i1, 0});
        visited[i][i1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if(row==i2 && col==i3){
                return cur[2];
            }
            for(int k = 0; k < 4; k++){
                int nextRow = row+dx[k];
                int nextCol = col+dy[k];
                if(nextRow>=0 && nextRow < rowLen && nextCol>=0 && nextCol < colLen && !visited[nextRow][nextCol] && board[nextRow][nextCol]==0){
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, cur[2]+1});
                }
            }
        }
        return -1;
    }

    /**
     * bfs로 다음 승객 정보를 리턴한다.
     */
    private static int[] getNextPassenger(int[] startPoint, int[][] passengers, boolean[] visitedPassengers) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        int rowLen = board.length;
        int colLen = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowLen][colLen];

        queue.offer(new int[]{startPoint[0], startPoint[1], 0});
        visited[startPoint[0]][startPoint[1]] = true;

        int foundDist = -1;
        int bestIdx = -1;
        int bestR = Integer.MAX_VALUE;
        int bestC = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0], col = point[1], dis = point[2];

            // 최단거리 승객을 이미 찾았으면 그보다 먼 칸은 볼 필요 없음
            if (foundDist != -1 && dis > foundDist) break;

            // 현재 칸이 "승객 출발지"인지 체크 (여기서 바로 visited 처리하면 안됨)
            for (int i = 0; i < passengers.length; i++) {
                if (visitedPassengers[i]) continue;
                int pr = passengers[i][0] - 1;
                int pc = passengers[i][1] - 1;

                if (row == pr && col == pc) {
                    foundDist = dis; // 최단거리 확정
                    if (pr < bestR || (pr == bestR && pc < bestC)) {
                        bestR = pr;
                        bestC = pc;
                        bestIdx = i;
                    }
                }
            }

            // 최단거리 승객을 찾은 이후에는 더 깊게 확장할 필요 없음(동일 dis 레벨만 끝까지 보는 중)
            if (foundDist != -1) continue;

            for (int d = 0; d < 4; d++) {
                int nr = row + dx[d];
                int nc = col + dy[d];
                if (nr >= 0 && nr < rowLen && nc >= 0 && nc < colLen
                        && !visited[nr][nc] && board[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dis + 1});
                }
            }
        }

        if (bestIdx == -1) return null;

        visitedPassengers[bestIdx] = true;
        visitedPassengerCnt++;

        int[] p = passengers[bestIdx];
        return new int[]{p[0]-1, p[1]-1, p[2]-1, p[3]-1, foundDist};
    }
}