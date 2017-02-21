package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlignToGear extends Command {

	
	
	protected void initialize(){
		Robot.drivetrain.autonTurnDone = false;
	}
	
	protected void execute(){
		Robot.drivetrain.turnToTarget();
	}
	
	
	
	
	@Override
	protected boolean isFinished() {
		if(Robot.drivetrain.autonTurnDone){
			Robot.drivetrain.setPidGo(false);
			Robot.drivetrain.OnOff = false;
			Robot.drivetrain.ringLightOff(); 
			return true;
		}
		else{
			return false;
		}
	}

}
