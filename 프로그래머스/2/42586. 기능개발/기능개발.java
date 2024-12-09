import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer,Integer> todayDeployCount = new LinkedHashMap<>();
        ArrayList<Integer> remainDays = new ArrayList<>();

        findRemainDay(remainDays,progresses,speeds);
        calculateDeployDay(remainDays);

        return calculateDeployCount(remainDays,todayDeployCount);
    }

    public void findRemainDay(ArrayList<Integer> remainDays, int[] progresses, int[] speeds){
        for(int index = 0; index < progresses.length; index++){
            int remainDay = (int)Math.ceil((double)(100 - progresses[index]) / speeds[index]);
            remainDays.add(remainDay);
        }
    }

    public void calculateDeployDay(ArrayList<Integer> remainDays){
        for(int index = 0; index < remainDays.size() - 1; index++){
            if(remainDays.get(index) > remainDays.get(index + 1)){
                remainDays.set(index + 1, remainDays.get(index));
            }
        }
    }

    public int[] calculateDeployCount(ArrayList<Integer> remainDays, Map<Integer,Integer> todayDeployCount){
        for(int index = 0; index < remainDays.size(); index++){
            todayDeployCount.put(remainDays.get(index), todayDeployCount.getOrDefault(remainDays.get(index),0) + 1);
        }
        return todayDeployCount.values().stream().mapToInt(Integer::intValue).toArray();
    }
}