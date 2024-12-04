import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class User{
    private int index;
    private int age;
    private String name;

    public User(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        User[] list = new User[N];
        for(int index = 0; index < N; index++){
            String[] input = br.readLine().split(" ");
            User user = new User(index,Integer.parseInt(input[0]), input[1]);
            list[index] = user;
        }
        Arrays.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.getAge()==o2.getAge()){
                    return Integer.compare(o1.getIndex(),o2.getIndex());
                }
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        for(int index = 0; index < N; index++){
            System.out.println(list[index].getAge() + " " + list[index].getName());
        }
    }
}