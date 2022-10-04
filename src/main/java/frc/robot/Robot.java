/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.OI;
// import edu.wpi.first.hal.HAL;
// import edu.wpi.first.wpilibj.livewindow.LiveWindow;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;


public class Robot extends TimedRobot {

  //Declaration of all our Subsystem and Default Command Objects 
  public static HazyMecBase HazyMecBase; 
  public static MecanumCommand mecanumCommand;

  public static HazyElevatorSubsystem hazyElevatorSubsystem;
  


  public static HazyGrabber HazyGrabber;
  public static DefaultGrabberCommandGroup defaultGrabberCommandGroup;


  //public HazyPID haze;
  //double oof = 0.0;
  
  
  
  @Override
  public void robotInit() {

    //Initialize all Subsystem and Command objects
    HazyMecBase = new HazyMecBase();
    mecanumCommand = new MecanumCommand();

    hazyElevatorSubsystem = new HazyElevatorSubsystem();


    HazyGrabber = new HazyGrabber();
    defaultGrabberCommandGroup = new DefaultGrabberCommandGroup();

    

    //Add default commands to Scheduler
    Scheduler.getInstance().add(mecanumCommand);
    //Scheduler.getInstance().add(defaultGrabberCommandGroup);

    //haze = new HazyPID(0.2, 0, 0, 0);
  
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    
    //Run all tele-op command through Scheduler and OI button maps
    Scheduler.getInstance().run();
    OI hazyOI = new OI();
    
    //System.out.println(oof);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
