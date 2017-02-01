package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPusher extends Subsystem implements PeriodicUpdate {

	Solenoid GearPusher;
	
	
	public GearPusher(){
		GearPusher = new Solenoid(RobotMap.gearPusher);
	}
	
	public void turnOn(){
		GearPusher.set(true);
	}
	public void turnOff(){
		GearPusher.set(false);
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
