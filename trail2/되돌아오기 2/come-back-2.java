import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();

        // U L D R U : 왼쪽
        // U R D L U : 오른쪽 
        int[] dx = {0, 1, 0, -1}; // L R D U -> U R D L
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == 'L'){
                dir = (dir+3)%4;
            }else if(arr[i] == 'R'){
                dir = (dir+1)%4;
            }else{
                // F
                x += dx[dir];
                y += dy[dir];

                if(x == 0 & y == 0){
                    System.out.println(i+1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}