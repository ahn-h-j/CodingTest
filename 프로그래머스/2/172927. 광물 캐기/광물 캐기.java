import java.util.*;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int mineralChunks = (int)Math.ceil(minerals.length / 5.0);

        Integer[] fatigue = new Integer[mineralChunks];
        Arrays.fill(fatigue, 0);
        Map<Integer, String> chunkNum = new HashMap<>();

        addWeight(minerals, chunkNum, fatigue, totalPicks);

        Arrays.sort(fatigue, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        answer = selectPickaxe(mineralChunks, chunkNum, picks, fatigue);

        return answer;
    }

    public static void addWeight(String[] minerals, Map<Integer, String> chunkNum, Integer[] fatigue, int totalPicks) {
        int processChunks = 0;
        int fatigueSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < minerals.length; index++) {
            String mineral = minerals[index] + ",";
            sb.append(mineral);
            if (mineral.equals("diamond,")) {
                fatigueSum += 25;
            } else if (mineral.equals("iron,")) {
                fatigueSum += 5;
            } else {
                fatigueSum += 1;
            }
            if (index % 5 == 4 || index + 1 == minerals.length) {
                sb.deleteCharAt(sb.length() - 1);
                int uniqueKey = fatigueSum * 1000 + index / 5;
                chunkNum.put(uniqueKey, sb.toString());
                if (processChunks < totalPicks) {
                    fatigue[processChunks] = uniqueKey;
                    processChunks++;
                }
                sb.setLength(0);
                fatigueSum = 0;
            }
        }
    }

    public static int selectPickaxe(int mineralChunks, Map<Integer, String> chunkNum, int[] picks, Integer[] fatigue) {
        int sum = 0;
        for (int index = 0; index < mineralChunks; index++) {
            if (fatigue[index] == null || !chunkNum.containsKey(fatigue[index])) {
                continue;
            }
            String[] inputs = chunkNum.get(fatigue[index]).split(",");
            if (picks[0] > 0) {
                picks[0]--;
                sum += addDiaFatigue(inputs);
            } else if (picks[1] > 0) {
                picks[1]--;
                sum += addIronFatigue(inputs);
            } else if (picks[2] > 0) {
                picks[2]--;
                sum += addStoneFatigue(inputs);
            }
        }
        return sum;
    }

    public static int addDiaFatigue(String[] inputs) {
        return inputs.length;
    }

    public static int addIronFatigue(String[] inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("diamond")) {
                sum += 5;
            } else if (inputs[i].equals("iron")) {
                sum += 1;
            } else {
                sum += 1;
            }
        }
        return sum;
    }

    public static int addStoneFatigue(String[] inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("diamond")) {
                sum += 25;
            } else if (inputs[i].equals("iron")) {
                sum += 5;
            } else {
                sum += 1;
            }
        }
        return sum;
    }
}
