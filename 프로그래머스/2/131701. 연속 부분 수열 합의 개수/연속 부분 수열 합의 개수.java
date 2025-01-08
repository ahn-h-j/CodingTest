import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{7,9,1,1,4}));
    }
    public int solution(int[] elements) {
        List<Integer> arrayList = new ArrayList();
        for(int index = 0; index < elements.length; index++) {
            arrayList.add(elements[index]);
        }

        int index = 0;
        for(int dist = 1; dist < elements.length - 1; dist++){
            for(int count = 0; count < elements.length; count++){
                arrayList.add(arrayList.get(index) + elements[(index + dist) % elements.length]);
                index++;
            }
        }
        arrayList.add(Arrays.stream(elements).sum());
        Set<Integer> set = new HashSet(arrayList);

        return set.size();
    }
}
