import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remainDays = new LinkedList<>();
        findRemainDay(remainDays,progresses,speeds);
        return calculateDeployDay(remainDays);
    }

    public void findRemainDay(Queue<Integer> remainDays, int[] progresses, int[] speeds){
        for(int index = 0; index < progresses.length; index++){
            int remainDay = (int)Math.ceil((double)(100 - progresses[index]) / speeds[index]);
            remainDays.offer(remainDay);
        }
    }

    public int[] calculateDeployDay(Queue<Integer> remainDays){
        ArrayList<Integer> deployCount = new ArrayList<>();
        int dayDeployCount = 1;

        int deployDay = remainDays.poll();
        while(!remainDays.isEmpty()){
            int nextDeployDay = remainDays.poll();
            if(deployDay >= nextDeployDay){
                dayDeployCount++;
            }else{
                deployCount.add(dayDeployCount);
                deployDay = nextDeployDay;
                dayDeployCount = 1;
            }
        }

        deployCount.add(dayDeployCount);
        return deployCount.stream().mapToInt(Integer::intValue).toArray();
    }

}
