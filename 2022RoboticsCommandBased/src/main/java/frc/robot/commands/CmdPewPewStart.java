package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class CmdPewPewStart extends CommandBase {
  // The subsystem the command runs on
  private final Subsystem m_ShooterSubsystem;

  public CmdPewPewStart(ShooterSubsystem subsystem) {
    m_ShooterSubsystem = subsystem;
    addRequirements(m_ShooterSubsystem);
  }

  @Override
  public void initialize() {
    ((ShooterSubsystem) m_ShooterSubsystem).PewPewStart();//? maybe causing it to fail
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}