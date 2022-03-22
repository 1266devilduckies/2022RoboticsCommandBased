// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  
  private static DriveTrainSubsystem instance;
  
  /** Creates a new DriverTrain Subsystem. */
  public DriveTrainSubsystem() {}

  //all possible drivetrain function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static synchronized DriveTrainSubsystem getInstance() {
    if (instance == null) {
      instance = new DriveTrainSubsystem();
    }
    return instance;
  }
}
