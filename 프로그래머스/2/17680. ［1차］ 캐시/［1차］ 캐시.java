import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> inCache = new ArrayList<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }

        for(String city : cities){
            city = city.toUpperCase();
            if(inCache.contains(city)){
                inCache.remove(city);
                inCache.add(city);
                answer += 1;
            } else {
                if(inCache.size() >= cacheSize){
                    inCache.remove(0);
                }
                inCache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}
