import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 가지고 있는 카드개수
        int n = Integer.parseInt(sc.nextLine());
        // 가지고 있는 숫자 카드에 적혀있는 정수
        String[] having = sc.nextLine().split(" ");
        //
        int m = Integer.parseInt(sc.nextLine());
        // 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
        String[] target = sc.nextLine().split(" ");
        Map<Integer, Integer> targetMap = Arrays.stream(target)
                .collect(Collectors.toMap(
                        i -> Integer.parseInt(i),
                        i -> 0,
                        (oldValue, newValue) -> oldValue
                ));
        for (int i = 0; i < n; i++) {
            if (targetMap.get(Integer.parseInt(having[i])) != null) {
                targetMap.put(Integer.parseInt(having[i]), targetMap.get(Integer.parseInt(having[i])) + 1);
                ;
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < m; i++) {
            Integer cnt = targetMap.get(Integer.parseInt(target[i]));
            sj.add(String.valueOf(cnt));
        }
        System.out.println(sj);
    }
}