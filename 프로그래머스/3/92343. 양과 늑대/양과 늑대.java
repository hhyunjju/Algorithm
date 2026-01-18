import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int result;
    public int solution(int[] info, int[][] edges) {
            List<List<Integer>> children = new ArrayList<>(info.length);
            for (int i = 0; i < info.length; i++) {
                children.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                children.get(edge[0]).add(edge[1]);
            }
            List<Integer> candidates = new ArrayList<>();

            int sheepCnt = 1;
            int wolfCnt = 0;
            result = 1;
            // 초기 후보: 0의 자식들
            candidates.addAll(children.get(0));
            dfs(sheepCnt, wolfCnt, candidates, info, children);
            return result;
        }
        
        private void dfs(int sheepCnt, int wolfCnt, List<Integer> candidates, int[] info, List<List<Integer>> children) {
            // basecase
            result = Math.max(result, sheepCnt);

            for (Integer candidate : candidates) {
                if (info[candidate] == 0) {
                    if(sheepCnt+1 > wolfCnt) {
                        ArrayList<Integer> newCandidates = new ArrayList<>(candidates);
                        newCandidates.remove(candidate);
                        newCandidates.addAll(children.get(candidate));
                        dfs(sheepCnt+1, wolfCnt, newCandidates, info, children);
                    }
                }else{
                    if(wolfCnt+1 < sheepCnt) {
                        ArrayList<Integer> newCandidates = new ArrayList<>(candidates);
                        newCandidates.remove(candidate);
                        newCandidates.addAll(children.get(candidate));
                        dfs(sheepCnt, wolfCnt+1, newCandidates, info, children);
                    }
                }
            }
        }
    
}