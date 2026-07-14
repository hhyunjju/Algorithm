import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        /*
        L -> 왼쪽 90도 S -> E -> N ->  W -> S : (+1) % 4
        R -> 오른쪽 90도 S -> W -> N -> E -> S : (-1 + 4) % 4
        F -> 0
        */
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int dir = 0; // N

        char[] arr = sc.next().toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'L'){
                dir = (dir + 3) % 4; 
            }else if(arr[i] == 'R'){
                dir = (dir + 1) % 4;
            }else{
                //F
                x += dx[dir];
                y += dy[dir];
            }
        }
        System.out.println(x + " " + y);
    }
}