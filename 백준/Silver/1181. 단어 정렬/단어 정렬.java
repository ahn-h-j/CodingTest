import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> wordInput = new HashSet<>();

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            wordInput.add(scanner.nextLine());
        }
        List<String> sortList = new ArrayList<>(wordInput);

        Collections.sort(sortList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for (int i = 0; i < o1.length(); i++) {
                        char o1Char = o1.charAt(i);
                        char o2Char = o2.charAt(i);
                        if(o1Char - o2Char == 0){
                            continue;
                        }
                        return o1Char - o2Char;
                    }
                }
                return o1.length() - o2.length();
            }
        });
        for (String word : sortList) {
            System.out.println(word);
        }
    }
}
