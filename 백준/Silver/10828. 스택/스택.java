import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push": push(input[1], stack);
                    break;
                case "pop": pop(stack);
                    break;
                case "size": size(stack);
                    break;
                case "empty": empty(stack);
                    break;
                case "top": top(stack);
                    break;
            }
        }
    }
    public static void push(String input, ArrayList<Integer> stack){
        stack.add(Integer.parseInt(input));
    }

    public static void pop(ArrayList<Integer> stack){
        if(stack.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
    }

    public static void size(ArrayList<Integer> stack){
        System.out.println(stack.size());
    }

    public static void empty(ArrayList<Integer> stack){
        if(stack.isEmpty()){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }

    public static void top(ArrayList<Integer> stack){
        if(stack.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(stack.get(stack.size()-1));
        }
    }

}


