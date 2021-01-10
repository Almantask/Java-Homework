package edu.behavioural;

public class MoveTargetCommand implements Command{
    private final Object target;
    private final Object location;
    private final Object initialLocation;

    public MoveTargetCommand(Object target, Object location) {
        this.target = target;
        // in reality, should be retrieved based on original target location.
        this.initialLocation = new Object();
        this.location = location;
    }

    @Override
    public void execute() {

        System.out.println("Moving target to location " + location);
        // complex logic }
    }

    @Override
    public void undo() {
        System.out.println("Moving target back to location " + initialLocation);
    }
}
