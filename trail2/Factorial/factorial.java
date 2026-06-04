import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(factorial(n));
    }
    public static int factorial(int x){
        if(x == 1){
            return 1;
        }
        return x*factorial(x-1);
    }
}