package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem implements PeriodicUpdate {

	VictorSP intake;
	double speed;
	
	public Intake(){
		intake = new VictorSP(RobotMap.intake);
		speed = .5;
	}
	
	public void startIntake(){
		intake.set(speed);
	}
	
	public void stopIntake(){
		intake.set(0);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
