package frc.robot.hardware.limelight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    //basically a java object to represent the limelight, used for controlling the settings of the limelight
    // table storing limelight data
    private static NetworkTable m_table = NetworkTableInstance.getDefault().getTable("limelight");
    
    // returns the degrees horziontally from target
    public static double getdegRotationToTarget() {
        NetworkTableEntry tx = m_table.getEntry("tx");
        return tx.getDouble(0.0);
    }

    // return the degrees vertically away from target
    public static double getdegVerticalToTarget() {
        NetworkTableEntry ty = m_table.getEntry("ty");
        return ty.getDouble(0.0);
    }

    // returns whether target is in frame
    public static double seeIfTargetsExist() {
        NetworkTableEntry tv = m_table.getEntry("tv");
        return tv.getDouble(0.0);
    }

    //ON 3, OFF 1 , BLINK 2
    public void setLEDMode(int i){
        if(i > 3 || i < 1 ) return;
        m_table.getEntry("ledMode").setNumber(i);
    }


}
