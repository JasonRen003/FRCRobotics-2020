package frc.robot;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;


//import edu.wpi.first.wpilibj.drive.RobotDriveBase;


public class HazyGrabber extends Subsystem
{
    
    private Victor leftGrabVic, rightGrabVic;
    private static HazyGrabber instance;
    private Compressor compressor;
    private DoubleSolenoid clawSol,liftSol;
    
    public HazyGrabber(){

        compressor = new Compressor();
        compressor.start();

        clawSol = new DoubleSolenoid(RobotMap.EXTENDSOLONOIDPORT, RobotMap.EXTENDSOLONOIDPORT2);                  // Solenoid port
        //grabRight = new DoubleSolenoid(RobotMap.EXTENDSOLONOIDPORT, RobotMap.EXTENDSOLONOIDPORT2);                 // update the ports, not originally nice like this
        liftSol = new DoubleSolenoid(RobotMap.LIFTSOLONOIDPORT,RobotMap.LIFTSOLONOIDPORT2);
        //liftRight = new DoubleSolenoid(RobotMap.LIFTSOLONOIDPORT,RobotMap.LIFTSOLONOIDPORT2);

        leftGrabVic = new Victor(RobotMap.LGRABBERVICTORPORT); //change ports after testing?
        rightGrabVic = new Victor(RobotMap.RGRABBERVICTORPORT);
    }
    
    public void initialize(){
        //all initialization code should be done in this initialize function and not the default constructor
    }
    
    public static HazyGrabber getInstance(){
        if (instance==null)
            instance = new HazyGrabber();
        return instance;
    }

    //Functions actually used by commands
    public void closeGrabber() {
        // im assuming for it to be closed it needs to be this, if it goes the opposite direction flip this and openGrabber()
        clawSol.set(DoubleSolenoid.Value.kForward);
        //grabRight.set(Value.kForward);
    }

    public void openGrabber() {
        clawSol.set(DoubleSolenoid.Value.kReverse);
        //grabRight.set(Value.kReverse);
    }

    public void liftGrabber() {
        // add code when we fix
        liftSol.set(DoubleSolenoid.Value.kReverse);
        //liftRight.set(Value.kForward);
    }

    public void lowerGrabber() {
        // add code when we fix?
        liftSol.set(DoubleSolenoid.Value.kForward);
        //liftRight.set(Value.kReverse);
    }

    public void intakeGrabber(){
        leftGrabVic.set(-1);
        rightGrabVic.set(1);
    }
    
    public void spitGrabber(){
        leftGrabVic.set(1);
        rightGrabVic.set(-1);
    }

    public void stopGrabberIntake(){
        
        rightGrabVic.set(0);
        leftGrabVic.set(0);
    }

    @Override
    public void initDefaultCommand(){
        // this is the openGrabber and "upGrabber" functions, default set to true
        setDefaultCommand(new StopIntakeCommand());
    }


}