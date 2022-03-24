package frc.robot.hardware.input;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
    
    //define getters for Controller trigger/sticks/PovButtons/etc
    //also define values such as deadband

    private Joystick joystick;

    private double leftDeadband = 0.05;
    private double rightDeadband = 0.05;
    
    public Controller(int id){
        this.joystick = new Joystick(id);
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public double getLeftStickX() {
        return Math.abs(this.joystick.getRawAxis(0)) > leftDeadband ? this.joystick.getRawAxis(0) : 0;
    }
       
  
    public double getLeftStickY() {
        return Math.abs(this.joystick.getRawAxis(1)) > leftDeadband ? this.joystick.getRawAxis(1) : 0;
    }
  
    public double getRightStickX() {
        return Math.abs(this.joystick.getRawAxis(2)) > rightDeadband ? this.joystick.getRawAxis(2) : 0;
    }
  
    public double getRightStickY() {
        return Math.abs(this.joystick.getRawAxis(5)) > rightDeadband ? this.joystick.getRawAxis(5) : 0;
    }
  
    public boolean rightTriggeredPressed() {
        if (this.joystick.getRawAxis(3) > 0) {
            return true;
        } else {
            return false;
        }
    }
  
    public boolean leftTriggeredPressed() {
        if (this.joystick.getRawAxis(2) > .25) {
            return true;
        } else {
            return false;
        }
    }
  
    public double getPov() {
        double povValue = this.joystick.getPOV();
        return povValue;
    }

}
