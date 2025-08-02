package uz.aquarium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.aquarium.core.Fish;
import uz.aquarium.core.FishService;

import java.util.Random;

@SpringBootApplication
public class AquariumApplication {

    public static FishService fishService = new FishService();


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AquariumApplication.class, args);

        Random random = new Random();
        for (int i = 0; i < random.nextInt(20, 40); i++) {
            fishService.add(new Fish());
        }

        while (true){
            Thread.sleep(500);
            fishService.runFishes();
            System.out.println("\r" + fishService.display());
        }
    }

}
