// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.encoder.EncoderSetter;

public class IntakeSubsystem extends SubsystemBase {
  
  private static IntakeSubsystem instance;
  private VictorSPX intakeMotor;
  private Solenoid intakeSolenoid;
  private Compressor pcmCompressor;

  //private long timeSinceStartedBeingReleasedForSolenoids = -1;
    
  /** Creates a new Intake Subsystem. */
  public IntakeSubsystem() {

    intakeMotor = new VictorSPX(9);
    intakeMotor.setInverted(false);
    pcmCompressor = new Compressor(10, PneumaticsModuleType.CTREPCM);
    pcmCompressor.enableDigital();

    EncoderSetter.setEncoderDefaultPhoenixSettings(intakeMotor);

  }

  //all possible intake function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeStartExtend(){
    intakeSolenoid.set(true);
    intakeMotor.set(VictorSPXControlMode.PercentOutput,1.0);
  }
  public void intakeStopRetract(){
    intakeMotor.set(VictorSPXControlMode.PercentOutput, 0.0);
    intakeSolenoid.set(false);
  }
  public void intakeExtend(){
    intakeSolenoid.set(true);
  }
  public void intakeReverse(){
    intakeMotor.set(VictorSPXControlMode.PercentOutput, -1.0);
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
