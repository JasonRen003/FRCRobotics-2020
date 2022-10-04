package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

public class HazyTriggers extends XboxController{
    Joystick joystick;

    public HazyTriggers(int p){
        super(p);
    }

    public boolean getLeftAxis(){
        return this.getTriggerAxis(Hand.kLeft) > .1;
    }

    public boolean getRightAxis(){
        return this.getTriggerAxis(Hand.kRight) > .1;
    }

}