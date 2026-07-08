import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String n = sc.next();

       // a 진수로 표현된 수 : n
       // n을 b진수로 변환하여 출력

       // 1. n을 10진수로 변환 -> decimalN
       int de = toDecimal(a, n);

       // 2. decimalN을 b진수로 변환
        System.out.println(toBase(b, de));
    }

    public static String toBase(int base, int decimalNum){
        int[] resultArr = new int[20];
        int idx = 0;
        while(true){
            resultArr[idx] = decimalNum % base;
            decimalNum /= base;
            if(decimalNum == 0){
                break;
            }
            idx++;
        }
        String result = "";
        for(int i = idx; i >= 0; i--){
            result += String.valueOf(resultArr[i]);
        }
        return result;
    }

    public static int toDecimal(int base, String n){
        char[] arr = n.toCharArray();
        int result = 0;
        for(int i = 0 ; i < arr.length; i++){
            result = result * base + (arr[i] - '0');
        }
        return result;
    }
}