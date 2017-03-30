package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTarget extends CommandGroup{	
	public MoveForwardAlignToGearForLeftTarget(){
		addSequential(new MoveForwardUltra(85, 1));
		addSequential(new TurnDegree(1.15, -100));
		addSequential(new MoveForwardUltraOrHitButton(5, .8));
		addSequential(new Delay(.2));
		addSequential(new MoveForwardUltra(20, 1));
	}
}
