import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer> circle = new ArrayList<>();
        ArrayList<Integer> remove = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            circle.add(i + 1);
        }
        int temp = 0;
        while (!circle.isEmpty()) {
            temp += (K - 1);
            if(temp >= circle.size()){
                temp %= circle.size();
            }
            remove.add(circle.get(temp));
            circle.remove(temp);
        }
        String result = remove.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("<" + result + ">");
    }
}
