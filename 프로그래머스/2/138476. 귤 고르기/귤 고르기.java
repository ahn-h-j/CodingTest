import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> count = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++){
            count.put(tangerine[i], count.getOrDefault(tangerine[i],0) + 1);
        }

        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(count.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        while(k > 0){
            k -= entryList.get(0).getValue();
            entryList.remove(0);
            answer++;
        }

        return answer;
    }
}