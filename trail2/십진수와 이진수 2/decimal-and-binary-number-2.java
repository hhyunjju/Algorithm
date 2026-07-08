import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        System.out.println(toBase(2, toDecimal(2, n) * 17));
    }

    public static int toDecimal(int base, String num){
        char[] arr = num.toCharArray();
        int result = 0;
        for(int i = 0 ; i < arr.length; i++){
            result = result * base + (arr[i] - '0');
        }
        return result;
    }

    public static String toBase(int base, int decimal){
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(decimal % base);
            decimal /= base;
            if(decimal == 0){
                break;
            }
            i++;
        }
        
        String result = "";
        for(int j = i ; j >= 0 ; j--){
            result += String.valueOf(list.get(j));
        }
        return result;
    }
}