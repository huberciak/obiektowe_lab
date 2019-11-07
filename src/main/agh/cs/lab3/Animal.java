package agh.cs.lab3;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }


    public Vector2d getPosition(){
        return position;
    }

    public String toString(){
        switch(direction){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
        }
        return "E";
    }
    /*
    private static final Vector2d leftCornerGuard = new Vector2d(0,0);
    private static final Vector2d rightCornerGuard = new Vector2d(4,4);
    private boolean onMapTest(Vector2d x){
        return x.follows(leftCornerGuard) && x.precedes(rightCornerGuard);
    }
    */
    public void move(MoveDirection moveDirection){
        switch(moveDirection){
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
            case BACKWARD:
                MapDirection thisMoveDirection = this.direction;

                if(moveDirection == MoveDirection.BACKWARD)
                    thisMoveDirection = thisMoveDirection.next().next();

                Vector2d expectedMove = this.position.add(thisMoveDirection.toUnitVector());
                    if(this.map.canMoveTo(expectedMove))
                    this.position = expectedMove;
                break;
            default:
                break;
        }
    }
}