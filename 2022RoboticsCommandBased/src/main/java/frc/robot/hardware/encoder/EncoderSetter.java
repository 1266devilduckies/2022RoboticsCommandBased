package frc.robot.hardware.encoder;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class EncoderSetter {
    
    // converts sensor readings to meters
  public static double nativeUnitsToDistanceMeters(double sensorCounts) {
    double motorRotations = (double) sensorCounts / 2048.0; // is units per rotation for the falcons
    double wheelRotations = motorRotations / 8.333; // 8.333:1 is gear ratio
    double positionMeters = wheelRotations * (2 * Math.PI * 0.0508); // 2 inches in meters is 0.0508 meters. the wheels
                                                                    // radius is 2 inches
    return positionMeters;
  }

  // updates the encoders with new positions
  public static void updateEncoders() {
    //UPDATE LATER
    //RobotMap.avgPositionRaw = RobotMap.MainLeftMotorBack.getSelectedSensorPosition(0);
    //RobotMap.avgPositionInMeters = nativeUnitsToDistanceMeters(RobotMap.avgPositionRaw);
  }

  // set default encoder settings needed for operation (TalonFX)
  public static void setEncoderDefaultPhoenixSettings(TalonFX motor) {
    motor.configFactoryDefault();
    motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 100);
    motor.configOpenloopRamp(0.5);
    motor.setSelectedSensorPosition(0);
    motor.setInverted(false);
    motor.setSensorPhase(false);
    motor.enableVoltageCompensation(true);
  }

  // set default encoder settings needed for operation (WPI_TalonFX)
  public static void setEncoderDefaultPhoenixSettings(WPI_TalonFX motor) {
    motor.configFactoryDefault();
    motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 100);
    motor.setSelectedSensorPosition(0);
    motor.configOpenloopRamp(0.5);
    motor.setNeutralMode(NeutralMode.Coast);
    motor.setInverted(false);
    motor.setSensorPhase(false);
    motor.enableVoltageCompensation(true);
  }

  // set default encoder settings needed for operation (TalonSRX)
  public static void setEncoderDefaultPhoenixSettings(TalonSRX motor) {
    motor.configFactoryDefault();
    motor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.QuadEncoder, 0, 100);
    motor.setSelectedSensorPosition(0);
    motor.configOpenloopRamp(0.5);
    motor.setInverted(false);
    motor.setSensorPhase(false);
    motor.enableVoltageCompensation(true);
  }

  // set default encoder settings needed for operation (VictorSPX)
  public static void setEncoderDefaultPhoenixSettings(VictorSPX motor) {
    motor.configFactoryDefault();
    motor.configOpenloopRamp(0.5);
    motor.setInverted(false);
    motor.setSensorPhase(false);
  }

}
