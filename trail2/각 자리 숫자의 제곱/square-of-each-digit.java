import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(square(n));
    }
    public static int square(int n){
        if(n<10){
            return n*n;
        }
        int cur = n % 10;
        return cur*cur + square(n/10);
    }
}