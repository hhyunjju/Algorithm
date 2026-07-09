import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 지나간 "구간" -> 끝 지점은 포함 X
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[200];
        int cur = 100;

        for(int i = 0 ; i < n; i++){
            int x = sc.nextInt();
            String dir = sc.next();
            if(dir.equals("R")){
                // 끝지점은 포함X
                for(int j = 0 ; j < x ; j++){
                    arr[cur+j] += 1; 
                }

                cur += x;
            }else{
                // L
                // 끝지점은 포함X
                for(int j = 0 ; j < x ; j++){
                    arr[cur-1-j] += 1; 
                }
                cur -= x;
            }
        }

        int cnt = 0;
        for(int l = 0 ; l < arr.length ; l++){
            if(arr[l] > 1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}