import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n, 0));
    }
    public static int f(int x, int sum){
        if(x==0 || x == -1){
            return sum;
        }
        return f(x-2, sum+x);
    }
}