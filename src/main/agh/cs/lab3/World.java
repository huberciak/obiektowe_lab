package agh.cs.lab3;

public class World {
    public static void main(String[] args) {
        /*
        Vector2d p1 = new Vector2d(1,2);
        System.out.println(p1);
        Vector2d p2 = new Vector2d(3,4);
        System.out.println(p2);
        System.out.println(p1.add(p2));

        MapDirection direction = MapDirection.SOUTH;
        System.out.println(direction.toString());
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

       Animal zwierze = new Animal();
       System.out.println(zwierze);
//        zwierze.move(MoveDirection.RIGHT);
//        zwierze.move(MoveDirection.FORWARD);
//        zwierze.move(MoveDirection.FORWARD);
//        zwierze.move(MoveDirection.FORWARD);
//        zwierze.move(MoveDirection.BACKWARD);
        OptionsParser parser = new OptionsParser();
        String[] orders = {"r","f","f","f","b"};
        MoveDirection[] parsedMoves = parser.parse(orders);
        for(MoveDirection move : parsedMoves){
            zwierze.move(move);
        }

        */
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}