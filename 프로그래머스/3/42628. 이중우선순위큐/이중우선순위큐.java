import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution.solution(operations)));
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution.solution(operations2)));
    }
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascendingQueue = new PriorityQueue<>();
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations){
            if(operation.equals("D -1")){
                if(!ascendingQueue.isEmpty()){
                    int max = ascendingQueue.remove();
                    descendingQueue.remove(max);
                }
            }else if(operation.equals("D 1")){
                if(!descendingQueue.isEmpty()){
                    int min = descendingQueue.remove();
                    ascendingQueue.remove(min);
                }
            }else{
                String[] input = operation.split(" ");
                ascendingQueue.add(Integer.parseInt(input[1]));
                descendingQueue.add(Integer.parseInt(input[1]));
            }
        }
        int max = 0, min = 0;
        if(!descendingQueue.isEmpty()){
            max = descendingQueue.remove();
        }
        if(!ascendingQueue.isEmpty()){
            min = ascendingQueue.remove();
        }
        return new int[]{max, min};
    }
}