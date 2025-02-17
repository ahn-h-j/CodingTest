import java.util.LinkedList;
import java.util.List;

class Solution{
    public int solution(int[] players, int m, int k){
        int answer = 0;
        int server = 0;
        List<Integer> time = new LinkedList<>();
        int times = 0;

        for(int player : players){
            if(player >= (m * server + 1)){
                answer += (player / m) - server;
                server += (player / m) - server;
            }

            if(server >= 1){
                for(int serverIndex = 0; serverIndex < server; serverIndex++){
                    if(time.size() < server) {
                        time.add(0, 1);
                    }else {
                        time.set(serverIndex, time.get(serverIndex) + 1);
                    }
                }

                for(int serverIndex = 0; serverIndex < server; serverIndex++){
                    if(time.get(serverIndex) == k){
                        time.remove(serverIndex);
                        server--;
                        serverIndex--;
                    }
                }
            }
        }
        return answer;
    }
}