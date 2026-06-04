import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(f(n));
    }
    // n 번째 수를 구하는 함수
    public static int f(int x){
        if(x==1){
            return 1;
        }
        if(x==2){
            return 2;
        }
        return Math.floorDiv(x, 3) + f(x-1);
    }
}