package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;
import org.usfirst.frc.team2960.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class OI{
	
	Boolean flap = false;
	Boolean toggle = true;
	
	public void driveRobot(Joystick stick,  DriveTrain drive, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch){
		
		
		if(!drive.isPidGo()){
			drive.setSpeed(-stick.getRawAxis(5), stick.getRawAxis(1));
		}
		else{
			//drive.runPidOI(-stick.getRawAxis(5), stick.getRawAxis(1));
		}
		if(stick.getRawButton(6))
			drive.shift(true);
		if(stick.getRawButton(5))
			drive.shift(false);
		if(stick.getRawButton(1)){
			//shoot.setSetpoint(0);
			//push.ringLightOn();
			//drive.setEncSetpoint(1000);
			//drive.setSetpoint(45);
			//shoot.setSetpoint(2000);
		}
		if(stick.getRawButton(2)){
			//drive.setEncSetpoint(0);
			//drive.setSetpoint(0);
			//shoot.setSetpoint(0);
		}
			//shoot.setSetpoint(18000);
			//push.ringLightOff();
		
		if(stick.getRawButton(3)){
			shoot.startPID();
			/*
			drive.setTurnToTarget(true);
			drive.setPidGo(true);
			*/
			//drive.startEncPID();
			//drive.startPID();
			//drive.setPidGo(true);
			//shoot.startPID();
			
		}
		if(stick.getRawButton(4)){
			shoot.stopPID();
			/*
			drive.setTurnToTarget(false);
			drive.setPidGo(false);
			*/
			//shoot.stopPID();
			//drive.stopEncPID();
			//drive.stopPID();
			//drive.setPidGo(false);
		}
		
		if(stick.getRawButton(1))
			push.activateGearPush = true;
		else if (stick.getRawButton(2))
			push.activateGearPush = false;
		//camera control
		
		//change camera
		if(stick.getRawAxis(2)>.85){
			drive.isGearCam = false;
		}
		else if(stick.getRawAxis(3) >.85){
			drive.isGearCam = true;
		}
		
		
		if(stick.getRawButton(7) && stick.getRawButton(8) && stick.getRawButton(5) && stick.getRawButton(6))
			winch.WinchDown();
		
		
	
	}
	
	public void operateRobot(Joystick stick, DriveTrain drivetrain, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch ){
		
		//Pusher overide controls
		if(stick.getRawButton(2)){
			push.turnOn();
			push.setAutoGearPush(false);
		}
		else{
			push.turnOff();
			push.setAutoGearPush(true);
		}
		
		//agitator controls
		if(stick.getRawButton(6))
			agi.startAgitator();
		else if(stick.getRawButton(5))
			agi.startAgitatorReversed();
		else
			agi.stopAgitator();
		
		//shooter control
		if(stick.getRawButton(1))
			shoot.turnONOFF(true);
			//shoot.startPID();
			
		else
			shoot.turnONOFF(false);
			//shoot.stopPID();
		
		//intake controls
		if(stick.getRawAxis(3)> .85)
			intake.startIntake();
		else if(stick.getRawAxis(2) > .85)
			intake.startIntakeReversed();
		else 
			intake.stopIntake();
		
		// winch control
		if(stick.getRawButton(3))
			winch.WinchUP();
		else
			winch.WinchStop();
		//flap control
		if(stick.getRawButton(4))
			push.flapOn();
		else 
			push.flapOff();
		
		
		
	}
	
}
