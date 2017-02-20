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
		if(stick.getRawButton(7)){
			drive.isGearCam = false;
		}
		if(stick.getRawButton(8)){
			drive.isGearCam = true;
		}
		
		
	
	}
	
	public void operateRobot(Joystick stick, DriveTrain drivetrain, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch ){
		if(stick.getRawButton(2)){
			push.turnOn();
			push.setAutoGearPush(false);
		}
		else{
			push.turnOff();
			push.setAutoGearPush(true);
		}
		if(stick.getRawButton(6))
			agi.startAgitator();
		else if(stick.getRawButton(5))
			agi.startAgitatorReversed();
		else
			agi.stopAgitator();
		if(stick.getRawButton(1))
			shoot.turnONOFF(true);
			//shoot.startPID();
			
		else
			shoot.turnONOFF(false);
			//shoot.stopPID();
			
		if(stick.getRawButton(8))
			intake.startIntake();
		else if(stick.getRawButton(7))
			intake.startIntakeReversed();
		else 
			intake.stopIntake();
		if(stick.getRawButton(10))
			winch.WinchUP();
		else if(stick.getRawButton(3))
			winch.WinchDown();
		else
			winch.WinchStop();
		if(stick.getRawButton(4))
			push.flapOn();
		else 
			push.flapOff();
		
		
		
	}
	
}
