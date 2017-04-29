package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuton extends CommandGroup{
	public TestAuton(){	
//			addSequential(new MoveForwardUltra(85, .8));
//			addSequential(new TurnDegree(1.1, -100));
//			addSequential(new MoveForwardUltraOrHitButton(5, .8));
//			addSequential(new Delay(.2));
//			addSequential(new MoveForwardUltra(20, 1));
//			addSequential(new isGearInRobot2());
//			addSequential(new MoveForwardUltraOrHitButton(5, .8));
//			addSequential(new Delay(.2));
//			addSequential(new MoveForwardUltra(20, 1));
		addSequential(new Delay(500));
		addSequential(new MoveForwardUltraOrHitButton(5, .8));
		addSequential(new MoveForwardUltra(20, 1));
		addSequential(new isGearInRobot2());
		addSequential(new Delay(500));
		addSequential(new MoveForwardUltraOrHitButton(5, .8));
		addSequential(new MoveForwardUltra(20, 1));
			
	}
}
