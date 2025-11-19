import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCondition = scanner.nextLine().split(" ");
        int numberOfTree = Integer.parseInt(inputCondition[0]);
        int requiredLength = Integer.parseInt(inputCondition[1]);

        List<Integer> treeHeights = new ArrayList<>();
        for (String treeHeight : scanner.nextLine().split(" ")) {
            treeHeights.add(Integer.parseInt(treeHeight));
        }

        Collections.sort(treeHeights);

        System.out.print(findMaxCutHeight(treeHeights, requiredLength, 0, treeHeights.get(treeHeights.size() - 1)));
    }

    private static int findMaxCutHeight(List<Integer> treeHeights, int minRequiredLength, int low, int high) {
        int answer = 0;
        
        while(low <= high){
            int cutHeight = (low + high) / 2;
            long result = calculateHeight(treeHeights, cutHeight);
        
            if(result >= minRequiredLength){
                answer = cutHeight;
                low = cutHeight + 1;
            }
            else {
                high = cutHeight - 1;
            }
        }
        return answer;
    }

    private static long calculateHeight(List<Integer> treeHeights, int cut) {
        long result = 0;

        for (Integer tree : treeHeights) {
            if(tree > cut){
                result += (tree - cut);
            }
        }
        return result;
    }
}
