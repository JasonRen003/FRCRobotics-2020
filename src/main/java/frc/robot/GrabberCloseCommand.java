package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;


public class GrabberCloseCommand extends Command{

    public GrabberCloseCommand()
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
        Robot.HazyGrabber.closeGrabber();
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