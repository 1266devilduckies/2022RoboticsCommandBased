package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ClimberSubsystem;


public class CmdClimbStop extends CommandBase {
  // The subsystem the command runs on
  private final Subsystem m_ClimbSubsystem;

  public CmdClimbStop(ClimberSubsystem subsystem) {
    m_ClimbSubsystem = subsystem;
    addRequirements(m_ClimbSubsystem);
  }

  @Override
  public void initialize() {
    ((ClimberSubsystem) m_ClimbSubsystem).bothStop();//? maybe causing it to fail
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}