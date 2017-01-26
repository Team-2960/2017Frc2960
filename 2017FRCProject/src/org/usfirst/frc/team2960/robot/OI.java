package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	
	public void driveRobot(Joystick stick,  DriveTrain drive){
		//drive.setSpeed(-stick.getRawAxis(5), -stick.getRawAxis(1));
		if(stick.getRawButton(1)){
			drive.shift(true);
		}
		if(stick.getRawButton(2)){
			drive.shift(false);
		}
		
		if(stick.getRawButton(3)){
			drive.startPID();
		}
		if(stick.getRawButton(4)){
			drive.stopPID();
		}
	}
	
	public void operateRobot(Joystick stick ){
		
	}
	
	
}
