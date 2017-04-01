package org.usfirst.frc.team2960.robot.subsystems;

import java.util.Arrays;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.Robot;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements PeriodicUpdate  {
	
	CANTalon rt1;
	CANTalon rt2;
	CANTalon rt3;
	CANTalon lt1;
	CANTalon lt2;
	CANTalon lt3;
	
	DoubleSolenoid shiftSol;
	AnalogGyro gyro;
	PIDController turning;
	PIDController moveing;
	TurnControl turn;
	DriveTrainInputPID moveingInput;
	DriveTrainOutputPID moveingOutput;
	Camera BoilerCam;
	Camera GearCam;
	double pixelsFromEdge = 0.0;
	double pixelsFromEdgeBoiler = 0.0;
	double speedStart;
	public boolean OnOff;
	double awayFromTarget;
	double direction;
	private boolean pidGo;
	double pidOIRight = 0;
	double pidOILeft = 0;
	public boolean isGearCam = true;
	double centerOfCam;
	double distanceForMovement;
	double gotTodirection;
	public boolean autonTurnDone = false;
	Relay ringLight;
	public boolean isAutonOnGear = false;
	public boolean isTurnOnly = true;
	public boolean autonTurn = false;
	Ultrasonic ultra;
	double lastVal[] = {0,0,0,0,0};
	public DriveTrain(){
		ultra = new Ultrasonic(6,7);
		//Talons
		rt1 = new CANTalon(RobotMap.rt1);
		rt2 = new CANTalon(RobotMap.rt2);
		rt3 = new CANTalon(RobotMap.rt3);
		lt1 = new CANTalon(RobotMap.lt1);
		lt2 = new CANTalon(RobotMap.lt2);
		lt3 = new CANTalon(RobotMap.lt3);
		//Camera
		BoilerCam = new Camera(0);
		GearCam = new Camera(1);
		//solenoids
		shiftSol = new DoubleSolenoid(RobotMap.shift, RobotMap.shift2);
		//sensors
		gyro = new AnalogGyro(RobotMap.Gyro);
		//PID
		moveingInput = new DriveTrainInputPID(this);
		moveingOutput = new DriveTrainOutputPID(this);
		turn = new TurnControl(this);
		turning = new PIDController(RobotMap.p1, RobotMap.i1, RobotMap.d1, gyro, turn);
		moveing = new PIDController(RobotMap.p3, RobotMap.i3, RobotMap.d3, moveingInput, moveingOutput);
		gyro.setPIDSourceType(PIDSourceType.kRate);
		gyro.calibrate();
		moveingInput.setPIDSourceType(PIDSourceType.kRate);
		speedStart = 40;
		ringLight = new Relay(RobotMap.ringLight);
		//lights = new Lights();
	}
	public void setSpeed(double right, double left){
		
		rt1.set(right); 
		rt2.set(-right);
		rt3.set(-right);
		lt1.set(left);
		lt2.set(-left);
		lt3.set(-left);
		 
	}
	public void shift(boolean val){
		if(!val){
			shiftSol.set(Value.kReverse);
			SmartDashboard.putString("Is in high gear", "False");
		}
		else{
			shiftSol.set(Value.kForward);
			SmartDashboard.putString("Is in high gear", "True");
		}
		
	}
	
	  public void startPID(){
		 
		  turning.enable();
	  }
	  
	  public void addTurn(double right, double left){
		  SmartDashboard.putNumber("Right movement PID", right);
		  SmartDashboard.putNumber("Left movement PID", left);
		  setSpeed(right + pidOIRight, left + pidOILeft);
	  }
	  
	  public void ringLightOn(){
			ringLight.set(Relay.Value.kForward);
		}
		public void ringLightOff(){
			ringLight.set(Relay.Value.kOff);
		}
	  public void setSetpoint(double setpoint){
		  turning.setSetpoint(setpoint);
	  }
	  
	  public void stopPID(){
		  if(turning.isEnabled()){
			  turning.disable();
			  pidOIRight = 0;
			  pidOILeft = 0;
		  }
	  }
	  public void startEncPID(){
		  moveing.enable();
	  }
	  public void stopEncPID(){
		  if(moveing.isEnabled()){
			  moveing.disable();
		  }
	  }
	  public void setEncSetpoint(double setpoint){
		  moveing.setSetpoint(setpoint);
	  }
	  public double getGyro(){
	    return gyro.getRate();
	  }

	  public void resetGyro(){
	    gyro.reset();
	  }
	  
	  public double getUltraDist(){
		  if(ultra.isRangeValid())
			  return ultra.getRangeInches();
		  else
			  return 0;
	  }
	  public boolean moveForwardUltra(double distance, double speed){
		double away = Math.abs(distance - getUltraDist());
		double direction;
		if(distance > getUltraDist()){
			direction = 1; 
		}else{
			direction = -1;
		}
		
		if(away >= 40){
			setSpeed((speed) * direction, -((speed) * direction));
		}else if (away < 40 && away > 20){
			setSpeed((speed * .75) * direction, -((speed * .75) * direction));
		}else if(away < 20 && away > 10){
			setSpeed((speed * .5) * direction, -((speed * .5) * direction));
		}else if(away < 10 && away > 1){
			setSpeed((speed * .25) * direction,-((speed * .25) * direction));
		}else if (away <= 1){
			setSpeed(0,0);
			return true;
		}
		return false;
	  }
	  public boolean moveForwardUltraAlign(double distance, double speed){
			double away = Math.abs(distance - getUltraDist());
			double direction;
			if(distance > getUltraDist()){
				direction = 1; 
			}else{
				direction = -1;
			}
			
			if(away >= 30){
				addTurn((speed) * direction, -((speed) * direction));
			}else if (away < 30 && away > 20){
				addTurn((speed * .75) * direction, -((speed * .75) * direction));
			}else if(away < 20 && away > 10){
				addTurn((speed * .5) * direction, -((speed * .5) * direction));
			}else if(away < 10 && away > 1){
				addTurn((speed * .25) * direction,-((speed * .25) * direction));
			}else if (away <= 1){
				setSpeed(0,0);
				return true;
			}
			return false;
		  }
	  
	  public void setTurnToTarget(boolean OnOff){
		  this.OnOff = OnOff;
	  }
	  
	  
	  public void resetEncoder(){
		  rt1.setPosition(0);
		  lt1.setPosition(0); 
	  }
	  public void setDistance(double distance){
		  rt1.setPosition(0);
		  lt1.setPosition(0);
		  if(distance > 0){
			  gotTodirection = 1;
		  }
		  else{
			  gotTodirection = -1;
		  }
		  this.distanceForMovement = Math.abs(distance);
		  
	  }
	  
	  
	  public double PerInch(double input){
		  return ((input / 8192) * Math.PI * 4);
	  }
	  
	  
	  public boolean gotToDistance(){
		  //double awayFromDist = distanceForMovement - (((PerInch(lt1.getPosition()) /*- PerInch(rt1.getPosition())) / 2*/) * gotTodirection);
		  double awayFromDist = distanceForMovement - (PerInch(lt1.getPosition()) * gotTodirection);
		  SmartDashboard.putNumber("Encoder 1", rt1.getPosition());
		  SmartDashboard.putNumber("Encoder 2", lt1.getPosition());
		  SmartDashboard.putNumber("awayFromDist", awayFromDist);
		  SmartDashboard.putNumber("Enc setpoint", moveing.getSetpoint());
		  SmartDashboard.putBoolean("is enc pid enabled", moveing.isEnabled());
		  if(awayFromDist >= 20){
			  setEncSetpoint(2500 * gotTodirection);
		  }
		  else if(awayFromDist < 20 && awayFromDist > 10){
			  setEncSetpoint(1500 * gotTodirection);
		  }
		  else if(awayFromDist < 10 && awayFromDist > 1){
			  setEncSetpoint(1000 * gotTodirection);
		  }
		  else if(awayFromDist <= 1){
			  stopEncPID();
			  return true;
		  }
		  if(!moveing.isEnabled()){
			  startEncPID();
		  }
		  
		  return false;
	  }
	  
	  public void turnToTarget(){
		 
		 SmartDashboard.putNumber("pixels from edge", pixelsFromEdge);
		  if(pixelsFromEdge > centerOfCam){
				 awayFromTarget = pixelsFromEdge - centerOfCam;
				 direction = 1;
			 }
			else{
				 awayFromTarget = centerOfCam - pixelsFromEdge;
				 direction = -1;
			 }
			 if(awayFromTarget > 150)
				 setSetpoint(speedStart * direction);
			 else if(awayFromTarget < 150 && awayFromTarget > 100)
				 setSetpoint((speedStart - 15) * direction);
			 else if(awayFromTarget < 100 && awayFromTarget > 8)
				 setSetpoint((speedStart - 25) * direction);
			 else if(awayFromTarget <= 8){
				 //lights.setLights(1, 0, 0);
				 setSetpoint(0);
				 autonTurnDone = true;
			 }
			 if(GearCam.getYTotal() <= 50){
				 if(isGearCam){
				 setPidGo(false);
				 OnOff = false;
				 }
			 }
			 else if(!turning.isEnabled()){
				 startPID();
				 if(isGearCam){
					 //ringLightOn();
				 }
			 }
	  }
	  public boolean closeToTarget(){
		  boolean isInRange = false;
		  if(BoilerCam.getYTotal() > 140 && BoilerCam.getYTotal() < 160){
			  //lights.setLights(1, 1, 1);
			  isInRange = true;
		  }
		  return isInRange;
	  }
		  
	@Override
	public void update() {
		
		if(GearCam.getYTotal() <= 50){
			 if(isGearCam){
				 isAutonOnGear = true;
			 }
		}
		
		
		
		GearCam.update();
		BoilerCam.update();
		
		SmartDashboard.putNumber("BoilerCam box number", BoilerCam.amount);
		SmartDashboard.putNumber("GearCam box number", GearCam.amount);
		SmartDashboard.putNumber("Gyro Rate", getGyro());
		
		SmartDashboard.putNumber("Encoder 1 Velocity", rt1.getEncVelocity());
		
		SmartDashboard.putNumber("Encoder 2 Velocity", lt1.getEncVelocity());
		
		SmartDashboard.putNumber("Ultra in inches", ultra.getRangeInches());
		//SmartDashboard.putNumber("Ultra in inches test", getUltraDist());
		
		//SmartDashboard.putNumber("Right movement", pidOIRight);
		//SmartDashboard.putNumber("Left movement", pidOILeft);
		
		//SmartDashboard.putNumber("Pixels from edge", pixelsFromEdge);
		
		SmartDashboard.putNumber("Setpoint", turning.getSetpoint());
		SmartDashboard.putBoolean("PID ENABlEd", turning.isEnabled());
		//SmartDashboard.putNumber("Y total", cam2.yTotal);
		
		//SmartDashboard.putBoolean("IS THE ENC PID ON", moveing.isEnabled());
		//SmartDashboard.putNumber("PID ENC SETPOINT", moveing.getSetpoint());
		
		//SmartDashboard.putNumber("ENC PID GET", moveingInput.pidGet());
		//SmartDashboard.putNumber("AVG ERORR!!!!!",moveing.getAvgError());
		
		//SmartDashboard.putBoolean("Is it in boiler range", closeToTarget());
		
		//SmartDashboard.putNumber("The encoder divided", (double)((getRightEncoder() + getLeftEncoder())/2));
		
		//SmartDashboard.putNumber("P!!!!!!!!!!!!!!!", moveing.getP());
		//SmartDashboard.putNumber("I!!!!!!!!!!!!!!!", moveing.getI());
		//SmartDashboard.putNumber("D!!!!!!!!!!!!!!!", moveing.getD());
		
		if(OnOff)
			turnToTarget();
		
		else if (!OnOff && !autonTurn){
			if(turning.isEnabled())
				 stopPID();
		}
		if (isGearCam){
			pixelsFromEdge = GearCam.getPixelsFromEdge();
			centerOfCam = 160;
		}
		else if (!isGearCam){
			//SmartDashboard.putString("roor", "Tiger");
			pixelsFromEdge = BoilerCam.GetPixelsFromEdgeBoiler();
			centerOfCam = 160;
		}
		
	}

	
	public void runPidOI(double right, double left){
		pidOIRight = right;
		pidOILeft = left;
	}
	
	public double getRightEncoder(){
		return -rt1.getEncVelocity();
	}
	public double getLeftEncoder(){
		return lt1.getEncVelocity();
	}
	
	
	@Override
	public void start() {
		ultra.setEnabled(true);
		ultra.setAutomaticMode(true);
		turning.disable();
		moveing.disable();
		this.resetGyro();
		rt1.setPosition(0);
		lt1.setPosition(0);
		pidOIRight = 0;
		pidOILeft = 0;
		isTurnOnly = false;
		
	}	
	
	@Override
	protected void initDefaultCommand() {
		rt1.set(0);
		rt2.set(0);
		rt3.set(0);
		lt1.set(0);
		lt2.set(0);
		lt3.set(0);
	}
	public boolean isPidGo() {
		return pidGo;
	}
	public void setPidGo(boolean pidGo) {
		this.pidGo = pidGo;
	}

}
