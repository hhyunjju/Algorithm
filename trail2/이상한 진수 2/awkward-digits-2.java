import java.util.*;
public class Main {
    public static int toBase(char[] arr){
        int result = 0;
        for(int i = 0 ; i < arr.length; i++){
            result = result*2 + (arr[i] - '0');
        }
        return result;
    }

    public static void main(String[] args) {
        // Please write your code here.
        // 이진수에서 숫자 하나만 바꿔서 최대값 만들기 -> 가장 왼쪽에 있는 0을 1로 만들기.
        Scanner sc = new Scanner(System.in);
        char[] aArr = sc.next().toCharArray();
        int max = 0;
        for(int i = 0 ; i < aArr.length ; i++){
            char temp = aArr[i];
            if(temp == '0'){
                aArr[i] = '1';
            }else{
                aArr[i] = '0';
            }
            max = Math.max(max, toBase(aArr));
            // 원복
            aArr[i] = temp;
        }
        System.out.println(max);
    }
}