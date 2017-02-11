package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPusher extends Subsystem implements PeriodicUpdate {

	DoubleSolenoid GearPusher;
	DoubleSolenoid Flap;
	Relay ringLight;
	
	public GearPusher(){
		GearPusher = new DoubleSolenoid(RobotMap.gearPusher, RobotMap.gearPusher2);
		Flap = new DoubleSolenoid(RobotMap.flap, RobotMap.flap2);
		ringLight = new Relay(RobotMap.ringLight);
	}
	
	public void turnOn(){
		GearPusher.set(Value.kForward);
	}
	public void turnOff(){
		GearPusher.set(Value.kReverse);
	}
	
	public void flapOn(){
		Flap.set(Value.kForward);
	}
	public void flapOff(){
		Flap.set(Value.kReverse);
	}
	public void ringLightOn(){
		ringLight.set(Relay.Value.kForward);
	}
	public void ringLightOff(){
		ringLight.set(Relay.Value.kOff);
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
