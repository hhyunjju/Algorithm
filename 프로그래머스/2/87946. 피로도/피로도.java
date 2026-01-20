class Solution {
    private static int result;

    public int solution(int k, int[][] dungeons) {
            // 초기화
            result = 0;
            boolean[] visited = new boolean[dungeons.length];

            // k가 소진될 때 까지 완전탐색하기.
            // 더이상 갈 수 있는 던전이 없을 때? ㄴㄴ >> 최댓값이니까 탐색할 때마다, 최댓값 비교하기.
            dfs(k, dungeons, visited);
            return result;
        }

        private void dfs(int remainingFatigue, int[][] dungeons, boolean[] visited) {
            // basecase
            int visitedCnt = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    visitedCnt++;
                }
            }
            result = Math.max(result, visitedCnt);

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i]) {
                    int min = dungeons[i][0];
                    int cost = dungeons[i][1];
                    if (remainingFatigue - min >= 0) {
                        visited[i] = true;
                        dfs(remainingFatigue - cost, dungeons, visited);
                        visited[i] = false;
                    }
                }
            }
        }
    
}