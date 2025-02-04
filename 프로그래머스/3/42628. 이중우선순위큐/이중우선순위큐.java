import java.util.*;

class Solution {
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