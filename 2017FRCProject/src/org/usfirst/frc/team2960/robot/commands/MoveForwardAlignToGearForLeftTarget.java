package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTarget extends CommandGroup{	
	public MoveForwardAlignToGearForLeftTarget(){
		//The auton only for red and change later for after southfireld
		addSequential(new MoveForward(-77));
		addSequential(new TurnDegree(.75, 90));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForward(-30));
		addSequential(new AlignToGear());
		addSequential(new Delay(20));
		addSequential(new MoveForwardOrHitButton(-45));
		addSequential(new MoveForward(20));
	}
}
