package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;


public class GrabberOpenCommand extends Command{

    public GrabberOpenCommand()
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
        Robot.HazyGrabber.openGrabber();
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