import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxRoomNum = 1;
        int level = 1;
        while(N > maxRoomNum){
            if(N == 1)
                break;
            maxRoomNum += 6 * level;
            level++;
        }
        System.out.println(level);
    }
}
