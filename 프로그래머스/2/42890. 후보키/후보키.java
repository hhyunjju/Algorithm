import java.util.*;

class Solution {
    public int solution(String[][] relation) {
            List<Set<Integer>> keyList = new ArrayList<>();
            // 1. bfs로 탐색한다.
            // 2. temp의 부분집합이 keyList에 없는지 확인한다. (최소성)
            List<List<Integer>> candidates = new ArrayList<>();
            bfs(relation, candidates);
            // 2. 만들어진 후보를 순회하며 keyList를 만든다.
            createKeyList(relation, keyList, candidates);

            return keyList.size();
        }
    
        private void createKeyList(String[][] relation, List<Set<Integer>> keyList, List<List<Integer>> candidates) {
            for (List<Integer> candidate : candidates) {
                if (isUnique(candidate, relation) && isMinimum(candidate, keyList)) {
                    keyList.add(new HashSet<>(candidate));
                }
            }
        }

        private void bfs(String[][] relation, List<List<Integer>> candidates) {
            ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
            int rowLen = relation.length;
            int colLen = relation[0].length;

            for (int i = 0; i < colLen; i++) {
                queue.offer(List.of(i));
            }

            // 1. key의 후보가 될 수 있는 idx들의 부분집합을 bfs방식으로 구한다.
            while(!queue.isEmpty()) {
                List<Integer> cur = queue.poll();
                candidates.add(cur);
                Integer lastIdx = cur.get(cur.size() - 1);
                for (int i = lastIdx+1; i < colLen; i++) {
                    ArrayList<Integer> next = new ArrayList<>(cur);
                    next.add(i);
                    queue.offer(next);
                }
            }
        }

        private boolean isMinimum(List<Integer> idxList, List<Set<Integer>> keyList) {
            List<Set<Integer>> subsets = createSubsets(idxList);
            for (Set<Integer> subset : subsets) {
                if(keyList.contains(subset)) {
                    return false;
                }
            }
            return true;
        }

        private List<Set<Integer>> createSubsets(List<Integer> idxList) {
            List<Set<Integer>> result = new ArrayList<>();
            HashSet<Integer> temp = new HashSet<Integer>();
            dfs(idxList, 0, temp, result);
            return result;
        }

        private void dfs(List<Integer> idxList, int startIdx, HashSet<Integer> temp, List<Set<Integer>> result) {
            result.add(new HashSet<>(temp));

            for (int i = startIdx; i < idxList.size(); i++) {
                temp.add(idxList.get(i));
                dfs(idxList, i + 1, temp, result);
                temp.remove(idxList.get(i));
            }
        }

        private boolean isUnique(List<Integer> idxList, String[][] relation) {
            int colLen = relation[0].length;
            int rowLen = relation.length;
            Set<List<String>> keyValues = new HashSet<>();
            for (int i = 0; i < rowLen; i++) {
                List<String> keyValue = new ArrayList<>();
                for (Integer idx : idxList) {
                    keyValue.add(relation[i][idx]);
                }
                if(keyValues.contains(keyValue)) {
                    return false;
                }else{
                    keyValues.add(keyValue);
                }
            }
            return true;
        }
    }
