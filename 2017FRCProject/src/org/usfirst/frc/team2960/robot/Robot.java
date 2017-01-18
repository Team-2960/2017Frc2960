
package org.usfirst.frc.team2960.robot;

import org.usfirst.frc.team2960.robot.subsystems.Camera;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
  
	public static OI oi;
	
	Joystick stick;
	DriveTrain drivetrain;
	Camera cam;
    public void robotInit() {
      oi = new OI();
      stick = new Joystick(0);
      drivetrain = new DriveTrain();
      cam = new Camera();
    }
    
    public void disabledInit(){
    }
    
	public void disabledPeriodic(){
		
	}
    public void autonomousInit() {
    	periodicStart();
    }
    
    public void periodicUpdate(){
    	drivetrain.update();
    	cam.update();
    		
    }
    public void periodicStart(){
    	cam.start();
    	drivetrain.start();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	periodicUpdate();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit(){
    	periodicStart();
    }
    public void teleopPeriodic() {
    	oi.driveRobot(stick, drivetrain);
        periodicUpdate();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
