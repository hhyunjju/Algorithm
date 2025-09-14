import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String input = sc.nextLine();
        List<String> temp = new ArrayList<>();
        List<String> words = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        for (String word : words) {
            while(input.contains(word)) {
                temp.add(word);
                input = input.replaceFirst(word, "&");
            }

        }
        System.out.println(temp.size() + input.replace("&", "").length());
    }
}