package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ShooterPIDInput implements PIDSource {
	
	Shooter shoot;
	PIDSourceType m_pidSource;
	public ShooterPIDInput(Shooter shoot){
		this.shoot = shoot;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		 m_pidSource = pidSource; 
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		 return m_pidSource;
	}

	@Override
	public double pidGet() {
		
		return -(double)(shoot.shoot.getEncVelocity());
	}

}
