// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.hardware.input.Controller;
import frc.robot.hardware.limelight.Limelight;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.WorseKearnyDriving;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private ClimberSubsystem m_climber;
  private DriveTrainSubsystem m_drivetrain;
  private IntakeSubsystem m_intake;
  private ShooterSubsystem m_shooter;

  private Controller pilotController;
  private Controller coPilotController;

  private CommandScheduler m_commandScheduler = CommandScheduler.getInstance();

  private Limelight m_limelight;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Instantiate subsystems
    m_climber = ClimberSubsystem.getInstance();
    m_drivetrain = DriveTrainSubsystem.getInstance();
    m_intake = IntakeSubsystem.getInstance();
    m_shooter = ShooterSubsystem.getInstance();

    pilotController = new Controller(0);
    coPilotController = new Controller(1);

    m_limelight = new Limelight();

    m_commandScheduler.setDefaultCommand(m_drivetrain, 
        new WorseKearnyDriving(m_drivetrain, pilotController::getLeftStickY, pilotController::getRightStickX));
    

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
