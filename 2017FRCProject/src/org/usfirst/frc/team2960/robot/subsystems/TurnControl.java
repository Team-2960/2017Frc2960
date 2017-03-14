package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnControl implements PIDOutput{
	DriveTrain drive;
	
	
	TurnControl(DriveTrain drive){
		this.drive = drive;
	}
	
	
	@Override
	public void pidWrite(double output) {
		SmartDashboard.putNumber("the output of pid ", output);
		if(drive.isTurnOnly)
			drive.runPidOI(-output, -output);
		else{ 
			drive.setSpeed(-output, -output);
			
		}
			
	}

}
