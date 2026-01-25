import java.util.*;

class Solution {
    public int solution(int[][] board) {
            return bfs(board);
        }

        /**
         * (n,n)에 도달하는 최소시간 반환
         */
        private int bfs(int[][] board) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int rowLen = board.length;
            int colLen = board[0].length;
            Set<State> visited = new HashSet<State>();
            Queue<int[]> queue = new ArrayDeque<>();
            addState(queue, 0, 0, 0, 1, 0, visited); // 대소비교해서 넣는 메서드 ( 방문처리도 대소비교 해서 처리)
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r1 = cur[0];
                int c1 = cur[1];
                int r2 = cur[2];
                int c2 = cur[3];
                int t = cur[4];
                if ((r1 == rowLen - 1 && c1 == colLen - 1) || (r2 == rowLen - 1 && c2 == colLen - 1)) {
                    return t;
                }
                for (int j = 0; j < 4; j++) {
                    int nr1 = r1 + dx[j];
                    int nc1 = c1 + dy[j];
                    int nr2 = r2 + dx[j];
                    int nc2 = c2 + dy[j];
                    int nt = t + 1;
                    if (validate(nr1, nc1, board) && validate(nr2, nc2, board)) {
                        addState(queue, nr1, nc1, nr2, nc2, nt, visited); // 방문여부까지 체크
                    }
                }
                // 대각선 처리
                // 가로
                if (r1 == r2) {
                    int r = r1;
                    int cL = Math.min(c1, c2); // left column
                    int cR = Math.max(c1, c2); // right column
                    int nt = t + 1;
                    // up
                    if (validate(r+1, cL, board) && validate(r+1, cR, board)) {
                        // cR -> cL & r+1
                        addState(queue, r + 1, cL, r, cL, nt, visited);
                        // cL -> cR & r+1
                        addState(queue, r + 1, cR, r, cR, nt, visited);
                    }

                    // down
                    if (validate(r-1, cL, board) && validate(r-1, cR, board)) {
                        // cR -> cL & r-1
                        addState(queue, r - 1, cL, r, cL, nt, visited);
                        // CL -> Cr & r-1
                        addState(queue, r - 1, cR, r, cR, nt, visited);
                    }
                }else{
                    // 세로
                    int c = c1;
                    int rU = Math.min(r1, r2); // row Up
                    int rD = Math.max(r1, r2); // row Down
                    int nt = t + 1;
                    // left c-1
                    if(validate(rU, c-1, board) && validate(rD, c-1, board)) {
                        // rU -> rD
                        addState(queue, rD, c-1, rD, c, nt, visited);
                        // rD -> rU
                        addState(queue, rU, c-1, rU, c, nt, visited);
                    }

                    // right
                    if(validate(rU, c+1, board) && validate(rD, c+1, board)) {
                        // rU -> rD
                        addState(queue, rD, c+1, rD, c, nt, visited);
                        // rD -> rU
                        addState(queue, rU, c+1, rU, c, nt, visited);
                    }
                }
            }
            return -1;
        }


        private void addState(Queue<int[]> queue, int r1, int c1, int r2, int c2, int nt, Set<State> visited) {
            int fr;
            int lr;
            int fc;
            int lc;
            if (r1 == r2) {
                fc = Math.max(c1, c2);
                lc = Math.min(c1, c2);
                fr = r1;
                lr = r1;
            } else {
                fr = Math.max(r1, r2);
                lr = Math.min(r1, r2);
                fc = c1;
                lc = c1;
            }
            // 방문한 적이 없으면 queue 에 넣고 방문처리하기
            State next = new State(fr, fc, lr, lc);
            if (visited.add(next)) {
                queue.offer(new int[]{fr, fc, lr, lc, nt});
            }
        }

        private boolean validate(int nr, int nc, int[][] board) {
            int rowLen = board.length;
            int colLen = board[0].length;
            return nr >= 0 && nr < rowLen && nc >= 0 && nc < colLen && board[nr][nc] == 0;
        }
        
            private class State{
            private int r1;
            private int c1;
            private int r2;
            private int c2;

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                State state = (State) o;
                return r1 == state.r1 && c1 == state.c1 && r2 == state.r2 && c2 == state.c2;
            }

            @Override
            public int hashCode() {
                return Objects.hash(r1, c1, r2, c2);
            }
                
                            public State(int r1, int c1, int r2, int c2) {
                this.r1 = r1;
                this.c1 = c1;
                this.r2 = r2;
                this.c2 = c2;
            }
        }
}