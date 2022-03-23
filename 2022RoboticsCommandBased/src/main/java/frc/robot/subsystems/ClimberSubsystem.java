// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  private TalonFX m_ClimberMotor1, m_ClimberMotor2;
  private static ClimberSubsystem instance;
  
  /** Creates a new Climber Subsystem. */
  public ClimberSubsystem() {}
  
  //all possible climber function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS
  
  public void ConfigMotors(){
  m_ClimberMotor1 = new TalonFX(10);
  m_ClimberMotor2 = new TalonFX(11);
  m_ClimberMotor2.setInverted(true);
  m_ClimberMotor2.set(ControlMode.Follower, 10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void bothExtend() {
   m_ClimberMotor1.set(ControlMode.PercentOutput,1.0);
  }
   public void bothStop(){
    m_ClimberMotor2.set(ControlMode.PercentOutput, 0.0);
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
  public static synchronized ClimberSubsystem getInstance() {
    if (instance == null) {
      instance = new ClimberSubsystem();
    }
    return instance;
  }
}
