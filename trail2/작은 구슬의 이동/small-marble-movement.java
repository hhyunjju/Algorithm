import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean isRange(int r, int c){
        return r >= 1 && r <= arr.length-1 && c >=1 && c <= arr[0].length-1;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int r = sc.nextInt(); // 초기
        int c = sc.nextInt(); // 초기
        String d = sc.next(); // 초기 이동방향

        arr = new int[n+1][n+1];

        // t초 후 구슬의 r, c 번호 출력
        // U D R L
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int dir;
        if(d.equals("U")){
            dir = 3;
        }else if(d.equals("D")){
            dir = 1;
        }else if(d.equals("R")){
            dir = 0;
        }else{
            //L
            dir = 2;
        }
        for(int i = 0; i < t; i++){
            if(isRange(r+dr[dir], c+dc[dir])){
                r += dr[dir];
                c += dc[dir];
            }else{
                dir = (dir+2)%4;
            }
        }
        System.out.println(r + " " + c);
    }
}