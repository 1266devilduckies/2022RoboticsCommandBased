// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Ports;
import frc.robot.hardware.encoder.EncoderSetter;

public class ClimberSubsystem extends SubsystemBase {
  
  private static ClimberSubsystem instance;
  private WPI_TalonFX climberMotor1 = new WPI_TalonFX(Ports.MOTOR_CLIMBER_1);
  private WPI_TalonFX climberMotor2 = new WPI_TalonFX(Ports.MOTOR_CLIMBER_2);

  
  /** Creates a new Climber Subsystem. */
  public ClimberSubsystem() {

    climberMotor2.setInverted(true);
    climberMotor2.set(ControlMode.Follower, 10);

    EncoderSetter.setEncoderDefaultPhoenixSettings(climberMotor1);
    EncoderSetter.setEncoderDefaultPhoenixSettings(climberMotor2);

  }
  
  //all possible climber function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void bothExtend() {
    climberMotor1.set(ControlMode.PercentOutput,1.0);
  }
   public void bothStop(){
    climberMotor1.set(ControlMode.PercentOutput, 0.0);
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
