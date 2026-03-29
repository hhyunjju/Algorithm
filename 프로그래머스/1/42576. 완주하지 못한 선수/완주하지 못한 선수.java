import java.util.*;
import java.util.stream.*;
import java.util.function.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(completion)
            .collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        List<String> result = new ArrayList<>();
        for (int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i]) && map.get(participant[i]) > 0) {
                map.put(participant[i], map.get(participant[i]) - 1);
            }else{
                return participant[i];
            }
        }
        return null;
    }   
}