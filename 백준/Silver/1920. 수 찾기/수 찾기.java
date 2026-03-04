import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        Set<String> aSet = Arrays.stream(a).collect(Collectors.toSet());
        int m = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int result = aSet.contains(inputs[i]) ? 1 : 0;
            System.out.println(result);
        }
    }
}