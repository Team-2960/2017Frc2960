package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {

	double shootSpeed;
	
	public ShootCommand(double shootSpeed){
		super("ShootCommand");
		this.shootSpeed = shootSpeed;
		requires(Robot.shoot);
		requires(Robot.agi);
		requires(Robot.intake);
	}
	
	protected void initialize(){
		Robot.shoot.setSetpoint(shootSpeed);
		Robot.shoot.startPID();
		Robot.shoot.turnONOFF(true);
	}
	
	protected void execute(){
		Robot.agi.startAgitatorReversed();
		Robot.intake.startIntake();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end(){
		Robot.shoot.stopPID();
		Robot.agi.stopAgitator();
		Robot.intake.stopIntake();
		Robot.shoot.turnONOFF(false);
	}
	
	protected void interupted(){
		Robot.shoot.stopPID();
		Robot.agi.stopAgitator();
		Robot.intake.stopIntake();
		Robot.shoot.turnONOFF(false);
	}

}
