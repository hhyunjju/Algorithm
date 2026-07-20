import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0 ; i < n ; i++){
            h[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0 ; i < h.length; i++){
            for(int j = i+1 ; j < h.length; j++){
                if(h[i] <= h[j]){
                    for(int k = j+1; k < h.length; k++){
                        if(h[j] <= h[k]){
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}