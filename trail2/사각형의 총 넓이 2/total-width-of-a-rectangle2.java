import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        boolean[][] visited = new boolean[200][200];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt()+100;
            int y1 = sc.nextInt()+100;
            int x2 = sc.nextInt()+100;
            int y2 = sc.nextInt()+100;

            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1 ; k < y2; k++){
                    if(visited[j][k]){
                        continue;
                    }
                    sum++;
                    visited[j][k] = true;
                }
            }
        }
        // Please write your code here.
        System.out.println(sum);
    }
}