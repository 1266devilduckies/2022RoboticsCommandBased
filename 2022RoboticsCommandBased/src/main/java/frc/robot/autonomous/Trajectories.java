package frc.robot.autonomous;

import java.io.IOException;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.CmdPewPewStart;

public class Trajectories {
    
    public static SendableChooser<Integer> autoRoutines = new SendableChooser<>();

    public static Trajectory auto1Part1;
  
    public static Trajectory auto2Part1;
    public static Trajectory auto2Part2;
    public static Trajectory auto2Part3;
  
    public static Trajectory auto3Part1;
    public static Trajectory auto3Part2;
  
    public static Trajectory auto4Part1;
    public static Trajectory auto4Part2;
    public static Trajectory auto4Part3;
  
    public static Trajectory auto5Part1;
    public static Trajectory auto5Part2;
    public static Trajectory auto5Part3;
    public static Trajectory auto5Part4;
    public static Trajectory auto5Part5;
  
    public static Trajectory auto6Part1;
    public static Trajectory auto6Part2;
    public static Trajectory auto6Part3;
  
    public static Trajectory auto7Part1;
  
    public static Trajectory auto8Part1;
    public static Trajectory auto8Part2;
    public static Trajectory auto8Part3;
    public static Trajectory auto8Part4;
    public static Trajectory auto8Part5;
    public static Trajectory auto8Part6;
    public static Trajectory auto8Part7;
  
    CmdPewPewStart shootHigh;
    Trajectory initTrajectory;

    public void generateTrajectories(){
        try {
            initTrajectory = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto1Part1.wpilib.json"));
            
            auto1Part1 = initTrajectory;
      
            auto2Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto2Part1.wpilib.json"));
            auto2Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto2Part2.wpilib.json"));
            auto2Part3 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto2Part3.wpilib.json"));
      
            auto3Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto3Part1.wpilib.json"));
            auto3Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto3Part2.wpilib.json"));
              
            auto4Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto4Part1.wpilib.json"));
            auto4Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto4Part2.wpilib.json"));
            auto4Part3 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto4Part3.wpilib.json"));
              
            auto5Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto5Part1.wpilib.json"));
            auto5Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto5Part2.wpilib.json"));
            auto5Part3 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto5Part3.wpilib.json"));
            auto5Part4 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto5Part4.wpilib.json"));
            auto5Part5 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto5Part5.wpilib.json"));
              
            auto6Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto6Part1.wpilib.json"));
            auto6Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto6Part2.wpilib.json"));
            auto6Part3 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto6Part3.wpilib.json"));
      
            auto7Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto7Part1.wpilib.json"));
      
            auto8Part1 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part1.wpilib.json"));
                auto8Part2 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part2.wpilib.json"));
                auto8Part3 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part3.wpilib.json"));
                auto8Part4 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part4.wpilib.json"));
                auto8Part5 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part5.wpilib.json"));
                auto8Part6 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part6.wpilib.json"));
                auto8Part7 = TrajectoryUtil.fromPathweaverJson(
                Filesystem.getDeployDirectory().toPath().resolve("paths/auto8Part7.wpilib.json"));
        } catch (IOException ex) {
            // whoops
        }
    }
}
