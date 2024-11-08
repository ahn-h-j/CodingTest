import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour, minute, time;
        int addHour, addMinute;
        hour = scanner.nextInt();
        minute = scanner.nextInt();
        time = scanner.nextInt();

        addHour = time / 60;
        addMinute = time % 60;
        minute += addMinute;
        if(minute >= 60){
            hour++;
            minute -= 60;
        }
        hour += addHour;
        if(hour >= 24){
            hour -= 24;
        }

        System.out.println(hour + " " + minute);
    }
}