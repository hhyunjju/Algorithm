import java.util.*;
public class Main {
    private static int dis(int[][] xy, int skipIdx){
        int dis = 0;
        for(int i = 0 ; i< xy.length-1; i++){
            if(i == skipIdx){
                continue;
            }
            int x1 = xy[i][0];
            int y1 = xy[i][1];
            int x2 = xy[i+1][0];
            int y2 = xy[i+1][1];
            if(i+1 == skipIdx){
                x2 = xy[i+2][0];
                y2 = xy[i+2][1];
            }
            dis += Math.abs(x1-x2) + Math.abs(y1-y2);
        }
        return dis;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] xy = new int[n][2];
        int offset = 1000;

        for(int i = 0 ; i < n ; i++){
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }
 
        int min = Integer.MAX_VALUE; // long 이 아니라고 어떻게 확신하지?
        for(int i = 0 ; i < n ; i++){
            if(i == 0 || i == n-1){
                continue;
            }
            min = Math.min(min, dis(xy, i));
        }
        System.out.println(min);
    }
}