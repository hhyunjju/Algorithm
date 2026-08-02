import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] timeline = new int[1001];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            for(int j = A[i]; j < B[i] ; j++){
                timeline[j]++;
            }
        }
        // Please write your code here.
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            int a = A[i];
            int b = B[i];
            for(int j = a ; j < b ; j++){
                timeline[j]--;
            }
            int sum = 0;
            for(int j = 1 ; j <= 1000; j++){
                if(timeline[j] > 0){
                    sum++;
                }
            }
            max = Math.max(max, sum);
            for(int j = a ; j < b ; j++){
                timeline[j]++;
            }
        }
        System.out.println(max);
    }
}