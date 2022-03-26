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
    ShooterSubsystem.inFiringCoroutine = true;
    m_ShooterSubsystem.setSlowShot();
    m_ShooterSubsystem.setStartTime();
  }

  @Override
  public void execute() {
    m_ShooterSubsystem.pewPewStart();
  }

  @Override
  public boolean isFinished() {
    return !ShooterSubsystem.inFiringCoroutine;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_ShooterSubsystem.stop();
  }
}