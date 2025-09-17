import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(split1[0]); // 카드의 개수
        int m = Integer.parseInt(split1[1]); // 넘지 않으면서 최대한 가까운 값을 구해야 하는 수
        int[] cards = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int maxSum = 0;

        // 투 포인터 탐색
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = cards[i] + cards[left] + cards[right];
                if (sum == m) {
                    maxSum = sum;
                    break;
                }else if(sum < m) {
                    if(sum > maxSum) {
                        maxSum = sum;
                    }
                    left++;
                }else{
                    right--;
                }
            }
            if(maxSum == m) {
                break;
            }
        }
        System.out.println(maxSum);
        sc.close();

    }
}