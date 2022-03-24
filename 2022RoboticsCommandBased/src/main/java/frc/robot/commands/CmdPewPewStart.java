package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;


public class CmdPewPewStart extends CommandBase {
  // The subsystem the command runs on
  private final ShooterSubsystem m_shooterSubsystem;

  public CmdPewPewStart(ShooterSubsystem subsystem) {
    m_shooterSubsystem = subsystem;
    addRequirements(m_shooterSubsystem);
  }

  public void initialize(){
    m_shooterSubsystem.setStartTime();
  }

  public void execute(){
    m_shooterSubsystem.pewPewStart();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}