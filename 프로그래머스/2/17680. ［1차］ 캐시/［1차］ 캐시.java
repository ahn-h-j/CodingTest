import java.util.ArrayList;

class Solution{ 
    public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            ArrayList<String> inCache = new ArrayList<>();
            if(cacheSize == 0){
                return cities.length * 5;
            }

            for(String city : cities){
                city = city.toUpperCase();
                inCache.add(city);
                if(inCache.subList(0,inCache.size() - 1).contains(city)){
                    inCache.remove(city);
                    answer += 1;
                } else if(inCache.size() > cacheSize){
                    inCache.remove(0);
                    answer += 5;
                }
            }
            answer += 5 * cacheSize;
            return answer;
    }
}