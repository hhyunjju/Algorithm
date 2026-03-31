import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i < n ; i++){
            // h = idx (오름차순이니까 n -1 )
            int h = n-i;
            if(citations[i]>=h){
                return h;
            }
        }
        return 0;
    }
}