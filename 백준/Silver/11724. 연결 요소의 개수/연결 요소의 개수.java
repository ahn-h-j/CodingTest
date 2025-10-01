import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int numberOfVertex = 0;
    static int numberOfEdge = 0;
    static boolean[] visited = new boolean[1001];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] condition = scanner.nextLine().split(" ");
        numberOfVertex = Integer.parseInt(condition[0]);
        numberOfEdge = Integer.parseInt(condition[1]);

        for (int i = 0; i <= numberOfVertex; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < numberOfEdge; i++) {
            String[] edge = scanner.nextLine().split(" ");
            graph.get(Integer.parseInt(edge[0])).add(Integer.parseInt(edge[1]));
            graph.get(Integer.parseInt(edge[1])).add(Integer.parseInt(edge[0]));
        }
        for (int vertex = 1; vertex <= numberOfVertex; vertex++) {
            if(dfs(vertex)){
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean dfs(int vertex) {
        if(visited[vertex]){
           return false;
        }
        visited[vertex] = true;
        ArrayList<Integer> target = graph.get(vertex);
        for (Integer integer : target) {
            dfs(integer);
        }
        return true;
    }
}
