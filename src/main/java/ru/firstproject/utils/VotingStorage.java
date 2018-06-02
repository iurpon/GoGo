package ru.firstproject.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class VotingStorage {
    public static final LocalTime timeLimit = LocalTime.of(12,00);
//    private static final LocalTime localTimeNow = LocalTime.of(11,00);
    private VotingStorage() {
    }

    public static final Map<LocalDate,Map<Integer,String>> voteHistory = new ConcurrentHashMap<>();

    public static String addVote(int userId,String restaurantName){

        Objects.requireNonNull(userId);
        Objects.requireNonNull(restaurantName);
        LocalDate now = LocalDate.now();
        String voted = "thanks for voting";
        Map<Integer,String> todayResults =  voteHistory.get(now);
        if(todayResults == null){
            todayResults = new HashMap<>();
            todayResults.put(userId,restaurantName);
            voteHistory.put(now,todayResults);
//            return voted;
        }
        todayResults.values().stream().forEach(System.out::println);
        if(todayResults.get(userId) == null){
            todayResults.put(userId,restaurantName);
        }else{
            LocalTime nowTime = LocalTime.now();
            if(nowTime.isBefore(timeLimit)){
                todayResults.put(userId,restaurantName);
            }
            else{
                voted = "Sorry. time's up";
            }

        }
        String countVotes = countingVotes(todayResults);
        return voted + countVotes;
    }

    private static String countingVotes(Map<Integer, String> todayResults) {
        StringBuilder sb = new StringBuilder(" Restaurant : " );
        Map<String,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,String> entry : todayResults.entrySet()){
            if(!map.containsKey(entry.getValue())){
                map.put(entry.getValue(),1);
            }else{
                map.put(entry.getValue(),map.get(entry.getValue()) + 1);
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(  entry.getKey() + " was voted " + entry.getValue() + System.lineSeparator());
        }
        return sb.toString();
    }

    public static String getVote(int userId){
        Objects.requireNonNull(userId);
        Map<Integer,String> map = voteHistory.get(LocalDate.now());
//        Objects.requireNonNull(map);
        if(map == null) return null;
        String restaurant = map.get(userId);
        return restaurant;
    }
}
