package org.usfirst.frc.team2960.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveForwardAlignToGearForLeftTargetBlue extends CommandGroup {
public MoveForwardAlignToGearForLeftTargetBlue(){
	addSequential(new MoveForward(-72));
	addSequential(new TurnDegree(.75, 80));
	addSequential(new AlignToGear());
	addSequential(new Delay(20));
	addSequential(new MoveForward(-40));
	addSequential(new AlignToGear());
	addSequential(new Delay(20));
	addSequential(new MoveForwardOrHitButton(-25));
	addSequential(new MoveForward(20));
	}
}