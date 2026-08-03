import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int result = 0;
        for(int i = x ; i <= y ; i++){
            int v = i;
            int[] nums = new int[10];
            while(v!=0){
                nums[v%10]++;
                v/=10;
            }
            boolean hasOne = false;
            int cnt = 0;
            for(int j = 0 ; j < nums.length; j++){
                if(nums[j]>0){
                    cnt++;
                }
                if(nums[j] == 1){
                    hasOne = true;
                }
            }
            if(cnt == 2 && hasOne){
                result++;
            }
        }
        System.out.println(result);
    }
}