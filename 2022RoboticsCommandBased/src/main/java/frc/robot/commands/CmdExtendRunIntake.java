package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class CmdExtendRunIntake extends CommandBase {
  // The subsystem the command runs on
  private final IntakeSubsystem m_intakeSubsystem;

  public CmdExtendRunIntake(IntakeSubsystem subsystem) {
    m_intakeSubsystem = subsystem;
    addRequirements(m_intakeSubsystem);
  }

  @Override
  public void initialize() {
    m_intakeSubsystem.intakeStartExtend();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}