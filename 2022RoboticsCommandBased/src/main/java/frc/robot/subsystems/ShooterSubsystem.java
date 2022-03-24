// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.hardware.encoder.EncoderSetter;

public class ShooterSubsystem extends SubsystemBase {
  
  private static ShooterSubsystem instance;
  public static WPI_TalonFX shooterMotor1 = new WPI_TalonFX(8);
  public WPI_TalonFX shooterMotor2 = new WPI_TalonFX(7);
  public static WPI_TalonFX feederMotor1 = new WPI_TalonFX(6);

  public static boolean inFiringCoroutine;
  private long timeSinceStartedBeingReleasedForShooter = -1;
  public static boolean fullShooterPower = true;
  private double velocity;
  
  /** Creates a new Shooter Subsystem. */
  public ShooterSubsystem() {

    shooterMotor2.setInverted(true);
    shooterMotor2.set(ControlMode.Follower, 8);

    EncoderSetter.setEncoderDefaultPhoenixSettings(shooterMotor1);
    EncoderSetter.setEncoderDefaultPhoenixSettings(shooterMotor2);
    EncoderSetter.setEncoderDefaultPhoenixSettings(feederMotor1);

    shooterMotor1.config_kF(0, ShooterConstants.SHOOTER_kF);
    shooterMotor1.config_kP(0, ShooterConstants.SHOOTER_kP);
    shooterMotor2.config_kF(0, ShooterConstants.SHOOTER_kF);
    shooterMotor2.config_kP(0, ShooterConstants.SHOOTER_kP);
    shooterMotor2.config_kD(0, ShooterConstants.SHOOTER_kD);
    shooterMotor1.config_kD(0, ShooterConstants.SHOOTER_kD);
    feederMotor1.config_kF(0, ShooterConstants.SHOOTER_kFIndex);
    feederMotor1.config_kP(0, ShooterConstants.SHOOTER_kPIndex);

    velocity = fullShooterPower ? ShooterConstants.FEEDER_VELOCITY_TARGET : ShooterConstants.SHOOTER_VELOCITY_TARGET / 2.0;
    

  }

  //all possible drivetrain function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void pewPewStart(){
    long dt = System.currentTimeMillis() - timeSinceStartedBeingReleasedForShooter;
    // delay is measured in milliseconds
    if (dt >= 4500) {
      inFiringCoroutine = false;
    } else if (dt >= 3000) {
      feederMotor1.set(ControlMode.Velocity, ShooterConstants.FEEDER_VELOCITY_TARGET);
    } else if (dt >= 2000) {
      feederMotor1.set(ControlMode.Velocity, 0);
    } else if (dt >= 1550) {
      feederMotor1.set(ControlMode.Velocity, ShooterConstants.FEEDER_VELOCITY_TARGET);
    } else {
      shooterMotor1.set(ControlMode.Velocity, velocity);
    }
  }
  public void SlowShot(){
    fullShooterPower = false;
  }

  public void setStartTime(){
    timeSinceStartedBeingReleasedForShooter = System.currentTimeMillis();
  }

    @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  /**
   * This method insures that only one instance of a Subsystem can be accessed
   * 
   * @return class instance
   */
  public static synchronized ShooterSubsystem getInstance() {
    if (instance == null) {
      instance = new ShooterSubsystem();
    }
    return instance;
  }

}