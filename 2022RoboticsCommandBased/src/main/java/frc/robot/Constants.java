// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.math.controller.PIDController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static double velocity = 0.0;
    public static double avgPositionRaw;
    public static double avgPositionInMeters;
    public static boolean inFiringCoroutine;
    public static long timeSinceStartedBeingReleasedForShooter = -1;
    public static long timeSinceStartedBeingReleasedForSolenoids = -1;
    public static ADXRS450_Gyro gyro;
    public static Compressor pcmCompressor;
    public static boolean isAligningCoroutine = false;
    public static boolean fullShooterPower = true;
    public static boolean inAutonomous = false;
    public static double angle = 0.0;// angle for robot to align to when in aligining command
    public static boolean angleMode = false; // false means to target to the limelight
    // The robot's drive
   
    /*
     * to change the kF go in phoenix tuner > control > percent output
     * fiddle with it until when you click self test snapshot the velocity is close
     * to the thing you want
     * then convert the percent from self test snapshot to decimal and put that as
     * the first multiple in front of 1023.0.
     * set the velocity from self test snapshot into the velocityTarget variable
     */
    public static double velocityTarget = 13250.0;// 14000.0;
    public static double velocityFeeder = 13250.0;
    public static double kF = 0.045;// .0455
    public static double kP = 0.02; // .02
    public static double kFIndex = 0.045;
    public static double kPIndex = 0.02;
    public static double kPAligner = 0.04;
    public static double kDAligner = 0.0;
    public static PIDController alignerController = new PIDController(kPAligner, 0.0, kDAligner);
    public static double kF2 = (0.6343 * 1023.0) / velocityTarget;
    public static double kP2 = 0.0299999714;
    public static double kI2 = 9.98973846E-05;
    public static double kD2 = 0.03999996;
    public static int numOfTogglesOnSolenoids = 0;
    public static boolean reachedGoal = false;
    public static boolean turnedaround = false;
    public static boolean shotFirstShotInAuto = false;
    public static double tankDriveInPlaceError = 0.0;
    public static int climberDelay = 1000;
   
  
    public static final double ksVolts = 0.67766;
    public static final double kvVoltSecondsPerMeter = 2.2804;
    public static final double kaVoltSecondsSquaredPerMeter = 0.6814;
  
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kPDriveVel = 3.473;
  
    // Reasonable baseline values for a RAMSETE follower in units of meters and
    // seconds
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;
  
    public static final double kTrackwidthMeters = 0.762;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
        kTrackwidthMeters);
  
    public static final int kEncoderCPR = 2048;
    public static final double kWheelDiameterMeters = 0.1524;
    public static final double kEncoderDistancePerPulse = (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;
  

    public static class ExampleConstants {

        public static final double EXAMPLE_DOUBLE = 0.5;
        public static final int EXAMPLE_INTEGER = 5;

    }

    public static class DriveConstants {

        // Constants related to Drive/Ramsete/DifferentialDrive

    }

    public static class ClimberConstants {

        // Constants related to Climber

    }

    public static class ShooterConstants {

        // Constants related to Shooter

    }

    public static class IntakeConstants {

        // Constants related to Intake

    } 

    public static class VisionConstants {

        // Constants related to Vision/Limelight

    }

}
