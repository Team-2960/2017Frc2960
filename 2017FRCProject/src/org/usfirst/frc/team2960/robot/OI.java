package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;

public class OI{
	boolean isTurning = false;
	
	public void driveRobot(Joystick stick,  DriveTrain drive, Shooter shoot, Intake intake, Agitator agi, GearPusher push){
		if(!isTurning){
			drive.setSpeed(-stick.getRawAxis(5), -stick.getRawAxis(1));
		}
		if(stick.getRawButton(1)){
			shoot.turnONOFF(true);
		}
		if(stick.getRawButton(2)){
			shoot.turnONOFF(false);
		}
		if(stick.getRawButton(5)){
			drive.setTurnToTarget(true);
			isTurning = true;
		}
	}
	
	public void operateRobot(Joystick stick ){
		
	}
	
}
