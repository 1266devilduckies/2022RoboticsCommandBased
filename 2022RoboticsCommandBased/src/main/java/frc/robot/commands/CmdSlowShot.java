package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ShooterSubsystem;


public class CmdSlowShot extends CommandBase {
  // The subsystem the command runs on
  private final ShooterSubsystem m_ShooterSubsystem;

  public CmdSlowShot(ShooterSubsystem subsystem) {
    m_ShooterSubsystem = subsystem;
    addRequirements(m_ShooterSubsystem);
  }

  @Override
  public void initialize() {
    m_ShooterSubsystem.SlowShot();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}