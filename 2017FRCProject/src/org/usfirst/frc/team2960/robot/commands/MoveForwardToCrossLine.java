package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardToCrossLine extends CommandGroup {
	public MoveForwardToCrossLine(){
		addSequential(new MoveForwardTime(3));
	}
}
