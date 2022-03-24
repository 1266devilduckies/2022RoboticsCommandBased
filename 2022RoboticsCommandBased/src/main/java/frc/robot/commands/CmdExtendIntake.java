package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class CmdExtendIntake extends CommandBase {
  // The subsystem the command runs on
  private final IntakeSubsystem m_intakSubsystem;

  public CmdExtendIntake(IntakeSubsystem subsystem) {
    m_intakSubsystem = subsystem;
    addRequirements(m_intakSubsystem);
  }

  @Override
  public void initialize() {
    m_intakSubsystem.intakeExtend();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}