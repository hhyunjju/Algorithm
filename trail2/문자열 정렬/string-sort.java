import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] arr = new char[str.length()];

        for(int i = 0 ; i < str.length(); i++){
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr);
        for(int i=0 ; i < arr.length ; i++){
            System.out.print(arr[i]);
        }
    }
}