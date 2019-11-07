
import agh.cs.lab3.*;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationAnimalTest {
    @Test
    public void testOrientation() {
        RectangularMap map = new RectangularMap(10,5);
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] moves = {"r", "l", "left", "right", "right", "r", "r", "right"};
        MoveDirection[] parsedMoves = parser.parse(moves);
        for (MoveDirection move : parsedMoves) {
            animal.move(move);
        }
        Assert.assertEquals(animal.toString(), "N");
    }

    @Test
    public void testPosition() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        map.place(animal);

        OptionsParser parser = new OptionsParser();
        String[] moves = {"r", "l", "left", "f", "backward", "forward", "b", "b"};
        MoveDirection[] parsedMoves = parser.parse(moves);
        map.run(parsedMoves);

        Assert.assertEquals(animal.getPosition(), new Vector2d(3,2));
    }

    @Test
    public void testStayOnMap() {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] orders = {"f", "f", "forward", "f", "f", "f", "l", "b", "b", "b", "backward"};
        MoveDirection[] parsedMoves = parser.parse(orders);
        for (MoveDirection move : parsedMoves) {
            animal.move(move);
        }
        Assert.assertEquals(animal.getPosition(), new Vector2d(4,4));
    }

    @Test
    public void testParser() {
        OptionsParser parser = new OptionsParser();
        String[] orders = {"l", "right", "left", "b", "l", "left", "backward", "f", "forward"};
        MoveDirection[] parserMoves = parser.parse(orders);
        MoveDirection[] expectedResult = {MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        Assert.assertEquals(parserMoves, expectedResult);
    }

    @Test
    public void testGetPosition() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map);
        map.place(animal);

        String[] orders = {"r", "l", "f", "f", "b"};
        MoveDirection[] parsedMoves = new OptionsParser().parse(orders);
        map.run(parsedMoves);

        Assert.assertEquals(animal.getPosition(), new Vector2d(2, 3));
    }
}
