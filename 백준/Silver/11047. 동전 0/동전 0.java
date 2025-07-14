import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinCount = 0;
        
        String[] inputs = scanner.nextLine().split(" ");
        int numberOfCoinType = Integer.parseInt(inputs[0]);
        int targetPrice = Integer.parseInt(inputs[1]);
        int[] coins = new int[numberOfCoinType];

        inputCoin(numberOfCoinType, coins, scanner);
        Arrays.sort(coins);
        coinCount = getCoinCount(coins, targetPrice, coinCount);
        
        System.out.println(coinCount);
    }

    private static int getCoinCount(int[] coins, int targetPrice, int coinCount) {
        for (int coinIndex = coins.length - 1; coinIndex >= 0; coinIndex--) {
            int coin = coins[coinIndex];
            if(targetPrice / coin != 0){
                coinCount += targetPrice /coin;
                targetPrice -= (targetPrice /coin) * coin;
            }
        }
        return coinCount;
    }

    private static void inputCoin(int numberOfCoinType, int[] coins, Scanner scanner) {
        for(int coinIndex = 0; coinIndex < numberOfCoinType; coinIndex++){
            coins[coinIndex] = scanner.nextInt();
        }
    }
}
