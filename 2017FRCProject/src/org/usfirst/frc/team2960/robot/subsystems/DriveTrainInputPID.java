package org.usfirst.frc.team2960.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DriveTrainInputPID implements PIDSource {
	DriveTrain drive;
	PIDSourceType m_pidSource;
	
	DriveTrainInputPID(DriveTrain drive){
		this.drive = drive;
	}
	
	
	
	@Override
	  public void setPIDSourceType(PIDSourceType pidSource) {
	    m_pidSource = pidSource; 
	  }

	  @Override
	  public PIDSourceType getPIDSourceType() {
	    return m_pidSource;
	  }

	  /**
	   * Get the output of the gyro for use with PIDControllers. May be the angle or rate depending on
	   * the set PIDSourceType
	   *
	   * @return the output according to the gyro
	   */
	  @Override
	  public double pidGet() {
	    switch (m_pidSource) {
	      case kRate:
	        return (double)((drive.getRightEncoder() + drive.getLeftEncoder())/2);
	      case kDisplacement:
	        return 50.0;
	      default:
	        return 0.0;
	    }
	  }

}
