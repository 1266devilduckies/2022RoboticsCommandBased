package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class CmdExtendRunIntake extends CommandBase {
  // The subsystem the command runs on
  private final Subsystem m_IntakeSubsystem;

  public CmdExtendRunIntake(IntakeSubsystem subsystem) {
    m_IntakeSubsystem = subsystem;
    addRequirements(m_IntakeSubsystem);
  }

  @Override
  public void initialize() {
    ((IntakeSubsystem) m_IntakeSubsystem).IntakeStart();//? maybe causing it to fail
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}