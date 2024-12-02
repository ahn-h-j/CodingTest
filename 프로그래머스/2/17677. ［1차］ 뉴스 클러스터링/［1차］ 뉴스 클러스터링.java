import java.util.*;

class Solution {
    public static int solution(String str1, String str2) {
        int answer;
        ArrayList<String> str1Set = new ArrayList<>();
        ArrayList<String> str2Set = new ArrayList<>();

        makeSet(str1Set, str1);
        makeSet(str2Set, str2);

        Map<String, Integer> dupCountStr1 = new HashMap<>();
        Map<String, Integer> dupCountStr2 = new HashMap<>();
        Set<String> dupString = findDuplicate(str1Set, str2Set, dupCountStr1, dupCountStr2);

        int UnionSize = findNonDuplicate(dupString, str1Set, str2Set);

        return findAnswer(UnionSize, dupString, dupCountStr1, dupCountStr2);
    }

    public static void makeSet(ArrayList<String> set, String str) {
        for (int index = 0; index < str.length() - 1; index++) {
            char prefix = str.charAt(index);
            char suffix = str.charAt(index + 1);
            if (Character.isAlphabetic(prefix) && Character.isAlphabetic(suffix)) {
                set.add("" + Character.toUpperCase(prefix) + Character.toUpperCase(suffix));
            }
        }
    }

    public static Set<String> findDuplicate(ArrayList<String> str1Set, ArrayList<String> str2Set, Map<String, Integer> dupCountStr1, Map<String, Integer> dupCountStr2) {
        Set<String> dupString = new HashSet<>();
        for (String str : str1Set) {
            if (str2Set.contains(str)) {
                dupCountStr1.put(str, dupCountStr1.getOrDefault(str, 0) + 1);
                dupString.add(str);
            }
        }
        for (String str : str2Set) {
            if (str1Set.contains(str)) {
                dupCountStr2.put(str, dupCountStr2.getOrDefault(str, 0) + 1);
            }
        }
        return dupString;
    }

    public static int findNonDuplicate(Set<String> dupString, ArrayList<String> str1Set, ArrayList<String> str2Set) {
        ArrayList<String> nonDupString = new ArrayList<>();
        for (String str : str1Set) {
            if (!(dupString.contains(str))) {
                nonDupString.add(str);
            }
        }
        for (String str : str2Set) {
            if (!(dupString.contains(str))) {
                nonDupString.add(str);
            }
        }
        return nonDupString.size();
    }

    public static int findAnswer(int UnionSize, Set<String> dupString, Map<String, Integer> dupCountStr1, Map<String, Integer> dupCountStr2) {
        int de = UnionSize;
        int nu = 0;
        for (String str : dupString) {
            nu += Math.min(dupCountStr1.get(str), dupCountStr2.get(str));
            de += Math.max(dupCountStr1.get(str), dupCountStr2.get(str));
        }
        if (nu == 0 && de == 0) {
            return 65536;
        } else {
            return (int) (((double) nu / de) * 65536);
        }
    }
}
