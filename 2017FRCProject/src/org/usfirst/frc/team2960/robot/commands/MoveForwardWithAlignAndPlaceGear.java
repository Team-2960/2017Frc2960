package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardWithAlignAndPlaceGear extends CommandGroup {
	public MoveForwardWithAlignAndPlaceGear(){
		addSequential(new MoveForward(-20));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForward(-25));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForwardOrHitButton(-35));
		addSequential(new MoveForward(20));
	}
}



