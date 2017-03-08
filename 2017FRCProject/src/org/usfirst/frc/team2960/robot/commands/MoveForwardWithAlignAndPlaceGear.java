package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardWithAlignAndPlaceGear extends CommandGroup {
	public MoveForwardWithAlignAndPlaceGear(){
		addSequential(new MoveForwardUltra(70, .5));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltra(20, .5));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltra(5, .5));
		addSequential(new MoveForwardUltra(20, .5));
		
	}
}



