import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        System.out.println(f(a*b*c, 0));
    }

    // 각 자리수들의 합을 구하여 출력
    public static int f(int x, int sum){
        if(x < 10){
            return sum+x;
        }
        return f(x/10, sum+(x%10));
    }
}