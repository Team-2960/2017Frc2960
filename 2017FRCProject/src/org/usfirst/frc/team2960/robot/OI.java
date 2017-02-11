package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;
import org.usfirst.frc.team2960.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.Joystick;

public class OI{
	
	Boolean flap = false;
	Boolean toggle = true;
	
	public void driveRobot(Joystick stick,  DriveTrain drive, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch){
		//drive.setSpeed(-stick.getRawAxis(5), stick.getRawAxis(1));
		if(stick.getRawButton(6))
			drive.shift(true);
		if(stick.getRawButton(5))
			drive.shift(false);
		if(stick.getRawButton(1))
			push.ringLightOn();
		if(stick.getRawButton(2))
			push.ringLightOff();
		if(stick.getRawButton(3))
			drive.setTurnToTarget(true);
		if(stick.getRawButton(4))
			drive.setTurnToTarget(false);
	
	}
	
	public void operateRobot(Joystick stick, DriveTrain drivetrain, Shooter shoot, Intake intake, Agitator agi, GearPusher push, Winch winch ){
		if(stick.getRawButton(2))
			push.turnOn();
		else
			push.turnOff();
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
