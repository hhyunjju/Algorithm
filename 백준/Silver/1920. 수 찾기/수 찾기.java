import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] mArr = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(a[i]), 0);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.containsKey(Integer.parseInt(mArr[i])) ? 1 : 0);
        }
    }
}