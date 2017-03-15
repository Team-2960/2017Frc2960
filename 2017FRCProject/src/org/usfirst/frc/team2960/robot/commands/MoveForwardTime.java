package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveForwardTime extends Command {

	double time;
	boolean done;
	Timer timeToMove;
	
	public MoveForwardTime(double time){
		super("MoveForwardTime");
		this.time = time;
		requires(Robot.drivetrain);
		timeToMove = new Timer();
		done = false;
	}
	
	protected void initialize(){
		timeToMove.start();
		Robot.drivetrain.isTurnOnly = false;
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		Robot.drivetrain.ringLightOn();
		Robot.drivetrain.isGearCam = true;
		Robot.drivetrain.setTurnToTarget(true);
		Robot.drivetrain.setPidGo(true);
		Robot.drivetrain.isTurnOnly = true;
		Robot.drivetrain.addTurn(-.5, .5);
	}
	
	@Override
	protected boolean isFinished() {
		if(timeToMove.get() >= time){
			return true;
		}else{
			return false;
		}
	}
	
	protected void end(){
		Robot.drivetrain.setSpeed(0, 0);
		timeToMove.stop();
		timeToMove.reset();
	}
	
	protected void interupted(){
	}

}
