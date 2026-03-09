import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 핵심: 이분 탐색의 범위를 long으로 잡아야 함
        // max에 1을 더하는 이유는 mid가 0이 되는 것을 방지하고 
        // 상한선(Upper Bound)을 찾기 위함입니다.
        max++; 

        long min = 0; 
        long mid = 0; 

        while (min < max) {
            mid = (min + max) / 2;
            
            // 0으로 나누기 방지
            if (mid == 0) {
                min = 1;
                break;
            }

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            // [Upper Bound 방식]
            // 개수가 N보다 작으면 길이를 줄여야 함
            if (count < N) {
                max = mid;
            } else {
                // 개수가 N보다 크거나 같으면 일단 길이를 늘려봄
                min = mid + 1;
            }
        }

        // 찾고자 하는 값은 상한선에서 1을 뺀 값
        System.out.println(min - 1);
    }
}