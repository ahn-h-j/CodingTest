import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Coordinates{
    int x;
    int y;
    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinates[] coordinates = new Coordinates[n];

        //좌표 입력
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            coordinates[i] = new Coordinates(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        //좌표 정렬
        coordinateSorting(n, coordinates);

        printCoordinates(coordinates);
    }

    static void coordinateSorting(int n, Coordinates[] coordinates) {
        Arrays.sort(coordinates, new Comparator<Coordinates>() {
            @Override
            public int compare(Coordinates coordinates1, Coordinates coordinates2) {
                if(coordinates1.y == coordinates2.y){
                    return Integer.compare(coordinates1.x, coordinates2.x);
                }
                return Integer.compare(coordinates1.y, coordinates2.y);
            }
        });
    }
    
    static void printCoordinates(Coordinates[] coordinates){
        for (Coordinates coordinate : coordinates) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
}

