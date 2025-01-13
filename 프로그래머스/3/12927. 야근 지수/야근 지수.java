import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long solution(int n, int[] works) {
        long arraySum = Arrays.stream(works).sum();
        Queue<Integer> worksQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            worksQueue.add(work);
        }
        while(true){
            int maxElement = worksQueue.poll();
            int workAmount = maxElement - worksQueue.peek() + 1;

            arraySum -= workAmount;
            if(arraySum < 0){
                return 0;
            }

            if(workAmount < n){
                maxElement -= workAmount;
                worksQueue.add(maxElement);
                n -= workAmount;
            } else{
                maxElement -= n;
                worksQueue.add(maxElement);
                break;
            }
            if(n == 0){
                break;
            }
        }
        long answer = 0;
        for(int b : worksQueue){
           answer += b * b;
        }
        return answer;
    }
}