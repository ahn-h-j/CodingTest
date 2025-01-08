import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{7,9,1,1,4}));
    }
    public int solution(int[] elements) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int index = 0; index < elements.length; index++) {
            arrayList.add(elements[index]);
        }

        int index = 0;
        for(int dist = 1; dist < elements.length; dist++){
            for(int count = 0; count < elements.length; count++){
                int operand1 = arrayList.get(index);
                int operand2 = elements[(index % elements.length + dist) % elements.length];
                int result = operand1 + operand2;
                index++;
                arrayList.add(result);
            }
        }
        int sum = 0;
        for(int i = 0; i < elements.length; i++){
            sum += elements[i];
        }
        arrayList.add(sum);
        Set<Integer> set = new HashSet(arrayList);

            // 7 9 1 1 4
            // 16 10 2 5 11
            // 17 11 6 12 20
            // 현 단계의 결과 저장 후 다음 반복시 index + 1의 값을 더해줌
        return set.size();
    }
}