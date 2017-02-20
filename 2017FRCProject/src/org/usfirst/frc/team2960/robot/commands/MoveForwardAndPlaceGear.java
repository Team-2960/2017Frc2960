package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAndPlaceGear extends CommandGroup {

	public MoveForwardAndPlaceGear(){
		addSequential(new MoveForward(1000));
	}
	
}
