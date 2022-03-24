package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;


public class CmdClimbStart extends CommandBase {
  // The subsystem the command runs on
  private final ClimberSubsystem m_climbSubsystem;

  public CmdClimbStart(ClimberSubsystem subsystem) {
    m_climbSubsystem = subsystem;
    addRequirements(m_climbSubsystem);
  }

  @Override
  public void initialize() {
    m_climbSubsystem.bothExtend();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}