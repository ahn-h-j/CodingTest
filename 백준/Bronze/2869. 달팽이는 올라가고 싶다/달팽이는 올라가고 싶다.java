import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
    내 코드 : 시간 오버 / 해결 실패
    문제점 : 수학적 지식 부족
        int snail = 0;
        int dayCount = 0;
        //값 입력
        String[] input = br.readLine().split(" ");
        //올라가는 m
        int A = Integer.parseInt(input[0]);
        //내려가는 m
        int B = Integer.parseInt(input[1]);
        //목표 m
        int V = Integer.parseInt(input[2]);
        while(true){
            dayCount++;
            snail = Math.addExact(snail, A);
            //낮 중에 목표치까지 올라가면 종료
            if(snail >= V) {
                break;
            }
            snail = Math.subtractExact(snail, B);
        }
        System.out.println(dayCount);
 */

        //값 입력
        String[] input = br.readLine().split(" ");
        //올라가는 m
        int A = Integer.parseInt(input[0]);
        //내려가는 m
        int B = Integer.parseInt(input[1]);
        //목표 m
        int V = Integer.parseInt(input[2]);

        // 마지막 날은 미끄러지지 않으므로 (V - A)를 (A - B)로 나누고 하루를 추가
        int days = (V - A) / (A - B);
        if ((V - A) % (A - B) != 0) {
            days += 1;
        }
        // 마지막 날 포함
        days += 1;

        // 결과 출력
        System.out.println(days);
    }
}


