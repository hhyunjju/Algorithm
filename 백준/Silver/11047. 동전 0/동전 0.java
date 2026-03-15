import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            int ni = Integer.parseInt(br.readLine());
            nArr[i] = ni;
        }
        int result = 0;
        for (int i = n; i > 0; i--) {
            int cnt = k / nArr[i - 1];
            result += cnt;
            k -= nArr[i-1] * (cnt);
        }
        System.out.println(result);
    }
}