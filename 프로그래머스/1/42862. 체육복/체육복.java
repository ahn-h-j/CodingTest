    import java.util.*;

    public class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            List<Integer> lostList = new ArrayList<>();
            for (int i : lost) {
                lostList.add(i);
            }
            Collections.sort(lostList);

            List<Integer> reverseList = new ArrayList<>();
            for (int i : reserve) {
                reverseList.add(i);
            }
            Collections.sort(reverseList);

            Iterator<Integer> iter = reverseList.iterator();
            while (iter.hasNext()) {
                Integer i = iter.next();
                if (lostList.contains(i)) {
                    lostList.remove(i);
                    iter.remove();  
                }
            }

            for (Integer i : reverseList) {
                if(lostList.contains(i-1)){
                    lostList.remove(Integer.valueOf(i-1));
                }else if (lostList.contains(i+1)){
                    lostList.remove(Integer.valueOf(i+1));
                }
            }

            return n - lostList.size();
        }
    }
