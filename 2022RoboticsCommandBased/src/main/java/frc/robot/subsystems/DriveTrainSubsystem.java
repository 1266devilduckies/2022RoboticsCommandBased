// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  
  private static DriveTrainSubsystem instance;

  private final DifferentialDrive diffDrive;
  private final DifferentialDriveOdometry diffDriveOdometry;

  private final WPI_TalonFX rightFrontLeader = new WPI_TalonFX(0);
  private final WPI_TalonFX leftFrontLeader = new WPI_TalonFX(1);
  private final WPI_TalonFX rightBackFollower = new WPI_TalonFX(2);
  private final WPI_TalonFX leftBackFollower = new WPI_TalonFX(3);

  private static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  /** Creates a new DriverTrain Subsystem. */
  public DriveTrainSubsystem() {

    leftBackFollower.follow(leftFrontLeader);
    rightBackFollower.follow(rightFrontLeader);

    rightFrontLeader.setInverted(true);
    leftFrontLeader.setInverted(true);
    rightBackFollower.setInverted(false);
    leftBackFollower.setInverted(false);

    diffDrive = new DifferentialDrive(
      new MotorControllerGroup(rightFrontLeader, rightBackFollower), 
      new MotorControllerGroup(leftFrontLeader, leftBackFollower)  
    );

    diffDriveOdometry = new DifferentialDriveOdometry(gyro.getRotation2d());
  }

  //all possible drivetrain function should be defined here
  //DO NOT DEFINE COMMANDS HERE, ONLY SIMPLE FUNCTIONS

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

   /**
     * Returns the currently-estimated pose of the robot.
     *
     * @return The pose.
     */
    public Pose2d getPose() {
      return diffDriveOdometry.getPoseMeters();
  }

  public double getLeftEncoderDistance() {
    //return leftFrontLeader.getSelectedSensorPosition() * DriveConstants.DRIVE_NU_TO_METER;
    return 0;
  }

  public double getRightEncoderDistance() {
    //return rightFrontLeader.getSelectedSensorPosition() * DriveConstants.DRIVE_NU_TO_METER;
    return 0;
  }

  /**
   * Returns the current wheel speeds of the robot.
   *
   * @return The current wheel speeds.
   */
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
      /*return new DifferentialDriveWheelSpeeds(
              getLeftEncoderDistance(),
              getRightEncoderDistance());
      */
      return null;
  }

  /**
   * Resets the odometry to the specified pose.
   *
   * @param pose The pose to which to set the odometry.
   */
  public void resetOdometry(Pose2d pose) {
      resetEncoders();
      diffDriveOdometry.resetPosition(pose, gyro.getRotation2d());
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
      diffDrive.arcadeDrive(fwd, rot);
  }

  /**
   * Drives the robot using curvature controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   * @param inPlace wether or not to turn in place
   */
  public void curvatureDrive(double fwd, double rot, boolean inPlace) {
    diffDrive.curvatureDrive(fwd, rot, inPlace);
  }

  /**
   * Controls the left and right sides of the drive directly with voltages.
   *
   * @param leftVolts  the commanded left output
   * @param rightVolts the commanded right output
   */

  /** Resets the drive encoders to currently read a position of 0. */
  public void resetEncoders() {
      leftFrontLeader.setSelectedSensorPosition(0);
      rightFrontLeader.setSelectedSensorPosition(0);
  }

  /**
   * Gets the average distance of the two encoders.
   *
   * @return the average of the two encoder readings
   */
  public double getAverageEncoderDistance() {
      return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2.0;
  }

  public DifferentialDrive getDifferentialDrive() {
      //.m_driveSim.update(0.001);
      return diffDrive;
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more
   * slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
      diffDrive.setMaxOutput(maxOutput);
  }

  /** Zeroes the heading of the robot. */
  public void zeroHeading() {
      gyro.reset();
  }

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from -180 to 180
   */
  public double getHeading() {
      return gyro.getRotation2d().getDegrees();
  }

  /**
   * Returns the turn rate of the robot.
   *
   * @return The turn rate of the robot, in degrees per second
   */
  public double getTurnRate() {
      return -gyro.getRate();
  }

  public void tankDriveVolts(double leftVolts, double rightVolts) {
      leftFrontLeader.setVoltage(leftVolts);
      rightFrontLeader.setVoltage(rightVolts);
      diffDrive.feed();
  }

  /**
   * This method insures that only one instance of a Subsystem can be accessed
   * 
   * @return class instance
   */
  public static synchronized DriveTrainSubsystem getInstance() {
    if (instance == null) {
      instance = new DriveTrainSubsystem();
    }
    return instance;
  }
  public void stop(){
  rightFrontLeader.set(ControlMode.PercentOutput, 0.0);
  leftFrontLeader.set(ControlMode.PercentOutput, 0.0);
  }
}

