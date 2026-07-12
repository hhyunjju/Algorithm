import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[2000][2000];
        int offset = 1000;

        for(int i = 0 ; i < 2 ; i++){
            int x1 = sc.nextInt();
            int y1= sc.nextInt();
            int x2 = sc.nextInt();
            int y2= sc.nextInt();
            for(int j = x1 ; j < x2; j++){
                for(int k = y1; k < y2; k++){
                    arr[j+offset][k+offset] = i+1;
                }
            }
        }
        int minX = 2000;
        int minY = 2000;
        int maxX = 0;
        int maxY = 0;

        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int cnt = 0;
        for(int i = minX ; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++){
                cnt++;
            }
        }


        System.out.println(cnt);
    }
}