import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nArr = br.readLine().split(" ");
        // nArr을 map으로 만들기
        Map<Integer, Integer> map = Arrays.stream(nArr)
                .map(Integer::valueOf)
                .collect(Collectors.toMap(Function.identity(), val -> val, (oldVal, newVal) -> oldVal));

        int m = Integer.parseInt(br.readLine());
        String[] mArr = br.readLine().split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (int j = 0; j < m; j++) {
            int item = Integer.parseInt(mArr[j]);
            if(map.containsKey(item)){
                sj.add("1");
            }else{
                sj.add("0");
            }
        }
        System.out.println(sj.toString());
    }
}