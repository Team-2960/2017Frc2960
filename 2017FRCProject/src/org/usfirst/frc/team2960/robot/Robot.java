
package org.usfirst.frc.team2960.robot;

import org.ietf.jgss.Oid;
import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.Camera;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
  
	public static OI oi;
	
	Joystick stick;
	DriveTrain drivetrain;
	DigitalInput sensor;
	Shooter shoot;
	Intake intake;
	Agitator agi;
	GearPusher push;
	
    public void robotInit() {
      oi = new OI();
      stick = new Joystick(0);
      drivetrain = new DriveTrain();
      
      sensor = new DigitalInput(1);
      shoot = new Shooter();
      intake = new Intake();
      agi = new Agitator();
      push = new GearPusher();
    }
    
    public void disabledInit(){
    }
    
	public void disabledPeriodic(){
		
	}
    public void autonomousInit() {
    	periodicStart();
    }
    
    public void periodicUpdate(){
    	shoot.update();
    	drivetrain.update();
    	
    }
    public void periodicStart(){
  
    	shoot.start();
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
    	oi.driveRobot(stick, drivetrain, shoot, intake, agi, push);
        periodicUpdate();
        SmartDashboard.putBoolean("Sensor", sensor.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
