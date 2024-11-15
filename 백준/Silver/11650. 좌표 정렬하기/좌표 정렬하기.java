import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Coordinate{
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[N];
        for(int index = 0; index < N; index++){
            String[] inputs = br.readLine().split(" ");
            coordinates[index] = new Coordinate(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        Arrays.sort(coordinates, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.x == o2.x){
                    return Integer.compare(o1.y,o2.y);
                }else {
                    return Integer.compare(o1.x,o2.x);
                }
            }
        });
        for(Coordinate coordinate : coordinates){
            bw.write(coordinate.x + " " + coordinate.y);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}


