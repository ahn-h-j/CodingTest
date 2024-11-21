import java.util.*;

class Alert {
    private String name;
    private int count;

    public Alert(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, List<String>> reportHistory = new HashMap<>();
        ArrayList<Alert> alertCount = new ArrayList<>();

        for (int index = 0; index < id_list.length; index++) {
            // 신고 처리 맵
            // key : 신고자, value : 신고자가 신고한 사람들
            reportHistory.put(id_list[index], new ArrayList<String>());
            // 신고 횟수 배열
            // Alert : 신고자, 신고받은 횟수
            alertCount.add(new Alert(id_list[index], 0));
        }

        // 신고 내역 처리
        for (int index = 0; index < report.length; index++) {
            String[] input = report[index].split(" ");
            String reporter = input[0];
            String reportedUser = input[1];

            boolean sameReport = false;
            // 같은 신고 내역이 있는지 확인
            for (String alert : reportHistory.get(reporter)) {
                // 있는 경우
                if (alert.equals(reportedUser)) {
                    sameReport = true;
                    break;
                }
            }
            // 없는 경우 : 추가
            if (!sameReport) {
                reportHistory.get(reporter).add(reportedUser);

                for (Alert alert : alertCount) {
                    if (alert.getName().equals(reportedUser)) {
                        alert.setCount(alert.getCount() + 1);
                        break;
                    }
                }
            }
        }

        // 정지 유저 탐색
        ArrayList<String> banUser = new ArrayList<>();
        for (Alert alert : alertCount) {
            if (alert.getCount() >= k) {
                banUser.add(alert.getName());
            }
        }

        for (int index = 0; index < id_list.length; index++) {
            int mailCount = 0;
            for (String reportedUser : reportHistory.get(id_list[index])) {
                if (banUser.contains(reportedUser)) {
                    mailCount++;
                }
            }
            answer[index] = mailCount;
        }

        return answer;
    }
}
