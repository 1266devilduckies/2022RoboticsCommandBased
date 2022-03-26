package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class CmdPewPewStart extends CommandBase {
  // The subsystem the command runs on
  private final ShooterSubsystem m_ShooterSubsystem;

  public CmdPewPewStart(ShooterSubsystem subsystem) {
    m_ShooterSubsystem = subsystem;
    addRequirements(m_ShooterSubsystem);
  }

  @Override
  public void initialize() {
    ShooterSubsystem.inFiringCoroutine = true;
    m_ShooterSubsystem.setHighShot();
    m_ShooterSubsystem.setStartTime();
  }

  public void execute(){
    m_ShooterSubsystem.pewPewStart();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return !ShooterSubsystem.inFiringCoroutine;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    ShooterSubsystem.feederMotor1.set(ControlMode.Velocity, 0);
    ShooterSubsystem.shooterMotor1.set(ControlMode.Velocity, 0);
  }

}// class cmdPewPewStart