package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForwardOrHitButton extends Command {

	double distance;
	boolean done;
	public MoveForwardOrHitButton(double distance){
		super("MoveForwardOrHitButton");
		this.distance = distance;
		requires(Robot.drivetrain);
		requires(Robot.push);
		done = false;
	}
	protected void initialize(){
		Robot.drivetrain.setDistance(distance);
		Robot.drivetrain.isTurnOnly = false;
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		if(Robot.drivetrain.gotToDistance() || !Robot.push.gearButton.get()){
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
