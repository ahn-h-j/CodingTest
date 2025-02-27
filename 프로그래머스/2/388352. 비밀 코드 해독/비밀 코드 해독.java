import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<Set<Integer>> candidates = new ArrayList<>();

        generateCombinations(n, new ArrayList<>(), 1, candidates);

        Map<Integer, List<int[]>> queryMap = new HashMap<>();
        for (int i = 0; i < q.length; i++) {
            if (!queryMap.containsKey(ans[i])) {
                queryMap.put(ans[i], new ArrayList<>());
            }
            queryMap.get(ans[i]).add(q[i]);
        }

        List<Integer> sortedKeys = new ArrayList<>(queryMap.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder()); 

        for (int key : sortedKeys) {
            List<int[]> queries = queryMap.get(key);
            for (int[] query : queries) {
                Iterator<Set<Integer>> it = candidates.iterator();
                while (it.hasNext()) {
                    if (countMatches(it.next(), query) != key) {
                        it.remove();
                    }
                }
            }
        }

        return candidates.size();
    }

    private void generateCombinations(int n, List<Integer> current, int start, List<Set<Integer>> result) {
        if (current.size() == 5) {
            result.add(new HashSet<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, current, i + 1, result);
            current.remove(current.size() - 1);
        }
    }

    private int countMatches(Set<Integer> candidate, int[] query) {
        int count = 0;
        for (int num : query) {
            if (candidate.contains(num)) count++;
        }
        return count;
    }
}
