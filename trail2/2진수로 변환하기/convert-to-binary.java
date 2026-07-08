import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] nums = new int[20];
        int i = 0;
        while(true){
            // 나머지를 nums에 추가
            nums[i] = n%2;
            n/=2;
            if(n == 0){
                break;
            }
            i++;
        }
        for(int j = i; j >=0 ; j--){
            System.out.print(nums[j]);
        }
    }
}