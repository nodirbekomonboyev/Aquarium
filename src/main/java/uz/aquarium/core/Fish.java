package uz.aquarium.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Fish implements Runnable{
    private int position;
    private int lifeTime;
    private Gender gender;
    private static Random random = new Random();
    private static FishService fishService = new FishService();

    public Fish() {
        this.lifeTime = random.nextInt(100, 500);
        this.position = random.nextInt(901);
        this.gender = random.nextInt(2) == 1 ? Gender.MALE : Gender.FEMALE;
    }

    private boolean checkTime(){
        if(lifeTime == 0) {
            fishService.killFish(this);
            return false;
        }
        lifeTime--;
        return true;
    }

    private void checkPropagation(){
        if(this.gender == Gender.FEMALE) return;
        ArrayList<Fish> list = fishService.getList(f -> f.position == this.position);
        for (Fish fish : list) {
            if(fish.gender == Gender.FEMALE){
                fishService.add(new Fish());
            }
        }
    }

    private void move(){
        int horizontal = random.nextInt(3) - 1;
        int vertical = random.nextInt(3) - 1;
        this.position = calculating(this.position, horizontal, vertical);
    }

    private static int calculating(int position, int horizontal, int vertical) {
        if((position - 1) % 30 == 0){ horizontal = 1; }
        if(position % 30 == 0){ horizontal = -1; }
        if(position < 31){ vertical = 1; }
        if(position > 870){ vertical = -1;}
        return (position + horizontal + 30 * vertical);
    }

    @Override
    public void run() {
        if(checkTime()){
            move();
            checkPropagation();
        }
    }
}
