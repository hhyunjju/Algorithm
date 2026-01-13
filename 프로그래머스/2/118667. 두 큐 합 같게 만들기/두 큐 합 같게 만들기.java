import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
            long sum1 = Arrays.stream(queue1).sum();
            long sum2 = Arrays.stream(queue2).sum();
            int count = 0;
            ArrayDeque<Integer> queueA = Arrays.stream(queue1)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayDeque::new));
            ArrayDeque<Integer> queueB = Arrays.stream(queue2)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayDeque::new));
            while(sum1 != sum2) {
                if (count > queue1.length * 4) {
                    return -1;
                }
                if (sum1 > sum2) {
                    Integer pollA = queueA.poll();
                    queueB.offer(pollA);
                    sum1 -= pollA;
                    sum2 += pollA;
                    count++;
                }else{
                    Integer pollB = queueB.poll();
                    queueA.offer(pollB);
                    sum1 += pollB;
                    sum2 -= pollB;
                    count++;
                }
            }
            return count;
    }
}