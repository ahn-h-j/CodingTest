import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int numberOfProblem = 0; numberOfProblem < t; numberOfProblem++) {
            String ps = br.readLine();
            boolean judge = findVPS(ps);
            if(judge) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
    public static boolean findVPS(String ps) {
        Stack<String> stack = new Stack<>();

        for(int index = 0; index < ps.length(); index++) {
            String inputParenthesis = ps.charAt(index) + "";

            if(inputParenthesis.equals("(")) { //( 입력시
                stack.push(inputParenthesis);
            } else { // ) 입력시
                if(stack.isEmpty()) {//)를 입력받았는데 stack이 빈 경우
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        //empty : true / non_empty : "(" 존재 ,false
        return stack.isEmpty();
    }
}


