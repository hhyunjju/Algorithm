import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2000][2000];
        int offset = 1000;
        for(int i = 0 ; i < 2 ; i++){
            int x1 = sc.nextInt()+offset;
            int y1 = sc.nextInt()+offset;
            int x2 = sc.nextInt()+offset;
            int y2 = sc.nextInt()+offset;
            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1; k < y2 ; k++){
                    arr[j][k]++;
                }
            }
        }

        for(int i = 0 ; i < 1 ; i++){
            int x1 = sc.nextInt()+offset;
            int y1 = sc.nextInt()+offset;
            int x2 = sc.nextInt()+offset;
            int y2 = sc.nextInt()+offset;
            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1; k < y2 ; k++){
                    arr[j][k]+=2;
                }
            }
        }

        int result = 0;
        for (int i = 0 ; i < arr.length; i++){
            for ( int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}