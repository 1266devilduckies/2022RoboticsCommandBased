// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  
  private static ShooterSubsystem instance;
  private TalonFX m_Shooter1, m_shooter2, m_Feeder1;
  
  /** Creates a new Shooter Subsystem. */
  public ShooterSubsystem() {}

  //all possible drivetrain function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void ConfigMotors(){
    m_Shooter1 = new TalonFX(8);
    m_shooter2 = new TalonFX(7);
    m_Feeder1 = new TalonFX(6);
    m_shooter2.setInverted(true);
    m_shooter2.set(ControlMode.Follower, 8);
    }
  public void PewPewStart(){
    long dt = System.currentTimeMillis() - Constants.timeSinceStartedBeingReleasedForShooter;
    // delay is measured in milliseconds
    if (dt >= 4500) {
      Constants.inFiringCoroutine = false;
    } else if (dt >= 3000) {
      m_Feeder1.set(ControlMode.Velocity, Constants.velocityFeeder);
    } else if (dt >= 2000) {
      m_Feeder1.set(ControlMode.Velocity, 0);
    } else if (dt >= 1550) {
      m_Feeder1.set(ControlMode.Velocity, Constants.velocityFeeder);
    } else {
      m_Shooter1.set(ControlMode.Velocity, Constants.velocity);
    }
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

  public void bothExtend() {
  }
}
