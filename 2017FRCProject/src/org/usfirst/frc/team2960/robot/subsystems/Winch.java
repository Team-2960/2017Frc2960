package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem implements PeriodicUpdate{

	CANTalon winch;
	double speed;
	
	
	public Winch(){
		winch = new CANTalon(RobotMap.winch);
		speed = 1;
	}
	
	public void WinchUP(){
		winch.set(-speed);
	}
	
	public void WinchDown(){
		winch.set(speed);
	}
	
	public void WinchStop(){
		winch.set(0);
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
