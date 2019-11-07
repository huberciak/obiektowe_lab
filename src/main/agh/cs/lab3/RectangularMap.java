package agh.cs.lab3;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Vector2d leftCorner = new Vector2d(0, 0);
    private final Vector2d rightCorner;

    public RectangularMap(int width, int height) {
        rightCorner = new Vector2d(width, height);
    }

    List<Animal> animals = new ArrayList<Animal>();

    public boolean canMoveTo(Vector2d expectedPosition) {
        return !this.isOccupied(expectedPosition) && expectedPosition.follows(leftCorner) && expectedPosition.precedes(rightCorner);
    }

    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals)
            if (position.equals(animal.getPosition()))
                return animal;
        return null;
    }

    public void run(MoveDirection[] moveDirections){
        for(int i = 0; i<moveDirections.length; i++) {
                Animal run = animals.get(i % (animals.size()));
                    run.move(moveDirections[i]);
                }
            }

    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition()))
            throw new IllegalArgumentException(animal.getPosition().toString() + " is occupied.");
        this.animals.add(animal);
        return true;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(leftCorner, rightCorner);
    }
}
