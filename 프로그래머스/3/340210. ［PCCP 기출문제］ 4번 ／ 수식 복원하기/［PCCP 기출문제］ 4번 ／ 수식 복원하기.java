import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExpressionToken {
    String operand1;
    char operator;
    String operand2;
    String result;
    boolean isX;

    public ExpressionToken(String operand1, char operator, String operand2, boolean isX, String result) {
        this(operand1, operator, operand2, isX);
        this.result = result;
    }

    public ExpressionToken(String operand1, char operator, String operand2, boolean isX) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
        this.isX = isX;
    }

    public String BaseString(String result) {
        return operand1 + " " + operator + " " + operand2 + " = " + result;
    }
}

class Solution {
    public String[] solution(String[] expressions) {
        List<String> answerList = new ArrayList<>();
        ArrayList<ExpressionToken> questions = new ArrayList<>();
        // 최소 진수 체크
        int minBase = findMinBaseAndQuestion(expressions, questions);
        // 진수 찾기
        int Base = findBase(questions, minBase);
        //진수 계산
        calculateBase(questions, Base, minBase, answerList);

        return answerList.toArray(new String[0]);
    }

    private int findMinBaseAndQuestion(String[] expressions, ArrayList<ExpressionToken> questions) {
        int minBase = 0;
        for (String expression : expressions) {
            String[] target = expression.split(" ");
            String operand1 = target[0];
            String operand2 = target[2];
            char operator = target[1].charAt(0);
            String result = target[4];

            // question 리스트 생성
            if (target[4].equals("X")) {
                questions.add(new ExpressionToken(operand1, operator, operand2, true));
            } else {
                questions.add(new ExpressionToken(operand1, operator, operand2, false, result));
            }

            // 최소 진수 찾기
            for (int index = 0; index < expression.length(); index++) {
                char charExp = expression.charAt(index);
                if (Character.isDigit(charExp) && minBase < charExp - '0') {
                    minBase = charExp - '0';
                }
            }
        }
        return minBase + 1;
    }

    private int findBase(ArrayList<ExpressionToken> questions, int minBase) {
        int Base = 0;
        for (ExpressionToken question : questions) {
            if(question.isX){
                continue;
            }
            if (minBase == 9) {
                return 9;
            }
            // 결과가 X가 아니라면 minBase ~ 9진수 까지 계산 결과를 비교
            for (int index = minBase; index < 10; index++) {
                String baseIndexSum = calculate(index,question);

                String decimalSum = calculate(10,question);

                if (baseIndexSum.equals(question.result) && !decimalSum.equals(question.result)) {
                    Base = index;
                    break;
                }
            }
        }
        return Base;
    }

    public void calculateBase(ArrayList<ExpressionToken> questions, int Base, int minBase, List<String> answerList) {
        for (ExpressionToken question : questions) {
            String result;
            if (question.isX) {
                if (Base == 0) { // Base를 찾지 못한 경우
                    String base10Sum = calculate(10,question);
                    String minBaseSum = calculate(minBase,question);
                    if (base10Sum.equals(minBaseSum)) {
                        result = base10Sum; // 결과값 갱신
                    } else {
                        // 추가적으로 여러 진법에서 결과가 일치하는지 확인
                        result = consistentCheck(minBase,question);
                    }
                }
                else {
                    result = calculate(Base, question);
                }
                answerList.add(question.BaseString(result));
            }
        }
    }

    public String calculate(int base, ExpressionToken question){
        if (question.operator == '+') {
            int base10Sum = Integer.parseInt(question.operand1, base) + Integer.parseInt(question.operand2, base);
            return Integer.toString(base10Sum, base);
        } else {
            int base10Sum = Integer.parseInt(question.operand1, base) - Integer.parseInt(question.operand2, base);
            return Integer.toString(base10Sum, base);
        }
    }

    public String consistentCheck(int minBase, ExpressionToken question){
        String consistentResult = "";
        boolean isConsistent = true;

        for (int index = minBase; index < 10; index++) {
            String currentResult = calculate(index, question);
            if (index == minBase) {
                consistentResult = currentResult;
            } else if (!consistentResult.equals(currentResult)) {
                isConsistent = false;
                break;
            }
        }
        if (isConsistent) {
            return consistentResult;
        }
        return "?";
    }
}

