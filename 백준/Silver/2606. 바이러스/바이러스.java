import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited = new boolean[101];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfComputer = scanner.nextInt();
        int numberOfPair = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0 ; i <= numberOfComputer; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < numberOfPair; i++) {
            String[] line = scanner.nextLine().split(" ");
            graph.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            graph.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }

        dfs(1);

        System.out.println(result - 1);
    }

    private static void dfs(int vertex) {
        if(visited[vertex]){
           return;
        }

        visited[vertex] = true;
        result++;
        ArrayList<Integer> target = graph.get(vertex);
        for (Integer integer : target) {
            dfs(integer);
        }
    }
}

