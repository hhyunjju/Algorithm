import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
            // 피신고자를 key, 신고자를 set자료구조에 담기
            // size가 k이상
            int[] result = new int[id_list.length];
            Map<String, Set<String>> map = new HashMap<>();
            for (String r : report) {
                String[] item = r.split(" ");
                String reporter = item[0];
                String target = item[1];
                map.computeIfAbsent(target, s -> new HashSet<>())
                        .add(reporter);
            }
            Map<String, Integer> idMap = new HashMap<>();
            for (int i = 0; i < id_list.length; i++) {
                idMap.put(id_list[i], i);
            }
            for (String key : map.keySet()) {
                if (map.get(key).size() >= k) {
                    for (String id : map.get(key)) {
                        result[idMap.get(id)]++;
                    }
                }
            }
            return result;
    }
}