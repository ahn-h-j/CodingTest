import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        HashSet<String> resultSet = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];
        dfs(resultSet, visited, 0, user_id, banned_id, new String[banned_id.length]);
        return resultSet.size();
    }

    public void dfs(HashSet<String> resultSet, boolean[] visited, int banIndex, String[] user_id, String[] banned_id, String[] selected) {
        if (banIndex == banned_id.length) {
            String[] copy = selected.clone();
            Arrays.sort(copy);
            resultSet.add(String.join(",", copy));
            return;
        }
        for (int index = 0; index < user_id.length; index++) {
            if (!visited[index] && isMatch(user_id[index], banned_id[banIndex])) {
                visited[index] = true;
                selected[banIndex] = user_id[index];
                dfs(resultSet, visited, banIndex + 1, user_id, banned_id, selected);
                visited[index] = false;
            }
        }

    }
    public boolean isMatch(String user_id, String banned_id){
        if(user_id.length() != banned_id.length()){
            return false;
        }
        for(int i = 0; i < user_id.length(); i++){
            if(banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
