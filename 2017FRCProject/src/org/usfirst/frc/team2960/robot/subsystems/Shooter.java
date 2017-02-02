package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements PeriodicUpdate{

	VictorSP shoot;
	double speed = .85;
	boolean canMove = false;
	
	
	public Shooter(){
		//shoot = new CANTalon(RobotMap.shooter);
		shoot = new VictorSP(RobotMap.shooter);
	}
	
	public void turnONOFF(boolean onOff){
		canMove = onOff;
	}
	public void runShooter(){
		if(canMove)
			shoot.set(-speed);
		else
			shoot.set(0);
	}
	
	
	@Override
	public void update() {
		runShooter();
		SmartDashboard.putNumber("Speed of shooter", speed);
		
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
