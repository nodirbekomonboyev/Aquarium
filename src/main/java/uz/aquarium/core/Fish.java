package uz.aquarium.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Fish {
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

    private static int calculating(int position, int horizontal, int vertical) {
        if((position - 1) % 30 == 0){ horizontal = 1; }
        if(position % 30 == 0){ horizontal = -1; }
        if(position < 31){ vertical = 1; }
        if(position > 870){ vertical = -1;}
        return (position + horizontal + 30 * vertical);
    }
}
