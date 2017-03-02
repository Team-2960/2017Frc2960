package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTarget extends CommandGroup{	
	public MoveForwardAlignToGearForLeftTarget(){
		addSequential(new MoveForward(-72));
		addSequential(new TurnDegree(.75, 60));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForward(-30));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForwardOrHitButton(-30));
		addSequential(new MoveForward(20));
	}
}
