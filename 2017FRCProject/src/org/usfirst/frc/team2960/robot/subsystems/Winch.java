package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem implements PeriodicUpdate{

	CANTalon winch;
	CANTalon winch2;
	double speed;
	
	
	public Winch(){
		winch = new CANTalon(RobotMap.winch);
		winch2 = new CANTalon(RobotMap.winch2);
		speed = 1;
	}
	
	public void WinchUP(){
		winch.set(-speed);
		winch2.set(speed);
	}
	
	public void WinchDown(){
		winch.set(speed);
		winch2.set(-speed);
	}
	
	public void WinchStop(){
		winch.set(0);
		winch2.set(0);
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
