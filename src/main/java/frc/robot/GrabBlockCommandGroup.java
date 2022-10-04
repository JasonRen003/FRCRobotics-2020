package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class GrabBlockCommandGroup extends CommandGroup{
    
    public GrabBlockCommandGroup(){
        addParallel(new LowerGrabberCommand());
        addParallel(new GrabberCloseCommand());
        //System.out.println("Now Ready For Intaking!!");
    }

    

}