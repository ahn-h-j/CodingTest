import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int coinCount = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};

        Scanner scanner = new Scanner(System.in);

        int refund = 1000 - scanner.nextInt();
        for (int coin : coins) {
            if(refund / coin != 0){
                coinCount += refund / coin;
                refund -= (refund / coin) * coin;
            }
        }
        System.out.println(coinCount);

    }
}
