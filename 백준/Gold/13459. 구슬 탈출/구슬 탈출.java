import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int row = Integer.parseInt(nm[0]);
        int col = Integer.parseInt(nm[1]);
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String rowString = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = rowString.charAt(j);
            }
        }
        System.out.println(solution(board));
    }
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    public static int solution(char[][] board) {
        return bfs(board);
    }

    private static int bfs(char[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();
        // 시작
        int rowLen = board.length;
        int colLen = board[0].length;
        int rr = 0;
        int rc = 0;
        int br = 0;
        int bc = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(board[i][j] == 'R') {
                    rr = i;
                    rc = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B') {
                    br = i;
                    bc = j;
                    board[i][j] = '.';
                }
            }
        }
        visited.add(new State(rr, rc, br, bc));
        queue.offer(new int[]{rr, rc, br, bc, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRr = cur[0];
            int curRc = cur[1];
            int curBr = cur[2];
            int curBc = cur[3];
            int curT = cur[4];
            if (curT >= 10) {
                return 0;
            }

            for (int i = 0; i < 4; i++) {
                // 4방향으로 red와 blue를 굴린다.
                RoleResult redResult = roll(curRr, curRc, i, board);
                RoleResult blueResult = roll(curBr, curBc, i, board);
                if (blueResult.isHole()) {
                    continue; // skip
                }
                if (redResult.isHole()) {
                    return 1;
                }
                // 둘이 같은 방향으로 굴렀을 경우 겹치지 않게 위치 조정
                if(redResult.getR() == blueResult.getR() && redResult.getC() == blueResult.getC()) {
                    // 구른 횟수 비교
                    if(redResult.getMoveCnt() > blueResult.getMoveCnt()) {
                        redResult = new RoleResult(redResult.getR() - dx[i], redResult.getC() - dy[i], redResult.getMoveCnt()-1, redResult.isHole());
                    }else{
                        blueResult = new RoleResult(blueResult.getR() - dx[i], blueResult.getC() - dy[i], blueResult.getMoveCnt() - 1, blueResult.isHole());
                    }
                }
                // 둘 다 안빠지면 방문여부 체크 후 다음으로
                if (visited.add(new State(redResult.getR(), redResult.getC(), blueResult.getR(), blueResult.getC()))) {
                    queue.offer(new int[]{redResult.getR(), redResult.getC(), blueResult.getR(), blueResult.getC(), curT+1});
                }
            }
        }
        return 0;
    }

    private static RoleResult roll(int curR, int curC, int dirIdx, char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        int nextRr = curR;
        int nextRc = curC;
        int moveCnt = 0;
        while (true) {
            nextRr += dx[dirIdx];
            nextRc += dy[dirIdx];
            moveCnt += 1;
            if(nextRr >= 0 && nextRr < rowLen && nextRc >= 0 && nextRc < colLen) {
                if(board[nextRr][nextRc] == 'O') {
                    // 구멍이면 빠지고
                    return new RoleResult(nextRr, nextRc, moveCnt,true);
                }
                // 구를 수가 없다? >>  어차피 visited가 막아주기 때문에 현재 위치 리턴하면 됨.
                if(board[nextRr][nextRc] == '#') {
                    return new RoleResult(nextRr - dx[dirIdx], nextRc - dy[dirIdx], moveCnt-1, false);
                }
                // 그게 아니면 계속 더하기
            }
        }
    }

    private static class RoleResult {
        int r;
        int c;
        int moveCnt;
        boolean isHole;

        public RoleResult(int r, int c, int moveCnt, boolean isHole) {
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
            this.isHole = isHole;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public boolean isHole() {
            return isHole;
        }

        public int getMoveCnt() {
            return moveCnt;
        }
    }
    private static class State{
        int rr;
        int rc;
        int br;

        int bc;

        public State(int rr, int rc, int br, int bc) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
        }

        public int getRr() {
            return rr;
        }

        public int getRc() {
            return rc;
        }

        public int getBr() {
            return br;
        }
        public int getBc() {
            return bc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return rr == state.rr && rc == state.rc && br == state.br && bc == state.bc;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rr, rc, br, bc);
        }
    }


}