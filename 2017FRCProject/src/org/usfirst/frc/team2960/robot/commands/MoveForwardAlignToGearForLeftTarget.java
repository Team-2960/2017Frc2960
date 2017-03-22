package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTarget extends CommandGroup{	
	public MoveForwardAlignToGearForLeftTarget(){
		addSequential(new MoveForwardUltra(93, 1));
		addSequential(new TurnDegree(1.25, -100));
		addSequential(new MoveForwardUltraOrHitButton(5, .8));
		addSequential(new MoveForwardUltra(20, 1));
	}
}
