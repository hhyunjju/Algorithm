import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }
    // n번째 값을 구하는 함수
    public static int f(int x){
        if(x==1){
            return 2;
        }
        if(x==2){
            return 4;
        }
        return (f(x-1)*f(x-2))%100;
    }
}