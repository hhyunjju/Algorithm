import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] arr = new char[101];

        for(int i = 0 ; i<n; i++){
            int idx = sc.nextInt();
            String str = sc.next();
            arr[idx] = str.charAt(0);
        }

        // 최대 사진의 크기 -> 다 해보기
        int max = 0;
        // 시작점
        for(int s = 0 ; s < arr.length; s++){
            if(arr[s]=='\0'){
                continue;
            }
            for(int e = s+1; e < arr.length; e++){
                if(arr[e] == '\0'){
                    continue;
                }
                int gCnt = 0;
                int hCnt = 0;
                for(int i = s ; i <= e ;i++){
                    if(arr[i] == 'G'){
                        gCnt++;
                    }else if(arr[i] == 'H'){
                        hCnt++;
                    }
                }
                if(gCnt == hCnt || gCnt == 0 || hCnt ==0){
                    max = Math.max(max, e-s);
                }
            }
        }
        System.out.println(max);
    }
}