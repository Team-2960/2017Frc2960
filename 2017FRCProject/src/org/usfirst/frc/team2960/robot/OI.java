package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	
	public void driveRobot(Joystick stick,  DriveTrain drive){
		drive.setSpeed(-stick.getRawAxis(5), -stick.getRawAxis(1));
	}
	
	public void operateRobot(Joystick stick ){
		
	}
	
	
}
