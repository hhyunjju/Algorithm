import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(sc.nextInt());
        }
        list.stream().sorted().forEach(i -> System.out.print(i+" "));
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i+" "));
    }
}