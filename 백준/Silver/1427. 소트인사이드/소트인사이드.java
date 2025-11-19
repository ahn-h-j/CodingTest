import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        int operand = 10;

        while(N > 0){
            list.add(N % operand);
            N /= operand;
        }
        Collections.sort(list, Collections.reverseOrder());

        for (Integer i : list) {
            System.out.print(i);
        }
    }
}
