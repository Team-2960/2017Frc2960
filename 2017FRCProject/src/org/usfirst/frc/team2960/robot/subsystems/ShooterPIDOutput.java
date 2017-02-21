package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterPIDOutput implements PIDOutput {
	Shooter shoot;
	public ShooterPIDOutput(Shooter shoot){
		this.shoot = shoot;
	}
	
	
	
	@Override
	public void pidWrite(double output) {
		shoot.shoot.set(output);
		SmartDashboard.putNumber("shooter output", output);
	}

}
