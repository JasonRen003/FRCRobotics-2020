package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;


public class GoTo2 extends Command{

    public GoTo2()
    {
        super.requires(Robot.hazyElevatorSubsystem);
    }

    @Override
    protected void initialize()
    {
        Robot.hazyElevatorSubsystem.initialize(0.7, 0, 38.8, 0);
    }

    @Override
    protected void execute()
    {
        //System.out.println("we never press the button");
        Robot.hazyElevatorSubsystem.go(600);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void interrupted(){
        end();
    }
}