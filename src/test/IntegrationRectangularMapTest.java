import agh.cs.lab3.*;
import org.junit.Assert;
import org.junit.Test;


public class IntegrationRectangularMapTest {
    @Test
    public void testRun1() {
        String[] orders = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(orders);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(map.toString(),
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | |N| | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | | | | | | | | | | |\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | |S| | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n");

    }
    @Test
    public void testRun2() {
        String[] orders = {"f","f"};
        MoveDirection[] directions = new OptionsParser().parse(orders);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(map.toString(),
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | |N| | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | |N| | | | | | | | |\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | | | | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n");

    }
    @Test
    public void testRun3() {
        String[] orders = {"f","f","r","l","f","f","b"};
        MoveDirection[] directions = new OptionsParser().parse(orders);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(map.toString(),
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | |W| | | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | |E| | | | | | | | |\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | | | | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n");

    }
    @Test
    public void testRun4() {
        String[] orders = {"f","f","r","l","f","f","b","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(orders);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        Assert.assertEquals(map.toString(),
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: |W| | | | | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | | | | | | | | | |E|\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | | | | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n");

    }
}