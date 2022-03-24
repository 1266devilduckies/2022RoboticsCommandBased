// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
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
    
    /*
     * to change the kF go in phoenix tuner > control > percent output
     * fiddle with it until when you click self test snapshot the velocity is close
     * to the thing you want
     * then convert the percent from self test snapshot to decimal and put that as
     * the first multiple in front of 1023.0.
     * set the velocity from self test snapshot into the velocityTarget variable
     */

    
    public static int numOfTogglesOnSolenoids = 0;
    
  

    public static class ExampleConstants {

        public static final double EXAMPLE_DOUBLE = 0.5;
        public static final int EXAMPLE_INTEGER = 5;

    }

    public static class Ports {

    }

    public static class DriveConstants {

        // Constants related to Drive/Ramsete/DifferentialDrive
        public static final double ALIGNER_kP = 0.04;
        public static final double ALIGHER_kD = 0.0;
        public static PIDController alignerController = new PIDController(ALIGNER_kP, 0.0, ALIGHER_kD);

        public static final double DRIVE_ks_VOLTS = 0.67766;
        public static final double DRIVE_kv_VOLT_SECONDS_PER_METER = 2.2804;
        public static final double DRIVE_ka_VOLT_SECONDS_SQUARED_PER_METER = 0.6814;
    
        public static final double DRIVE_k_MAX_SPEED_METERS_PER_SECOND = 3;
        public static final double DRIVE_K_MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3;
        public static final double DRIVE_kP_DRIVE_VELOCITY = 3.473;
    
        // Reasonable baseline values for a RAMSETE follower in units of meters and
        // seconds
        public static final double RAMSETE_k_B = 2;
        public static final double RAMSETE_k_Zeta = 0.7;
    
        public static final double DRIVE_k_TRACK_WIDTH_METERS = 0.762;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
            DRIVE_k_TRACK_WIDTH_METERS);
    
        public static final int DRIVE_ENCODER_CPR = 2048;
        public static final double DRIVE_WHEEL_DIAMETER_METERS = 0.0508;
        public static final double DRIVE_ENCODER_DISTANCE_PER_PULSE = (DRIVE_WHEEL_DIAMETER_METERS * Math.PI) / (double) DRIVE_ENCODER_CPR;

        public static final double DRIVE_GEAR = 8.333;
        public static final double FALCON_ENCODER_RESOLUTION = 2048.0;

        public static final double ENCODER_DISTANCE_PER_MARK = DRIVE_WHEEL_DIAMETER_METERS * 2 * Math.PI / FALCON_ENCODER_RESOLUTION;
        public static final double DRIVE_NU_TO_METER = ENCODER_DISTANCE_PER_MARK / DRIVE_GEAR; // conversion tool

    }

    public static class ClimberConstants {

        // Constants related to Climber
        public static int CLIMBER_DELAY = 1000;

    }

    public static class ShooterConstants {

        // Constants related to Shooter
        public static final double SHOOTER_VELOCITY_TARGET = 13250.0;// 14000.0;
        public static double FEEDER_VELOCITY_TARGET = 13250.0;

        public static final double SHOOTER_kF = 0.045;// .0455
        public static final double SHOOTER_kP = 0.02; // .02
        public static final double SHOOTER_kFIndex = 0.045;
        public static final double SHOOTER_kPIndex = 0.02;
        public static final double SHOOTER_kD = 0.01;

        public static final double SHOOTER_kF_2 = (0.6343 * 1023.0) / SHOOTER_VELOCITY_TARGET;
        public static final double SHOOTER_kP_2 = 0.0299999714;
        public static final double SHOOTER_kI_2 = 9.98973846E-05;
        public static final double SHOOTER_kD_2 = 0.03999996;

    }

    public static class IntakeConstants {

        // Constants related to Intake
   
    } 

    public static class VisionConstants {

        // Constants related to Vision/Limelight

    }

}
