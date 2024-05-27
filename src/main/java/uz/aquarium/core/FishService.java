package uz.aquarium.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

}
