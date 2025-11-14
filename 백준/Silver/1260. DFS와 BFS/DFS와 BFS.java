import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dfsVisited = new int[1001];
    static int[] bfsVisited = new int[1001];
    static StringBuilder dfsResult = new StringBuilder();  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] graphInput = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(graphInput[0]);
        int edge = Integer.parseInt(graphInput[1]);
        int startVertex = Integer.parseInt(graphInput[2]);

        for(int i = 0 ; i <= vertex ; i++) graph.add(new ArrayList<>());
        for (int line = 0; line < edge; line++) {
            String[] endPoint = scanner.nextLine().split(" ");
            graph.get(Integer.parseInt(endPoint[0])).add(Integer.parseInt(endPoint[1]));
            graph.get(Integer.parseInt(endPoint[1])).add(Integer.parseInt(endPoint[0]));
        }

        for(int i = 0; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(startVertex);
        System.out.println(dfsResult);
        System.out.println(bfs(startVertex));

    }

    private static void dfs(int vertex){
        dfsVisited[vertex] = 1;
        dfsResult.append(vertex).append(" ");

        for (Integer next : graph.get(vertex)) {
            if(dfsVisited[next] == 0){
                dfs(next);
            }
        }
    }

    private static String bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.add(startVertex);
        bfsVisited[startVertex] = 1;
        stringBuilder.append(startVertex).append(" ");

        while(!queue.isEmpty()){
            int targetPoint = queue.poll();
            ArrayList<Integer> edges = graph.get(targetPoint);
            for (Integer edge : edges) {
                if(bfsVisited[edge] == 0){
                    bfsVisited[edge] = 1;
                    stringBuilder.append(edge).append(" ");
                    queue.offer(edge);
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}
