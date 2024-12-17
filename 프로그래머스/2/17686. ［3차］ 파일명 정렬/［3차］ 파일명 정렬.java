import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class FileName {
    String Name;
    String head;
    int number;
    int index;

    public FileName(String name, String head, int number, int index) {
        Name = name;
        this.head = head;
        this.number = number;
        this.index = index;
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<FileName> fileNames = new ArrayList<>();

        processFileName(files, fileNames);
        sortFileName(fileNames);

        for (int index = 0; index < fileNames.size(); index++) {
            answer[index] = fileNames.get(index).Name;
        }
        return answer;
    }

    public void processFileName(String[] files, ArrayList<FileName> fileNames) {
        int fileIndex = 0;
        for (String file : files) {
            char[] fileChar = file.toCharArray();

            StringBuilder head = new StringBuilder();
            int num = 0;
            boolean isNumberStarted = false;

            for (int index = 0; index < fileChar.length; index++) {
                if (!isNumberStarted && !Character.isDigit(fileChar[index])) {
                    head.append(fileChar[index]);
                } else if (Character.isDigit(fileChar[index])) {
                    isNumberStarted = true;
                    num = num * 10 + (fileChar[index] - '0');
                } else {
                    break;
                }
            }
            fileNames.add(new FileName(file, head.toString(), num, fileIndex++));
        }
    }


    public void sortFileName(ArrayList<FileName> fileNames) {
        fileNames.sort(new Comparator<FileName>() {
            @Override
            public int compare(FileName o1, FileName o2) {
                if (o1.head.equalsIgnoreCase(o2.head)) { // HEAD가 같은 경우
                    if (o1.number == o2.number) { // HEAD와 NUMBER가 같은 경우
                        return Integer.compare(o1.index, o2.index); // 원래 순서 비교
                    }
                    return Integer.compare(o1.number, o2.number); // NUMBER 순 비교
                } else {
                    return o1.head.compareToIgnoreCase(o2.head); // HEAD를 대소문자 구분 없이 비교
                }
            }
        });
    }
}
