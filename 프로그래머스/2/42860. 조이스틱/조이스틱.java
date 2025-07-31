    import java.util.*;

    public class Solution {
        public int solution(String name) {
            int answer = 0;
            int n = name.length();
            int minMove = n - 1;

            for (int index = 0; index <name.length(); index++) {
                int ascii = name.charAt(index);
                int diff = Math.abs(ascii - 'A');
                answer += Math.min(diff, 26 - diff);
                int next = index + 1;
                while (next < n && name.charAt(next) == 'A') {
                    next++;
                }

                int move1 = index * 2 + (n - next);

                int move2 = (n - next) * 2 + index;

                minMove = Math.min(minMove, move1);
                minMove = Math.min(minMove, move2);
            }
            return answer + minMove;
        }
    }
