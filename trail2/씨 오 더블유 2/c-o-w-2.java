import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 'C'){
                for(int j = i ; j < n; j++){
                    if(arr[j] == 'O'){
                        for(int k = j+1 ; k < n ; k++){
                            if(arr[k] == 'W'){
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}