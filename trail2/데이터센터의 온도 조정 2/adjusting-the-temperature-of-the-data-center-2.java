import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        int min = 1000;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            // 온도범위 ta, tb
            int ta = sc.nextInt();
            int tb = sc.nextInt();
            a[i] = ta;
            b[i] = tb;
            min = Math.min(min, ta);
            max = Math.max(max, tb);
        }
        // 최고 작업량을 출력
        int maxWork = 0;
        for(int i = min-1 ; i <= max+1; i++){
            int temp = i;
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                int ta = a[j];
                int tb = b[j];
                if(temp < ta){
                    sum+=c;
                }else if(temp>=ta && temp<=tb){
                    sum+=g;
                }else{
                    sum+=h;
                }
            }
            maxWork = Math.max(maxWork, sum);
        }
        System.out.println(maxWork);
    }
}