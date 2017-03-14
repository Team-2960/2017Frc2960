package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForwardUltraOrHitButton extends Command {
	double distance;
	double speed;
	boolean done;
	public MoveForwardUltraOrHitButton(double distance, double speed){
		super("MoveForwardUltraOrHitButton");
		this.distance = distance;
		this.speed = speed;
		requires(Robot.drivetrain);
		requires(Robot.push);
		done = false;
	}
	
	protected void initialize(){
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		if(Robot.drivetrain.moveForwardUltra(distance, speed) || !Robot.push.gearButton.get()){
			done = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(done){
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
