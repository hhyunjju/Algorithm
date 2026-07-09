import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 타일 = 지점과 동일
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[200_000];
        int[] bArr = new int[200_000];
        int[] wArr = new int[200_000];

        int cur = 0+100_000;

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            String dir = sc.next();
        
            // x칸을 칠함 -> 검정색
            if(dir.equals("R")){
                for(int j = 0 ; j < x ; j++){
                    bArr[cur+j] += 1;
                    arr[cur+j] = 1;
                }
                // 마지막으로 칠한 위치로 이동
                cur += (x-1);
            }else{
                // L -> 흰색
                for(int j = 0 ; j < x ; j++){
                    wArr[cur-j] += 1;
                    arr[cur-j] = -1;
                }
                cur -= (x-1);
            }
        }

        int bCnt = 0;
        int wCnt = 0;
        int gCnt = 0;
        for(int k = 0 ; k < 200_000 ; k++){
            if(bArr[k] >= 2 && wArr[k] >= 2){
                gCnt++;
            }else if(arr[k] == 1){
                bCnt++;
            }else if(arr[k] == -1){
                wCnt++;
            }
        }
        System.out.println(wCnt + " " + bCnt + " "+ gCnt);
    }
}