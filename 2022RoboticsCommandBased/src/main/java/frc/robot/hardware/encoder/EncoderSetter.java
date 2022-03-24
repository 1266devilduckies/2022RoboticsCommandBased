package frc.robot.hardware.encoder;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class EncoderSetter {
    
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
