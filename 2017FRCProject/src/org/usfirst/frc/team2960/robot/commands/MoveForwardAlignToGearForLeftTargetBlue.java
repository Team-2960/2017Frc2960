package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTargetBlue extends CommandGroup {
public MoveForwardAlignToGearForLeftTargetBlue(){
	addSequential(new MoveForwardUltra(92, 1));
	addSequential(new TurnDegree(1.25, -90));
	addSequential(new AlignToGear());
	addSequential(new MoveForwardUltra(30, 1));
	addSequential(new AlignToGear());
	addSequential(new MoveForwardUltraOrHitButton(7, .8));
	addSequential(new MoveForwardUltra(20, 1));
	}
}
