package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveForwardUltraOrHitButton extends Command {
	double distance;
	double speed;
	boolean done;
	Timer timeToDelay;
	public MoveForwardUltraOrHitButton(double distance, double speed){
		super("MoveForwardUltraOrHitButton");
		this.distance = distance;
		this.speed = speed;
		requires(Robot.drivetrain);
		requires(Robot.push);
		timeToDelay = new Timer();
		done = false;
	}
	
	protected void initialize(){
		Robot.drivetrain.resetGyro();
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		Robot.drivetrain.ringLightOn();
		Robot.drivetrain.isGearCam = true;
		Robot.drivetrain.setTurnToTarget(true);
		Robot.drivetrain.setPidGo(true);
		Robot.drivetrain.isTurnOnly = true;
		if(Robot.drivetrain.moveForwardUltraAlign(distance, speed) || !Robot.push.gearButton.get()){
			done = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(done || timeToDelay.get() >= 3){
			return true;
 		}else{
			return false;
		}
	}
	
	protected void end(){
	}
	
	protected void interupted(){
	}

}
