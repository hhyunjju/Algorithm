import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();

        int[] dx = {-1, 1, 0, 0}; // W, E, N, S
        int[] dy = {0, 0, 1, -1};

        int x = 0;
        int y = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            String dir = sc.next();
            int dis = sc.nextInt();
            int dirIdx;
            if(dir.equals("W")){
                dirIdx = 0;
            }else if(dir.equals("E")){
                dirIdx = 1;
            }else if(dir.equals("N")){
                dirIdx = 2;
            }else{
                // S
                dirIdx = 3;
            }

            for(int j = 0 ; j < dis ; j++){
                x += dx[dirIdx];
                y += dy[dirIdx];
                result++;
                if(x==0 && y==0){
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}