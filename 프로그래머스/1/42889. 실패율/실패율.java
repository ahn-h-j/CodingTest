import java.util.*;

class Status{
    private int index;
    private double failureRate;
    public Status(int index, double failure){
        this.index = index;
        this.failureRate = failure;
    }
    public double getFailureRate(){
        return failureRate;
    }
    public int getIndex(){
        return index;
    }
}
class Solution {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int N1 = 5;
        int[] stages1 = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(solution(N1, stages1)));
        int N2 = 4;
        int[] stages2 = {4,4,4,4,4};
        System.out.println(Arrays.toString(solution(N2, stages2)));
        long end = System.nanoTime();
        System.out.println((end-start)/1000000.0);
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int totalPlayer = stages.length;
        Status[] failureRate = new Status[N];

        //각 스테이지에 머물러 있는 플레이어 수를 저장할 맵
        int[] playerStage = new int[N + 2];

        //각 스테이지에 머물러 있는 플레이어 수 저장
        for(int stage : stages){
            playerStage[stage]++;
        }

        //실패율 측정
        for(int index = 1; index <= N; index++){
            double playerCount = playerStage[index];
            if(totalPlayer == 0){
                failureRate[index - 1] = new Status(index, 0);
            }else {
                failureRate[index-1] = new Status(index, playerCount / totalPlayer);
            }
            totalPlayer -= (int) playerCount;
        }

        Arrays.sort(failureRate, new Comparator<Status>() {
            @Override
            public int compare(Status o1, Status o2) {
                if(o1.getFailureRate() == o2.getFailureRate()){
                    return Integer.compare(o1.getIndex(),o2.getIndex());
                }
                return Double.compare(o2.getFailureRate(),o1.getFailureRate());
            }
        });

        for(int i = 0; i < N; i++){
            answer[i] = failureRate[i].getIndex();
        }
        return answer;
    }
}