package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardRightGearThenGoDownField extends CommandGroup {
	public MoveForwardRightGearThenGoDownField(){
		addSequential(new MoveForwardUltra(84, 1));
		addSequential(new TurnDegree(1, 100));
		addSequential(new MoveForwardUltraOrHitButton(4, .8));
		addSequential(new Delay(.2));
		addSequential(new MoveForwardUltra(30, 1));
		addSequential(new TurnDegree(.25,100));
		addSequential(new MoveForwardTime(15));
		}
}
