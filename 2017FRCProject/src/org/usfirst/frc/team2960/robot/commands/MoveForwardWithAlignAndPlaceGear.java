package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardWithAlignAndPlaceGear extends CommandGroup {
	public MoveForwardWithAlignAndPlaceGear(){
		//addSequential(new MoveForwardUltra);
		addSequential(new AlignToGear());
		addSequential(new MoveForward(-25));
		addSequential(new AlignToGear());
		//addSequential(new MoveForwardUltra);
		addSequential(new MoveForward(20));
	}
}



