package frc.robot;

//import edu.wpi.first.wpilibj.command.Subsystem;
/*import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
*/
import com.ctre.phoenix.motorcontrol.ControlMode;
//mport com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * PID command to drive the left and right side of a drive train a specific
 * distance using a PIDController.
 */
public class HazyPID{
TalonSRX talon = new TalonSRX(10);
  public HazyPID(double P, double I, double D, double F)
  {
    talon.configFactoryDefault();
    talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    talon.setSensorPhase(true);
    talon.config_kF(0, F, 30);
		talon.config_kP(0, P, 30);
		talon.config_kI(0, I, 30);
    talon.config_kD(0, D, 30);
    talon.configAllowableClosedloopError(0, 0, 30);
  }
  public void doit(Double loc){
    talon.set(ControlMode.Position, loc );
  }
  
}