import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int min = 1_600_000_000;
        for(int i = 0 ; i < N ; i++){
            // i 를 빼는 경우
            int minX = 40_000;
            int minY = 40_000;
            int maxX = 0;
            int maxY = 0;
            for(int j = 0 ; j < N ; j++){
                if(j == i){
                    continue;
                }
                minX = Math.min(minX, x[j]);
                minY = Math.min(minY, y[j]);
                maxX = Math.max(maxX, x[j]);
                maxY = Math.max(maxY, y[j]);
            }
            int size = (maxX-minX)*(maxY-minY);
            min = Math.min(min, size);
        }
        System.out.println(min);
    }
}