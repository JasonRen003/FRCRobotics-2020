package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;


public class GrabberSpitCommand extends Command{

    public GrabberSpitCommand()
    {
        super.requires(Robot.HazyGrabber);
    }

    @Override
    protected void initialize()
    {
        Robot.HazyGrabber.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.HazyGrabber.spitGrabber();
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