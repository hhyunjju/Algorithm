import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] arr = new String[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        int idx = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].startsWith(t)){
                idx++;
                if(idx == k){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}