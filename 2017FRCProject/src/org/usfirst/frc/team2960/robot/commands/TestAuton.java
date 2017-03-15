package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuton extends CommandGroup{
	public TestAuton(){
		addSequential(new MoveForwardTime(2));
	}
}
