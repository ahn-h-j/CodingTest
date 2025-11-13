import java.util.*;

public class Main {

    static int numberOfTestCase;
    static int width;
    static int height;
    static int numberOfPlace;
    static int[][] graph = new int[51][51];
    static int result = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        numberOfTestCase = scanner.nextInt();
        scanner.nextLine();


        for(int testCase = 0; testCase < numberOfTestCase; testCase++){

            result = 0;

            String[] input = scanner.nextLine().split(" ");
            width = Integer.parseInt(input[0]);
            height = Integer.parseInt(input[1]);
            numberOfPlace = Integer.parseInt(input[2]);

            for (int coordinate = 0; coordinate < numberOfPlace; coordinate++) {
                String[] coordinateInput = scanner.nextLine().split(" ");
                graph[Integer.parseInt(coordinateInput[0])][Integer.parseInt(coordinateInput[1])] = 1;
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if(dfs(x, y)){
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static boolean dfs(int x, int y) {

        if(x < 0 || x >= width || y < 0 || y >= height){
            return false;
        }

        if(graph[x][y] == 0){
            return false;
        }

        graph[x][y] = 0;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);

        return true;
    }
}
