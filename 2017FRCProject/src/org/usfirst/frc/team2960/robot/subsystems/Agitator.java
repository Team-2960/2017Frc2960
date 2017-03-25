package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem implements PeriodicUpdate{
	
	VictorSP Agitator;//left
	VictorSP Agitator2;//right
	double speed;
	
	public Agitator(){
		Agitator = new VictorSP(RobotMap.agitator);
		Agitator2 = new VictorSP(RobotMap.agitator2);
		speed = 1;
	}

	
	public void startAgitator(){
		Agitator.set(speed);
		Agitator2.set(-speed);
	}
	
	public void startAgitatorReversed(){
		Agitator.set(-speed);
		Agitator2.set(speed);
	}
	
	public void stopAgitator(){
		Agitator.set(0);
		Agitator2.set(0);
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
