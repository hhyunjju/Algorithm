import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2*n];
        for(int i = 0 ; i < 2*n ; i++){
            nums[i] = sc.nextInt();
        }
        // 원소의 합이 최댓값인 조합 -> 이게 최소여야 함.
        Arrays.sort(nums);
        int[] sums = new int[n];
        for(int i = 0 ; i < n ; i++){
            sums[i] = nums[i] + nums[2*n-i-1];
        }
        Arrays.sort(sums);
        System.out.println(sums[n-1]);
    }
}