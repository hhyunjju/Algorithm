import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        char[] arr = binary.toCharArray();
        int result = 0;
        for(int i = 0 ; i < arr.length; i++){
            result += Math.pow(2, i)*(arr[arr.length-1-i] - '0');
        }
        System.out.println(result);
    }
}