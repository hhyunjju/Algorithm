import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nArr = br.readLine().split(" ");
        int[] nIntArr = Arrays.stream(nArr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nIntArr);

        int m = Integer.parseInt(br.readLine());
        String[] mArr = br.readLine().split(" ");

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(mArr[i]);
            sj.add(String.valueOf(getTargetCnt(nIntArr, target)));
        }
        System.out.println(sj.toString());
    }

    private static int getTargetCnt(int[] nArr, int target) {
        int lb = getLb(nArr, target);
        if(lb == -1){
            return 0;
        }
        int ub = getUb(nArr, target);
        return ub-lb+1;
    }

    private static int getLb(int[] nArr, int target) {
        int leftIdx = 0;
        int rightIdx = nArr.length - 1;
        int lb = -1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (nArr[midIdx] >= target) {
                lb =  midIdx;
                rightIdx = midIdx - 1;
            }else{
                leftIdx = midIdx + 1;
            }
        }
        if (lb == -1 || nArr[lb] != target) {
            return -1;
        }
        return lb;
    }

    private static int getUb(int[] nArr, int target) {
        int leftIdx = 0;
        int rightIdx = nArr.length - 1;
        int ub = -1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (nArr[midIdx] <= target) {
                ub =  midIdx;
                leftIdx = midIdx + 1;
            }else{
                rightIdx = midIdx -1;
            }
        }
        if (ub==-1||nArr[ub] != target) {
            return -1;
        }
        return ub;
    }
}