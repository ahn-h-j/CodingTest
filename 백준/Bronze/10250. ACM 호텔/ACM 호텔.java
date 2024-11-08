import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H, W, N;
        int floor,roomID ,roomNum;
        int numberOfTest;
        numberOfTest = scanner.nextInt();
        for(int i = 0; i < numberOfTest; i++){
            H = scanner.nextInt();
            W = scanner.nextInt();
            N = scanner.nextInt();
            floor = N % H;
            roomID = N / H + 1;
            if(N < H){
                floor = N;
            }
            else if(floor == 0){
                floor = H;
                roomID -= 1;
            }
            roomNum = floor * 100 + roomID;
            System.out.println(roomNum);
        }
    }
}