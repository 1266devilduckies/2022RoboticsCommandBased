package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class CmdRetractIntake extends CommandBase {
  // The subsystem the command runs on
  private final IntakeSubsystem m_IntakeSubsystem;

  public CmdRetractIntake(IntakeSubsystem subsystem) {
    m_IntakeSubsystem = subsystem;
    addRequirements(m_IntakeSubsystem);
  }

  @Override
  public void initialize() {
    m_IntakeSubsystem.intakeStopRetract();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}