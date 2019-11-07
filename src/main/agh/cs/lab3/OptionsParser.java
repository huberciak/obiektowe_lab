package agh.cs.lab3;
import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection[] parse(String[] moves){
        ArrayList<MoveDirection> resultArray = new ArrayList<MoveDirection>();
        for(String move : moves){
            MoveDirection nextDirection;
            switch (move){
                case "f":
                case "forward":
                    nextDirection = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    nextDirection = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    nextDirection = MoveDirection.RIGHT;
                    break;
                default:
                case "l":
                case "left":
                    nextDirection = MoveDirection.LEFT;
                    break;
            }
            resultArray.add(nextDirection);
        }
        return resultArray.toArray(new MoveDirection[0]);
    }
}