class Solution {
    public int solution(int n, int[][] computers) {
            boolean[] visited = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    // 완전탐색
                    dfs(i, computers, visited);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int i, int[][] computers, boolean[] visited) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    if (!visited[j]) {
                        visited[j] = true;
                        dfs(j, computers, visited);
                    }
                }
            }
        }
    
}