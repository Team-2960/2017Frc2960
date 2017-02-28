package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardWithAlignAndPlaceGear extends CommandGroup {
	public MoveForwardWithAlignAndPlaceGear(){
		addSequential(new MoveForward(-10));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForward(-35));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForwardOrHitButton(-30));
		addSequential(new MoveForward(20));
	}
}



