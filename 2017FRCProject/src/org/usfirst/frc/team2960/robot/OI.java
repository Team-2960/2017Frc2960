//package org.usfirst.frc.team2960.robot;
//
//import org.usfirst.frc.team2960.robot.subsystems.Agitator;
//import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
//import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
//import org.usfirst.frc.team2960.robot.subsystems.Intake;
//import org.usfirst.frc.team2960.robot.subsystems.Shooter;
//import org.usfirst.frc.team2960.robot.subsystems.Winch;
//
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//
//public class OI{
//	Boolean flap = false;
//	Boolean toggle = true;
//	
//	public void driveRobot(Joystick stick,  DriveTrain drive, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch){
//		
//		
//		if(!drive.isPidGo()){
//			drive.setSpeed(-stick.getRawAxis(5), stick.getRawAxis(1));
//		}
//		else{
//			drive.addTurn(-stick.getRawAxis(5), stick.getRawAxis(1));
//		}
//		if(stick.getRawButton(6))
//			drive.shift(true);
//		if(stick.getRawButton(5))
//			drive.shift(false);
//		
//		if(stick.getRawButton(1))
//			push.activateGearPush = true;
//		else if (stick.getRawButton(2))
//			push.activateGearPush = false;
//		//camera control
//		
//		//change camera
//		if(stick.getRawAxis(2)>.85){
//			drive.isGearCam = false;
//			drive.setTurnToTarget(true);
//			drive.setPidGo(true);
//		}
//		else if(stick.getRawAxis(3) >.85){
//			drive.isGearCam = true;
//			drive.setTurnToTarget(true);
//			drive.setPidGo(true);
//		}
//		else{
//			drive.setTurnToTarget(false);
//			drive.setPidGo(false);
//		}
//		
//		
//		if(stick.getRawButton(7) && stick.getRawButton(8) && stick.getRawButton(5) && stick.getRawButton(6))
//			winch.WinchDown();
//		
//		
//	
//	}
//	
//	public void operateRobot(Joystick stick, DriveTrain drivetrain, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch ){
//		
//		//Pusher overide controls
//		if(stick.getRawButton(2)){
//			push.turnOn();
//			push.setAutoGearPush(false);
//		}
//		else{
//			push.turnOff();
//			push.setAutoGearPush(true);
//		}
//		
//		//agitator controls
//		if(stick.getRawButton(6))
//			agi.startAgitator();
//		else if(stick.getRawButton(5))
//			agi.startAgitatorReversed();
//		else
//			agi.stopAgitator();
//		
//		//shooter control
//		if(stick.getRawButton(1))
//			shoot.turnONOFF(true);
//			//shoot.startPID();
//			
//		else
//			shoot.turnONOFF(false);
//			//shoot.stopPID();
//		
//		//intake controls
//		if(stick.getRawAxis(3)> .85)
//			intake.startIntake();
//		else if(stick.getRawAxis(2) > .85)
//			intake.startIntakeReversed();
//		else 
//			intake.stopIntake();
//		
//		// winch control
//		if(stick.getRawButton(3))
//			winch.WinchUP();
//		else
//			winch.WinchStop();
//		//flap control
//		if(stick.getRawButton(4))
//			push.flapOn();
//		else 
//			push.flapOff();
//		
//		
//		
//	}
//	
//}
package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Lights;
//import org.usfirst.frc.team2960.robot.subsystems.Lights;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;
import org.usfirst.frc.team2960.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI{
	
	
	final double FIRSTSPEED = 20000;
	final double SECONDSPEED = 23000;
	final double THIRDSPEED = 24000;
	final double FOURTHSPEED = 25000;
	final double ZEROSPEED = 0;
	Boolean flap = false;
	Boolean toggle = true;
	boolean winchToggle = false;
	boolean usingPresets = true;
	boolean winchLight = false;
	
	public void driveRobot(Joystick stick,  DriveTrain drive, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch){
		
		//SmartDashboard.putNumber("The axis", stick.getRawAxis(3));
		if(!drive.isPidGo()){
			drive.setSpeed(-stick.getRawAxis(5), stick.getRawAxis(1));
		}
		else{
			drive.addTurn(-stick.getRawAxis(5), stick.getRawAxis(1));
		}
		if(stick.getRawButton(6))
			drive.shift(true);
		if(stick.getRawButton(5))
			drive.shift(false);
		if(stick.getRawButton(1))
			push.activateGearPush = true;
		else if (stick.getRawButton(2))
			push.activateGearPush = false;
		//camera control
		if(stick.getRawButton(3))
			drive.ringLightOn();
		else if(stick.getRawButton(4))
			drive.ringLightOff();
		//change camera
		//left
		if(stick.getRawAxis(2)>.85){
			drive.isGearCam = false;
			drive.setTurnToTarget(true);
			drive.setPidGo(true);
			drive.isTurnOnly = true;
		}
		//right
		else if(stick.getRawAxis(3) >.85){
			drive.ringLightOn();
			drive.isGearCam = true;
			drive.setTurnToTarget(true);
			drive.setPidGo(true);
			drive.isTurnOnly = true;
		}
		else{
			drive.ringLightOff();
			drive.setTurnToTarget(false);
			drive.setPidGo(false);
		}
		
		
		if(stick.getRawButton(7) && stick.getRawButton(8) && stick.getRawButton(5) && stick.getRawButton(6)){
			winch.WinchDown();
			winchToggle = true;
		}
		else
			winchToggle = false;
		
		if(stick.getRawButton(3)){
			drive.ringLightOn();
		}
		else if(stick.getRawButton(4)){
			drive.ringLightOff();
		}
		
		
	
	}
	
	public void operateRobot(Joystick stick, DriveTrain drivetrain, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch){
		
		//Pusher overide controls
		if(stick.getRawButton(8)){
			push.turnOn();
			push.setAutoGearPush(false);
		}
		else{
			push.turnOff();
			push.setAutoGearPush(true);
		}
		
		//agitator controls
		if(stick.getRawButton(4))
			agi.startAgitator();
		else if(stick.getRawButton(5))
			agi.startAgitatorReversed();
		else
			agi.stopAgitator();
		
		
		
		//shooter control
		
		
		//preset speeds
		if(usingPresets){
			if(stick.getRawButton(14)){
				double range = SECONDSPEED - FIRSTSPEED;
				shoot.setSetpoint(FIRSTSPEED + (range * (1 - stick.getRawAxis(4))));
				shoot.turnONOFF(true);
				shoot.startPID();
				
				}
			else if(stick.getRawButton(15)){
				double range = THIRDSPEED - SECONDSPEED;
				shoot.setSetpoint(SECONDSPEED + (range * (1 - stick.getRawAxis(4))));
				shoot.turnONOFF(true);
				shoot.startPID();
				}
			else if(stick.getRawButton(16)){
				double range = FOURTHSPEED - THIRDSPEED;
				shoot.setSetpoint(THIRDSPEED + (range * (1 - stick.getRawAxis(4))));
				shoot.turnONOFF(true);
				shoot.startPID();
				}
			else if(stick.getRawButton(12)){
				shoot.setSetpoint(FOURTHSPEED);
				shoot.turnONOFF(true);
				shoot.startPID();
				}
			else if(stick.getRawButton(13)){
				shoot.setSetpoint(ZEROSPEED);
				shoot.turnONOFF(false);
				shoot.stopPID();
				}
			}
		
			
		//set speed, overide presets
		
		
		
		
		//intake controls
		if(stick.getRawButton(3))
			intake.startIntake();
		else if(stick.getRawButton(2))
			intake.startIntakeReversed();
		else 
			intake.stopIntake();
		
		// winch control
		if(stick.getRawButton(1) && !winchToggle){
			winch.WinchUP();
			winchLight  = true;
		}
		else if(!winchToggle){
			winch.WinchStop();
			winchLight = false;
		}
		//flap control
		if(stick.getRawButton(9))
			push.flapOn();
		else 
			push.flapOff();
		
		
		
	}
	
	
	public void controlLights(Lights light){
		if(winchLight){
			light.setLights(1, 0, 1);
		}
	}
	
}
