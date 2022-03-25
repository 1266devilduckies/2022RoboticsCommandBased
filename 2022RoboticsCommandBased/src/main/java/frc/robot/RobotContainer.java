// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.hardware.input.Controller;
import frc.robot.hardware.limelight.Limelight;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.CmdExtendRunIntake;
import frc.robot.commands.CmdPewPewStart;
import frc.robot.commands.CmdRetractIntake;
import frc.robot.commands.CmdReverseIntake;
import frc.robot.commands.CmdSlowShot;
import frc.robot.commands.WorseKearnyDriving;
//import frc.robot.subsystems.ShooterSubsystem;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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
    
    // PILOT CONTROLLER
    setButtonHeldBehavior(pilotController, 6, new CmdExtendRunIntake(m_intake), new CmdRetractIntake(m_intake));
		//setButtonHeldBehavior(joystick, 2, new AlignToTarget(), null);

		// this changes the direction of the intake motor while it is being held
		// it does not start it but rather it changes the polarity of the motor
		setPOVButtonBehavior(pilotController, 0, new CmdReverseIntake(m_intake), null);
    
    // COPILOT CONTROLLER
    // goes for low ball shot
		setButtonHeldBehavior(coPilotController, 5, new CmdSlowShot(m_shooter), null);
		// goes for high ball shot
		setButtonHeldBehavior(coPilotController, 6, new CmdPewPewStart(m_shooter), null);
		//setButtonPressBehavior(joystick, 2, new Climbstart());

  }

  private static void setButtonHeldBehavior(final Controller controller, final int buttonNumber,
			final CommandBase whileHeldCommand, final CommandBase whenReleasedCommand) {
		final Button button = new JoystickButton(
				controller.getJoystick(), buttonNumber);
		if (whileHeldCommand != null) {
			button.whileHeld(whileHeldCommand);
		}
		if (whenReleasedCommand != null) {
			button.whenReleased(whenReleasedCommand);
		}
	}

  private static void setPOVButtonBehavior(final Controller controller, final int angle,
			final CommandBase whileHeldCommand, final CommandBase whenReleasedCommand) {
		final POVButton povButton = new POVButton(controller.getJoystick(), angle);
		if (whileHeldCommand != null) {
			povButton.whileHeld(whileHeldCommand);
		}
		if (whenReleasedCommand != null) {
			povButton.whenReleased(whenReleasedCommand);
		}
	}

  private static void setButtonPressBehavior(final Controller controller, final int buttonNumber,
			final CommandBase whenPressedCommand) {
		final Button button = new JoystickButton(
				controller.getJoystick(), buttonNumber);
		if (whenPressedCommand != null) {
			button.whenPressed(whenPressedCommand);
		}
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
