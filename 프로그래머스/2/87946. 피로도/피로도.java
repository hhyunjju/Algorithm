class Solution {
    private static int result;
    public int solution(int k, int[][] dungeons) {
            // ======= solution =======
            result = 0;
            dfs(k, dungeons, new boolean[dungeons.length], 0);
            return result;
            // =======================
        }

        private void dfs(int fatigue, int[][] dungeons, boolean[] visited, int count) {
            // 방문횟수 +1
            result = Math.max(result, count);

            for (int i = 0; i < dungeons.length; i++) {
                int min = dungeons[i][0];
                int cost = dungeons[i][1];
                if (fatigue >= min && !visited[i]) {
                    // 방문
                    visited[i] = true;
                    dfs(fatigue - cost, dungeons, visited, count + 1);
                    visited[i] = false;
                }
            }
        }
    }