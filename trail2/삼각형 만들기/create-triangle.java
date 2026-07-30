import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0 ; i < n ;i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // a<>b는 x값이 같아야하고, b<>c는 y값이 같아야함.
        int max = 0;
        // 조합을 먼저 다 구함
        for(int a = 0 ; a < n ; a++){
            for(int b = a+1; b < n ; b++){
                for(int c = b+1; c < n ; c++){
                    if(x[a] == x[b]){
                        if(y[a] == y[c]){
                            int size = Math.abs(y[a]-y[b])*Math.abs(x[a]-x[c]);
                            max = Math.max(max, size);
                        }else if(y[b] == y[c]){
                            int size = Math.abs(y[a]-y[b])*Math.abs(x[b]-x[c]);
                            max = Math.max(max, size);
                        }
                    }else if(x[a] == x[c]){
                        if(y[a] == y[b]){
                            int size = Math.abs(y[a]-y[c])*Math.abs(x[a]-x[b]);
                            max = Math.max(max, size);
                        }else if(y[c] == y[b]){
                            int size = Math.abs(y[a]-y[c])*Math.abs(x[b]-x[c]);
                            max = Math.max(max, size);
                        }
                    }else if(x[b] == x[c]){
                        if(y[b] == y[a]){
                            int size = Math.abs(y[b]-y[c])*Math.abs(x[b]-x[a]);
                            max = Math.max(max, size);
                        }else if(y[c] == y[a]){
                            int size = Math.abs(y[b]-y[c])*Math.abs(x[c]-x[a]);
                            max = Math.max(max, size);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}