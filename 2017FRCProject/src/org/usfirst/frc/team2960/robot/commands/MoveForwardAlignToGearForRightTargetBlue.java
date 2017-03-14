package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForRightTargetBlue extends CommandGroup {
	public MoveForwardAlignToGearForRightTargetBlue(){
		addSequential(new MoveForwardUltra(90, 1));
		addSequential(new TurnDegree(1.25, 100));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltra(35, 1));
		addSequential(new AlignToGear());
		addSequential(new MoveForwardUltraOrHitButton(7, .8));
		addSequential(new MoveForwardUltra(60, 1));
		addSequential(new TurnDegree(.25, 100));
		addSequential(new ShootCommand(2600));
		
	}
}
 