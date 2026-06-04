import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }
    public static int f(int x){
        if(x == 1 || x == 2){
            return 1;
        }
        return f(x-1) + f(x-2);
    }
}