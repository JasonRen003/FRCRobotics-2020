package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;




public class HazyElevatorSubsystem extends Subsystem
{
    
    private TalonSRX elTalon;
    private static HazyElevatorSubsystem instance;

    

    public HazyElevatorSubsystem(){

        elTalon = new TalonSRX(RobotMap.ELEVATORPORT);
        elTalon.configFactoryDefault();
        elTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        elTalon.setSensorPhase(true);
        elTalon.setSelectedSensorPosition(0);
        elTalon.configAllowableClosedloopError(0, 0, 30);
        elTalon.setInverted(true);  
        elTalon.set(ControlMode.Position, 0);


    }
    
    public void initialize(double P, double I, double D, double F){
        //all initialization code should be done in this initialize function and not the default constructor
        elTalon.config_kF(0, F, 30);
		elTalon.config_kP(0, P, 30);
		elTalon.config_kI(0, I, 30);
        elTalon.config_kD(0, D, 30);
    }
    
    public static HazyElevatorSubsystem getInstance(){
        if (instance==null)
            instance = new HazyElevatorSubsystem();
        return instance;
    }

    public void go(double pos){

        elTalon.set(ControlMode.Position, pos);

    }
    @Override
    public void initDefaultCommand(){
    }


}