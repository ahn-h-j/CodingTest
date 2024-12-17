import java.util.ArrayList;
import java.util.Arrays;

class FileName {
    String name;
    String head;
    int number;
    int index;

    public FileName(String name, String head, int number, int index) {
        this.name = name;
        this.head = head;
        this.number = number;
        this.index = index;
    }

    @Override
    public String toString() {
        return name;
    }
}
class Solution {
    public String[] solution(String[] files) {
        ArrayList<FileName> fileNames = new ArrayList<>();

        processFileNames(files, fileNames);

        fileNames.sort((o1, o2) -> {
            // HEAD 비교 (대소문자 구분 없이)
            int headCompare = o1.head.compareToIgnoreCase(o2.head);
            if (headCompare != 0) return headCompare;

            // NUMBER 비교
            if (o1.number != o2.number) return Integer.compare(o1.number, o2.number);

            // 원래 순서 유지
            return Integer.compare(o1.index, o2.index);
        });

        // 결과 반환
        String[] answer = new String[files.length];
        for (int i = 0; i < fileNames.size(); i++) {
            answer[i] = fileNames.get(i).name;
        }
        return answer;
    }

    public void processFileNames(String[] files, ArrayList<FileName> fileNames) {
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            int j = 0;
            // HEAD 부분
            while (j < file.length() && !Character.isDigit(file.charAt(j))) {
                head.append(file.charAt(j));
                j++;
            }
            // NUMBER 부분
            while (j < file.length() && Character.isDigit(file.charAt(j))) {
                number.append(file.charAt(j));
                j++;
            }

            fileNames.add(new FileName(file, head.toString(), Integer.parseInt(number.toString()), i));
        }
    }
}
