package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpiutil.math.MathUtil;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class HazyMecBase extends Subsystem
{
    
    private TalonSRX rightFrontTalon;
    private TalonSRX leftFrontTalon;
    private TalonSRX rightBackTalon;
    private TalonSRX leftBackTalon;
    private MecanumDrive mecDrive;
    public static HazyMecBase instance;
    public static boolean initialized = false;
    private CheesyDriveHelper cheesyDriveHelper = new CheesyDriveHelper();

    public HazyMecBase(){   
    }

    public void initialize(){
      //all initialization code should be done in this initialize function and not the default constructor
      if(!initialized){
        rightFrontTalon = new TalonSRX(RobotMap.RIGHTFRONTTALONPORT);
        leftFrontTalon = new TalonSRX(RobotMap.LEFTFRONTTALONPORT);
        rightBackTalon = new TalonSRX(RobotMap.RIGHTBACKTALONPORT);
        leftBackTalon = new TalonSRX(RobotMap.LEFTBACKTALONPORT);      
        //mecDrive = new MecanumDrive(leftFrontTalon,leftBackTalon,rightFrontTalon,rightBackTalon);
      }
    }

    public static HazyMecBase getInstance(){
      if (instance==null)
          instance = new HazyMecBase();
      return instance;
    }
    
    protected void normalize(double[] wheelSpeeds) {
      double maxMagnitude = Math.abs(wheelSpeeds[0]);

      for (int i = 1; i < wheelSpeeds.length; i++) {
        double temp = Math.abs(wheelSpeeds[i]);
        if (maxMagnitude < temp) {
          maxMagnitude = temp;
        }
      }

      if (maxMagnitude > 1.0) {
        for (int i = 0; i < wheelSpeeds.length; i++) {
        wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
        }
      }
    }

    private double applyDeadband(double value, double deadband) {
      if (Math.abs(value) > deadband) {
        if (value > 0.0) 
          return (value - deadband) / (1.0 - deadband);
        
        else 
          return (value + deadband) / (1.0 - deadband);  
      } 

      else 
        return 0.0;
    }

    public void driveCartesian(double x, double y, double angle){
      
      cheesyDriveHelper.cheesyDrive(OI.getLeftY(), -OI.getRightX(), OI.leftJoystick.getTrigger(), 1);
      rightFrontTalon.set(ControlMode.PercentOutput,-cheesyDriveHelper.getRightPWM());
      //rightVictorMotor.set(-cheesyDriveHelper.getRightPWM());
      rightBackTalon.set(ControlMode.PercentOutput,-cheesyDriveHelper.getRightPWM());
      leftFrontTalon.set(ControlMode.PercentOutput,cheesyDriveHelper.getLeftPWM());
      leftBackTalon.set(ControlMode.PercentOutput,cheesyDriveHelper.getLeftPWM());
      //leftVictorMotor2.set(cheesyDriveHelper.getLeftPWM());
      // y = MathUtil.clamp(y, -1.0, 1.0);
      // y = applyDeadband(y, RobotMap.DEADBAND);

      // x = MathUtil.clamp(x, -1.0, 1.0);
      // x = applyDeadband(x, RobotMap.DEADBAND);


      //   double[] wheelSpeeds = new double[4];
      //   wheelSpeeds[0] = x + y + angle;
      //   wheelSpeeds[1] = -x + y - angle;
      //   wheelSpeeds[2] = -x + y + angle;
      //   wheelSpeeds[3] = x + y - angle;
    
      //   normalize(wheelSpeeds);
        
      //   leftFrontTalon.set(wheelSpeeds[0] );
      //   rightFrontTalon.set(wheelSpeeds[1] * -1);
      //   leftBackTalon.set(wheelSpeeds[2]);
      //   rightBackTalon.set(wheelSpeeds[3]*-1);
    }

    // public void followPath(HazyPath path)
    // {
    //   for(int i = 0; i < path.getPath().size(); i++){
    //     //put if statements to move robot based on whether or not current positions (use default methods to get encoder readings), are more or less than the trajectory positions
    //     double currVel = 
    //   }

    // }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(new MecanumCommand());
    }


}