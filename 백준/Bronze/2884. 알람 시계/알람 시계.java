import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour;
        int min;

        hour = scanner.nextInt();
        min = scanner.nextInt();
        min -= 45;
        if(min < 0){
            min = 60 + min;
            hour--;
            if(hour < 0){
                hour = 24 + hour;
            }
        }
        System.out.println(hour + " " + min);
    }
}

