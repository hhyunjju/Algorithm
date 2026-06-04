import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(f(n, 0));
    }
    public static int f(int x, int cnt){
        if(x == 1){
            return cnt;
        }
        if(x%2==0){
            return f(x/2, ++cnt);
        }else{
            return f(x*3+1, ++cnt);
        }
    }
}