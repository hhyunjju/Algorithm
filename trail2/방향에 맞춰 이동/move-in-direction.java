import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x = 0;
        int y = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0 ; i < n ; i++){
            String dir = sc.next();
            int dis = sc.nextInt();
            int idx = -1;
            if(dir.equals("W")){
                idx = 0;
            }else if(dir.equals("E")){
                idx = 1;
            }else if(dir.equals("N")){
                idx = 2;
            }else{
                idx = 3;
            }
            x+=dx[idx]*dis;
            y+=dy[idx]*dis;
        }

        // 최종위치
        System.out.println(x + " "+y);
    }
}