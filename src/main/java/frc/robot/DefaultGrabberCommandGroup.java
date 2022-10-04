package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class DefaultGrabberCommandGroup extends CommandGroup{
    
    public DefaultGrabberCommandGroup(){
        addParallel(new LiftGrabberCommand());
        addParallel(new GrabberOpenCommand());
        //System.out.println("Now in Default State!!");
    }

    

}