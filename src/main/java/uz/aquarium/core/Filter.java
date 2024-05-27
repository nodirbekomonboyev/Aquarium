package uz.aquarium.core;

@FunctionalInterface
public interface Filter {
    boolean check(Fish fish);
}
