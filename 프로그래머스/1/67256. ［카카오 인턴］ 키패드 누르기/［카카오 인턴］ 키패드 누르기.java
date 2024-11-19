class Coordinate{
    private int x;
    private int y;
    Coordinate(int[] coordinate){
        this(coordinate[0],coordinate[1]);
    }
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class Solution{
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        String answer = solution(numbers,hand);
        System.out.println(answer);
    }
    /*
    * | 1 2 3 | 3
    * | 4 5 6 | 2
    * | 7 8 9 | 1
    * | * 0 # | 0
    * */

    public static String solution(int[] numbers, String hand){
        StringBuilder sb = new StringBuilder();
        int[][] keyPad = {
                {0,1},
                {3,0}, {3,1}, {3,2},
                {2,0}, {2,1}, {2,2},
                {1,0}, {1,1}, {1,2}
        };
        Coordinate leftPosition = new Coordinate(0,0);
        Coordinate rightPosition = new Coordinate(0,2);

        for(int index = 0; index < numbers.length; index++){

            int click = numbers[index];
            Coordinate position = new Coordinate(keyPad[numbers[index]]);
            if(click == 1 || click == 4 || click == 7){
                //1 = 1, 4 = 2, 7 = 3
                leftPosition = position;
                sb.append("L");
            } else if (click == 3 || click == 6 || click == 9) {
                //3 = 1, 6 = 2, 9 = 3
                rightPosition = position;
                sb.append("R");
            } else {//2 5 8 0
                int left = distance(leftPosition,position);
                int right = distance(rightPosition,position);
                //크기 비교 작은게 선택
                if(right < left) {
                    rightPosition = position;
                    sb.append("R");
                } else if(right > left) {
                    leftPosition = position;
                    sb.append("L");
                }else {
                    if(hand.equalsIgnoreCase("right")) {
                        rightPosition = position;
                        sb.append("R");
                    }else {
                        leftPosition = position;
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();
    }
    public static int distance(Coordinate currentPosition, Coordinate keyPadPosition){
       return Math.abs(currentPosition.getX() - keyPadPosition.getX())
               + Math.abs(currentPosition.getY() - keyPadPosition.getY());
    }
}