    import java.util.Arrays;
    import java.util.Scanner;


    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numberOfLevel = scanner.nextInt();
            int[] levelPoint = getLevelPoint(numberOfLevel, scanner);
            System.out.println(calculateMinReductions(levelPoint, numberOfLevel));
        }

        private static int calculateMinReductions(int[] levelPoint, int numberOfLevel) {
            int sum = 0;
            int prePoint = levelPoint[numberOfLevel - 1];
            for (int level = numberOfLevel - 2; level >= 0; level--) {
                int point = levelPoint[level];
                if(point >= prePoint){
                    int gap = point - prePoint + 1;
                    levelPoint[level] = point - gap;
                    sum += gap;
                }
                prePoint = levelPoint[level];
            }
            return sum;
        }

        private static int[] getLevelPoint(int numberOfLevel, Scanner scanner) {
            int[] levelPoint = new int[numberOfLevel];
            for (int level = 0; level < numberOfLevel; level++) {
                levelPoint[level] = scanner.nextInt();
            }
            return levelPoint;
        }

        private static int getSum(int numberOfPeople, int[] usageTime) {
            int sum = 0;
            int presum = 0;
            for (int index = 0; index < numberOfPeople; index++) {
                presum += usageTime[index];
                sum += presum;
            }
            return sum;
        }
    }
