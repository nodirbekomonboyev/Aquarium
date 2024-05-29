package uz.aquarium.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static uz.aquarium.core.Gender.MALE;

public class FishService {
    public static List<Fish> list = new CopyOnWriteArrayList<>();


    public boolean add(Fish fish){
        return list.add(fish);
    }

    public void killFish(Fish fish){
        list.remove(fish);
    }

    public ArrayList<Fish> getList(Filter filter){
        ArrayList<Fish> newList = new ArrayList<>();
        for (Fish fish : list) {
            if(filter.check(fish)){
                newList.add(fish);
            }
        }
        return newList;
    }

    private Map<Integer, Integer> getMap() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Fish> fishes = list.stream().toList();
        for (Fish fish : fishes) {
            if (!map.containsKey(fish.getPosition())) {
                map.put(fish.getPosition(), (fish.getGender() == Gender.MALE) ? 1 : 0);
            } else if (map.get(fish.getPosition()) == 0 && fish.getGender() == MALE) {
                map.put(fish.getPosition(), 1);
            }
        }
        return map;
    }

    public String display(){
        Map<Integer, Integer> map = getMap();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 900; i++) {
            if((i - 1) % 30 == 0){
                result.append(" |");
            }
            if(map.containsKey(i)){
                result.append(" ").append(map.get(i)).append(" ");
            }else {
                result.append("   ");
            }
            if(i % 30 == 0){
                result.append("| \n");
            }
        }
        return result.toString();
    }

}
