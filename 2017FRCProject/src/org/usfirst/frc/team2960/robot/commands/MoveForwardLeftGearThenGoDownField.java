package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardLeftGearThenGoDownField extends CommandGroup{
	public MoveForwardLeftGearThenGoDownField(){
		addSequential(new MoveForwardUltra(93, 1));
		addSequential(new TurnDegree(1.25, -100));
		addSequential(new MoveForwardUltraOrHitButton(4, .8));
		addSequential(new Delay(.2));
		addSequential(new MoveForwardUltra(20, 1));
		addSequential(new TurnDegree(.25,-100));
		addSequential(new MoveForward(1));
	}
}
