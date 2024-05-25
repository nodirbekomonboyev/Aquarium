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

}
