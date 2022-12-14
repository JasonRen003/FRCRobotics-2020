package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

//import edu.wpi.first.wpilibj.hal.HAL;

public class HazyController extends Joystick{
    int p;

	public HazyController(int port) {
        super(port);
        p = port;
		// TODO Auto-generated constructor stub
	}

	public JoystickButton xButton = new JoystickButton(this, 3);
	public JoystickButton yButton = new JoystickButton(this, 4);
	public JoystickButton aButton = new JoystickButton(this, 1);
	public JoystickButton bButton = new JoystickButton(this, 2);
	public JoystickButton rightBumper = new JoystickButton(this, 6);
	public JoystickButton leftBumper = new JoystickButton(this, 5);
	public JoystickButton startButton = new JoystickButton(this, 8);
	public JoystickButton selectButton = new JoystickButton(this, 7);
	public JoystickButton leftStickButton = new JoystickButton(this, 9);
    public JoystickButton rightStickButton = new JoystickButton(this, 10);
    public HazyTriggers triggers = new HazyTriggers(p);

    public JoystickButton getXButton(){
        return xButton;
    }

    public JoystickButton getYButton(){
        return yButton;
    }

    public JoystickButton getAButton(){
        return aButton;
    }

    public JoystickButton getBButton(){
        return xButton;
    }

    public JoystickButton getRightBumper(){
        return rightBumper;
    }

    public JoystickButton getLeftBumper(){
        return leftBumper;
    }

    public JoystickButton getStartButton(){
        return startButton;
    }

    public JoystickButton getSelectButton(){
        return selectButton;
    }

    public JoystickButton getLeftStickButton(){
        return leftStickButton;
    }

    public JoystickButton getRightStickButton(){
        return rightStickButton;
    }

    public HazyTriggers getHazyTriggers(){
        return triggers;
    }


}