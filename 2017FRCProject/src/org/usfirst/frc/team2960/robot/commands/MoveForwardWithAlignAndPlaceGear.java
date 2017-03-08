package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardWithAlignAndPlaceGear extends CommandGroup {
	public MoveForwardWithAlignAndPlaceGear(){
		addSequential(new Delay(500));
		addSequential(new MoveForwardUltra(70, 1));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltra(30, 1));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltra(6, 1));
		addSequential(new MoveForwardUltra(20, 1));
		
	}
}



