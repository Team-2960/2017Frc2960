package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForRightTarget extends CommandGroup {
	public MoveForwardAlignToGearForRightTarget(){
		addSequential(new MoveForwardUltra(84, 1));
		addSequential(new TurnDegree(1.25, 100));
		addSequential(new MoveForwardUltraOrHitButton(4, .8));
		addSequential(new MoveForwardUltra(20, 1));
		}
}
