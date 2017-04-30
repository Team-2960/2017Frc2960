package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForRightTarget extends CommandGroup {
	public MoveForwardAlignToGearForRightTarget(){
		addSequential(new MoveForwardUltra(78, .8));
		addSequential(new TurnDegree(1, 100));
		addSequential(new MoveForwardUltraOrHitButton(4, .8));
		addSequential(new Delay(.2));
		addSequential(new MoveForwardUltra(20, 1));
		addSequential(new isGearInRobot2());
		addSequential(new MoveForwardUltraOrHitButton(4, .8));
		addSequential(new Delay(.2));
		addSequential(new MoveForwardUltra(20, 1));
		
		}
}
