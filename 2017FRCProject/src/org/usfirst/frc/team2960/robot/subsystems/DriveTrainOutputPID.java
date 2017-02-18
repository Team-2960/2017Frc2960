package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainOutputPID implements PIDOutput {

	DriveTrain drive;
	
	public DriveTrainOutputPID(DriveTrain drive){
		this.drive = drive;
	}
	
	@Override
	public void pidWrite(double output) {
		drive.runPidOI(output, -output);
		SmartDashboard.putNumber("PID ENC Output VAL", output);
	}

}
