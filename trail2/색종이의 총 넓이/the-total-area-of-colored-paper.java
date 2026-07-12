import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] visited = new boolean[200][200];
        int offset = 100;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            for(int j = 0 ; j < 8 ; j++){
                for ( int k = 0 ; k < 8 ; k++){
                    if(visited[j+x1+offset][k+y1+offset]){
                        continue;
                    }
                    sum++;
                    visited[j+x1+offset][k+y1+offset] = true;
                }
            }
        }
        System.out.println(sum);
    }
}