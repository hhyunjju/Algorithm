import java.util.*;

public class Main {
    private static char[][] arr;
    
    private static int dir;
    private static int r;
    private static int c;

    private static int[] dr = {-1, 1, 0, 0}; // 위 아래 왼쪽 오른쪽 0<>3 / 1<>2
    private static int[] dc = {0, 0, -1, 1}; // 1<>3 0<>2

    private static int[] slash = {3, 2, 1, 0};      // '/' 반사
    private static int[] backslash = {2, 3, 0, 1};  // '\' 반사

    private static boolean isRange(int r, int c){
        return r>=0 && r< arr.length && c>= 0 && c < arr[0].length;
    }

    private static void initialize(int k, int n){
        if(k<=n){
            dir = 1;
            r = 0;
            c = k-1;
        }else if(k <= 2*n){
            dir = 2;
            r = (k-n)-1;
            c = n-1;
        }else if(k <= 3*n){
            dir = 0;
            r = n-1;
            c = 3*n - k;
        }else{
            dir = 3;
            r = 4*n - k;
            c = 0;
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        // 거울에 튕기는 횟수 구하기
        for(int r= 0 ; r < n ; r++){
            char[] rowArr = sc.next().toCharArray();
            for(int c = 0 ; c < n ; c++){
                arr[r][c] = rowArr[c];
            }
        }
        int k = sc.nextInt();
        
        // 시작 위치와 방향 추출
        initialize(k, n);

        // (r,c)에서 dir 방향으로 시작하여 시뮬레이션 진행
        int cnt = 0;
        while(isRange(r, c)){
            // next 로 move
            if(arr[r][c] == '/'){
                dir = slash[dir];
                r += dr[dir];
                c += dc[dir];
            }else{
                dir = backslash[dir];
                r += dr[dir];
                c += dc[dir];
            }
            cnt++;
        }
        System.out.println(cnt); 

        //-----------------------------------------
        // // 한번에 방향전환 + 이동가지
        // // 범위를 벗어나면 종료

        // // D L U R 
        // // 123 / 456 / 987 / 101112

        // // 시작방향
        // int dir = (k-1+4)%4-1;
        // dr = new int[]{1, 0, -1, 0};
        // dc = new int[]{0, -1, 0, 1};

        // // 튕기는 횟수 (점유 횟수)
        // int cnt = 0;

        // // k의 위치 구하기
        // int r = 0;
        // int c = 0;
        // if(dir == 0){
        //     r = 0;
        //     c = k-1;
        // }else if(dir == 2){
        //     r = n-1;
        //     c = k-1;
        // }else if(dir == 1){
        //     r = (k%n)-1;
        //     c = n-1;
        // }else{
        //     // dir == 3
        //     r = n - ((k%n)-1);
        //     c = 0;
        // }

        // while(true){
        //     if(arr[r][c] == '/'){ // 반시계
        //         dir = (dir+3)%4;
        //     }else{
        //         dir = (dir+1)%4;
        //     }

        //     if(!isRange(r + dr[dir], c + dc[dir])){
        //         break;
        //     }
        //     r = r + dr[dir];
        //     c = c + dc[dir];
        //     cnt++;

        // }
        // System.out.println(cnt);
    }
}