import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost) {
            lostSet.add(l);
        }

        Set<Integer> reserveSet = new HashSet<>();
        for (int l : reserve) {
            reserveSet.add(l);
        }

        List<Integer> selfHelp = new ArrayList<>();
        for (int student : lostSet) {
            if (reserveSet.contains(student)) {
                selfHelp.add(student);
            }
        }

        for (int student : selfHelp) {
            lostSet.remove(student);
            reserveSet.remove(student);
            answer++;
        }

        for (int l : lostSet) {
            if(reserveSet.contains(l - 1)){
                reserveSet.remove(l - 1);
                answer++;
            } else if(reserveSet.contains(l + 1)){
                reserveSet.remove(l + 1);
                answer++;
            }
        }

        return answer;
    }


}
