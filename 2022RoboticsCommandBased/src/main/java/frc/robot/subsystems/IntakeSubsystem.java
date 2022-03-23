// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  
    private static IntakeSubsystem instance;
    private VictorSPX m_IntakeMotor;
    public Solenoid intakeSolenoid;
    /** Creates a new Intake Subsystem. */
  
  
  /** Creates a new Intake Subsystem. */
  public IntakeSubsystem() {}

  //all possible intake function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS
    public void ConfigMotors(){
    m_IntakeMotor = new VictorSPX(9);
    m_IntakeMotor.setInverted(false);
    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void IntakeStart(){
    intakeSolenoid.set(true);
    m_IntakeMotor.set(VictorSPXControlMode.PercentOutput,1.0);
  }
  public void IntakeStop(){
    m_IntakeMotor.set(VictorSPXControlMode.PercentOutput, 0.0);
    intakeSolenoid.set(false);
  }
  public void shooterNeed(){
    intakeSolenoid.set(true);
  }
  public void AfterShooterNeed(){
    intakeSolenoid.set(false);
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
  public static synchronized IntakeSubsystem getInstance() {
    if (instance == null) {
      instance = new IntakeSubsystem();
    }
    return instance;
  }
}
