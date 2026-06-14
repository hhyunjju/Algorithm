import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        String[] b = new String[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.next();
        }
        for(int i = 0 ; i < n ; i++){
            b[i] = sc.next();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0 ; i < a.length ; i++){
            if(!a[i].equals(b[i])){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}