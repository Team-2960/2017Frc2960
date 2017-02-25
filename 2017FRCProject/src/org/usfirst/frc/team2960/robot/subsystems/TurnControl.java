package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;

public class TurnControl implements PIDOutput{
	DriveTrain drive;
	
	
	TurnControl(DriveTrain drive){
		this.drive = drive;
	}
	
	
	@Override
	public void pidWrite(double output) {
		if(drive.isTurnOnly)
			drive.runPidOI(-output, -output);
		else 
			drive.setSpeed(-output, -output);
			
	}

}
