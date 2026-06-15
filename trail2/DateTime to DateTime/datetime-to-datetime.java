import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // 11일, 11시, 11분 ~ a일 b시 c분
        int result = (60*24*a + 60*b + c) - (60*24*11 + 60*11 + 11);
        System.out.println(result < 0 ? -1 : result);
    }
}