package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.commands.MoveForwardAlignToGearForLeftTarget;
import org.usfirst.frc.team2960.robot.commands.MoveForwardAlignToGearForRightTarget;
import org.usfirst.frc.team2960.robot.commands.MoveForwardAndPlaceGear;
import org.usfirst.frc.team2960.robot.commands.MoveForwardLeftGearThenGoDownField;
import org.usfirst.frc.team2960.robot.commands.MoveForwardRightGearThenGoDownField;
import org.usfirst.frc.team2960.robot.commands.MoveForwardToCrossLine;
import org.usfirst.frc.team2960.robot.commands.MoveForwardWithAlignAndPlaceGear;
import org.usfirst.frc.team2960.robot.commands.TestAuton;
import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.Camera;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Lights;
//import org.usfirst.frc.team2960.robot.subsystems.Lights;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;
import org.usfirst.frc.team2960.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {public int autonIndex = 

/********************************************************************************************
 * ____ _  _ ___ ____ _  _    _  _ ____ ___  ____    ____ ____ _    ____ ____ ___ ____ ____	*  	 
 * |__| |  |  |  |  | |\ |    |\/| |  | |  \ |___   |___  |___ |    |___ |     |  |  | |__/ *   		 
 * |  | |__|  |  |__| | \|    |  | |__| |__/ |___   ____| |___ |___ |___ |___  |  |__| |  \ * 
 * 																							*
 * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*
 * 																							*
 * CHOOSE A NUMBER FROM THE LIST BELOW CORRESPONDING TO THE AUTONOMOUS MODE YOU WANT TO RUN.*
 * 																							*
 * AUTONOMOUS MODES LIST																	*
 * -=-=-=-=-=-=-=-=-=-=-=-=-																*
 * 0 = Center Gear With NO Camera Align														*
 * 1 = Center Gear With Camera Align														*
 * 2 = Right Gear with Camera Align															*
 * 3 = Left Gear with Camera Align
 * 4 = Move forward over line
 * 5 = Left Gear and Run Down Field - for red side  
 * 6 = Right Gear and Run Down Field - for Blue side                         				*
 * 7 = No Auton  
 * 8 = test Auton do not use unless your name is alex or malcolm                                            								*
 * CHANGE THIS NUMBER TO THE NUMBER OF YOUR CHOICE THAT CORRESPONDS WITH THE LIST ABOVE.    *                                                                              
 * THIS NUMBER!!! ------>>>>____[*/ 2 /*]____<<<<------ THIS NUMBER HERE					*
 *                                                                 							*
 * DO NOT MODIFY ANY OTHER CODE IN THIS FILE OR												*
 * ANYWHERE ELSE UNLESS YOU KNOW WHAT YOU ARE DOING!										*
 * 																							*
 * TO RUN THIS NEW PROGRAM, PRESS THE CIRCULAR GREEN PLAY BUTTON IN THE TOOLBAR ABOVE		*
 * AND SELECT "WPILib Java Deploy" WHILE CONNECTED TO ROBOT WIFI. IT SHOULD THEN			*
 * DOWNLOAD AND CHANGES WILL BE REFLECTED BY THE ROBOT.										*
 *                                                                                   		*
 ********************************************************************************************/;
  
	public static OI oi;
	
	public static Joystick stick;
	public static Joystick operator;
	public static Joystick test;
	public static DriveTrain drivetrain;
	public static Shooter shoot;
	public static Intake intake;
	public static Agitator agi;
	public static GearPusher push;
	public static PowerDistributionPanel pdp;
	public static Winch winch;
	public static Lights lights;
	
	Command AutonomousCammand;
	
    public void robotInit() {
      oi = new OI();
      lights = new Lights();
      stick = new Joystick(0);
      operator = new Joystick(1);
      drivetrain = new DriveTrain();
      shoot = new Shooter();
      intake = new Intake();
      agi = new Agitator();
      push = new GearPusher();
      pdp = new PowerDistributionPanel();
      winch = new Winch();     
      test = new Joystick(2);
      
      //DigitalOutput autonToggle1 = new DigitalOutput(8);
      //DigitalOutput autonToggle2 = new DigitalOutput(9);
      
        
          
      switch(autonIndex) {
      	case 0:  AutonomousCammand = new MoveForwardAndPlaceGear();
      			 break;
      	case 1:  AutonomousCammand = new MoveForwardWithAlignAndPlaceGear();
      			 break;
      	case 2:  AutonomousCammand = new MoveForwardAlignToGearForRightTarget();
      			 break;
      	case 3:  AutonomousCammand = new MoveForwardAlignToGearForLeftTarget();
      			 break;
      	case 4:  AutonomousCammand = new MoveForwardToCrossLine();
      			 break;
      	case 5: AutonomousCammand = new MoveForwardLeftGearThenGoDownField();
      			break;
      	case 6: AutonomousCammand = new MoveForwardRightGearThenGoDownField();
				break;
      	case 7: AutonomousCammand = null;
      			break;
      	case 8: AutonomousCammand = new TestAuton();
      			break;
      }
//      if(autonToggle1.get() == true){
//    	  AutonomousCammand = new MoveForwardWithAlignAndPlaceGear();
//    	  SmartDashboard.putString("Auton Selected", "Move Forward With Align and Place Gear");
//      }
//      else if (autonToggle2.get() == true){
//    	  AutonomousCammand = new MoveForwardAlignToGearForRightTarget();
//    	  SmartDashboard.putString("Auton Selected", "Align to Right Gear Target");
//    	  
//      }
      

     
      
    }
    
    
    public boolean isAuton(){
    	return this.isAutonomous();
    }
    
    public void disabledInit(){
    }
    
	public void disabledPeriodic(){
		
	}
    public void autonomousInit() {
    	periodicStart();
    }
    
    public void periodicUpdate(){
    	shoot.update();
    	drivetrain.update();
    	push.update();
    	lights.update();
    	
    }
    public void periodicStart(){
    	if (AutonomousCammand != null) AutonomousCammand.start();
    	drivetrain.start();
    	shoot.start();
    	push.start();
    	
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    	periodicUpdate();

    }
   
    /**
     * This function is called periodically during operator control
     */
    public void teleopInit(){
    	periodicStart();
      }
    public void teleopPeriodic() {
    	oi.driveRobot(stick, drivetrain, shoot, intake, agi, push, winch);
    	oi.operateRobot(operator, drivetrain, shoot, intake, agi, push, winch);
    	oi.controlLights(lights, drivetrain, shoot, intake, agi, push, winch);
        periodicUpdate();
        //SmartDashboard.putNumber("current in Amps", pdp.getCurrent(2));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
    
}
