package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearPusher extends Subsystem implements PeriodicUpdate {

	DoubleSolenoid GearPusher;
	DoubleSolenoid Flap;
	Relay ringLight;
	DigitalInput gearButton;
	DigitalInput gearSensor;
	boolean autoGearPush = true;
	boolean pushButtonTripped = false;
	boolean timerStarted = false;
	Timer pusherDelay;
	
	public GearPusher(){
		GearPusher = new DoubleSolenoid(RobotMap.gearPusher, RobotMap.gearPusher2);
		Flap = new DoubleSolenoid(RobotMap.flap, RobotMap.flap2);
		ringLight = new Relay(RobotMap.ringLight);
		gearButton = new DigitalInput(RobotMap.GearPushButton);
		gearSensor = new DigitalInput(RobotMap.GearSensor);
		pusherDelay = new Timer();
	}
	
	public void turnOn(){
		GearPusher.set(Value.kForward);
	}
	public void turnOff(){
		if(gearButton.get() && !timerStarted || !autoGearPush )
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
	public void autoPush(){
		if(!gearButton.get()){
			turnOn();
			pushButtonTripped = true;
			timerStarted = true;
		}
		else if (gearButton.get() && pushButtonTripped){
			pusherDelay.start();
			pusherDelay.reset();
			pushButtonTripped = false;
			
						
		}
		else if(pusherDelay.get() > RobotMap.gearPushTime && !pushButtonTripped){
			timerStarted = false;
			turnOff();
			pusherDelay.stop();
			
		}
			
	}
	public void setAutoGearPush(boolean On){
		autoGearPush = On;
	}
	@Override
	public void update() {
		SmartDashboard.putBoolean("Gear Button", gearButton.get());
		SmartDashboard.putBoolean("Gear Sensor", gearSensor.get());
		if(autoGearPush)
			autoPush();
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
