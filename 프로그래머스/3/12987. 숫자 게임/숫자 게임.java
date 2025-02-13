import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        ArrayList<Integer> aList = new ArrayList<>();
        for (int a : A) {
            aList.add(a);
        }

        ArrayList<Integer> bList = new ArrayList<>();
        for (int b : B) {
            bList.add(b);
        }

        aList.sort(Integer::compareTo);
        bList.sort(Integer::compareTo);

        for (int a : aList) {
            for (int i = 0; i < bList.size(); i++) {
                if (a < bList.get(i)) {
                    {
                        bList.remove(i);
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

