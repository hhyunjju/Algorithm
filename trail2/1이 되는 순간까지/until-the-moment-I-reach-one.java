import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n,0));
    }
    public static int f(int x, int cnt){
        if(x == 1){
            return cnt;
        }
        if(x % 2 == 0){
            return f(x/2, ++cnt);
        }else{
            return f(x/3, ++cnt);
        }
    }
}