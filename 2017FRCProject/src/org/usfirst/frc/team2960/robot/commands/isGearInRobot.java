package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class isGearInRobot extends Command{
	public isGearInRobot(){
		super("isGearInRobot");
		requires(Robot.push);
		
	}
	protected void initialize(){
		
	}
	protected void execute(){
		
	}
	@Override
	protected boolean isFinished() {
		if (!Robot.push.isGearIn())
			return true;
		else
			return false;
	}

}
