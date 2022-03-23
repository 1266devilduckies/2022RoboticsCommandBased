package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

/** An example command that uses an example subsystem. */
public class WorseKearnyDriving extends CommandBase {

  private final DriveTrainSubsystem m_drivetrain;
  private final DoubleSupplier m_xSpeed;
  private final DoubleSupplier m_spinSpeed;

  public WorseKearnyDriving(DriveTrainSubsystem subsystem, DoubleSupplier xSpeed, DoubleSupplier spinSpeed) {
    m_drivetrain = subsystem;
    m_xSpeed = xSpeed;
    m_spinSpeed = spinSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  public void execute(){

    double xSpeed = m_xSpeed.getAsDouble();
    double spinSpeed = m_spinSpeed.getAsDouble();

    //have robot turn in place if not moving forward
    boolean inPlaceTurn = false;
    if(Math.abs(xSpeed) < 0.05) inPlaceTurn = true;

    m_drivetrain.curvatureDrive(xSpeed, spinSpeed, inPlaceTurn);

  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }
    
  @Override
  public boolean isFinished() {
    return false;
  }
}