import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 최대길이 (최소개수)를 구하라.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        int n = Integer.parseInt(kn[1]);
        int[] arr = new int[k];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, arr[i]);
        }

        // 최대길이
        long min = 1;
        long max = maxValue;

        // 다 해볼 순 없으니까 범위를 좁히는 것.
        long lb = -1;
        while(min <= max) {
            long mid = min + (max - min) / 2;
            if (getLenSum(mid, arr) >= n) {
                lb = mid;
                min = mid + 1;
            }else{
                // 길이가 너무 길다는 의미 -> 길이를 줄임.
                max = mid - 1;
            }
        }
        System.out.println(lb);
    }

    private static long getLenSum(long len, int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i]/len;
        }
        return sum;
    }
}