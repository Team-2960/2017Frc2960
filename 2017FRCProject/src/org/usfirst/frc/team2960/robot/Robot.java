
package org.usfirst.frc.team2960.robot;

import org.ietf.jgss.Oid;
import org.usfirst.frc.team2960.robot.commands.MoveForwardAndPlaceGear;
import org.usfirst.frc.team2960.robot.subsystems.Agitator;
import org.usfirst.frc.team2960.robot.subsystems.Camera;
import org.usfirst.frc.team2960.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2960.robot.subsystems.GearPusher;
import org.usfirst.frc.team2960.robot.subsystems.Intake;
import org.usfirst.frc.team2960.robot.subsystems.Shooter;
import org.usfirst.frc.team2960.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
  
	public static OI oi;
	
	public static Joystick stick;
	public static Joystick operator;
	public static DriveTrain drivetrain;
	public static Shooter shoot;
	public static Intake intake;
	public static Agitator agi;
	public static GearPusher push;
	public static PowerDistributionPanel pdp;
	public static Winch winch;
	
	Command AutonomousCammand;
	
    public void robotInit() {
      oi = new OI();
      stick = new Joystick(0);
      operator = new Joystick(1);
      drivetrain = new DriveTrain();
      shoot = new Shooter();
      intake = new Intake();
      agi = new Agitator();
      push = new GearPusher();
      pdp = new PowerDistributionPanel();
      winch = new Winch();
      
      AutonomousCammand = new MoveForwardAndPlaceGear();
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
    	push.update();
    	
    }
    public void periodicStart(){
  
    	if (AutonomousCammand != null) AutonomousCammand.start();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit(){
    	periodicStart();
    }
    public void teleopPeriodic() {
    	oi.driveRobot(stick, drivetrain, shoot, intake, agi, push, winch);
    	oi.operateRobot(operator, drivetrain, shoot, intake, agi, push, winch);
        periodicUpdate();
        SmartDashboard.putNumber("current in Amps", pdp.getCurrent(2));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
    
}
