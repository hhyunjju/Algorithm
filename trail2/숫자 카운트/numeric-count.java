import java.util.*;

public class Main {
    private static int[] nums;
    private static int[] returnCnt(int a, int b){
        int oneCnt = 0;
        int twoCnt = 0;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(a/(int)Math.pow(10, i)%10 == b/(int)Math.pow(10, j)%10){
                    if(i==j){
                        oneCnt++;
                    }else{
                        twoCnt++;
                    }
                }
            }
        }
        return new int[]{oneCnt, twoCnt};
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] ones = new int[n];
        int[] twos = new int[n];

        for(int i = 0 ; i < n ;i++){
            nums[i] = sc.nextInt();
            ones[i] = sc.nextInt();
            twos[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int a = 1 ; a <= 9 ; a++){
            for(int b = 1 ; b <= 9 ; b++){
                for(int c = 1; c <= 9 ; c++){
                    if(a == b || a == c || b == c){
                        continue;
                    }
                    int expected = a*100 + b*10 +c;
                    boolean isCand = true;
                    for(int i = 0 ; i < n ; i++){
                        int[] expectedArr = returnCnt(expected, nums[i]);
                        if(!(ones[i] == expectedArr[0] && twos[i] == expectedArr[1])){
                            isCand = false;
                            break;
                        }
                    }
                    if(isCand){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}