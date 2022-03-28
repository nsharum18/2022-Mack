// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //motor IDs
    public static final int LEFT_DRIVE_MASTER = 1;
    public static final int LEFT_DRIVE_FOLLOWER = 2;
    public static final int RIGHT_DRIVE_MASTER = 3;
    public static final int RIGHT_DRIVE_FOLLOWER = 4;
    public static final int ARM_MOTOR = 5;
    public static final int WRIST_MOTOR = 6;
    public static final int INTAKE_MOTOR = 7;
    public static final int LEFT_CLIMBER = 8;
    public static final int RIGHT_CLIMBER = 9;

    //arm encoder values
    public static final double ARM_SCORE_VALUE = 111;
    public static final double ARM_INTAKE_VALUE = 8;
    public static final double ARM_STARTING_CONFIG = 119;

    //wrist encoder values
    public static final double WRIST_SCORE_VALUE = 50;
    public static final double WRIST_INTAKE_VALUE = 6;
    public static final double WRIST_STARTING_CONFIG = 142;
    public static final double WRIST_DOWN_VALUE = 78;

    //robot speeds
    public static final double AUTO_SPEED = .5;
    public static       double TURN_SPEED = .6;
    public static       double DRIVE_SPEED = .6;
    public static final double INTAKE_SPEED = .75;
    public static final double SCORE_SPEED = 1;
    public static final double AUTO_SCORE_SPEED = 0.9;
    public static final double LOW_SPEED = 1;
    public static final double HIGH_SPEED = .6;

    //climb values
    public static final double LEXTEND_HEIGHT = 130;
    public static final double REXTEND_HEIGHT = 133;
    public static final double RETRACT_HEIGHT = 5;

    //misc values
    public static final double QUADRATURE_COUNT = 2048;
    public static final double RAMP_TIME = .5;

    /*********************************** LEFT TWO BALL AUTO ***********************************/
    public static final String l2b1 = "pathplanner/generatedJSON/L2B1.wpilib.json";
    public static final String l2b2 = "pathplanner/generatedJSON/L2B2.wpilib.json";

    /********************************** RIGHT TWO BALL AUTO ***********************************/
    public static final String r2b1 = "pathplanner/generatedJSON/R2B1.wpilib.json";
    public static final String r2b2 = "pathplanner/generatedJSON/R2B2.wpilib.json";

    /********************************** RIGHT THREE BALL AUTO ***********************************/
     public static final String r3b1 = "pathplanner/generatedJSON/R3B1.wpilib.json";
     public static final String r3b2 = "pathplanner/generatedJSON/R3B2.wpilib.json";
     public static final String r3b3 = "pathplanner/generatedJSON/R3B3.wpilib.json";


    // Trajectory Constants
    public static final double ks = 0.722;
    public static final double kv = 1.52;
    public static final double ka = 0.625;

    public static final double kp = 0.5;

    public static final double gearRatio = 6.86;

    public static final double wheelDistance = 0.81295;
    public static final double wheelDiameter = 0.1524;

    public static final double wheelCircumference = (wheelDiameter * Math.PI);

    public static final double EncoderCPR = 2048;

    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(wheelDistance);

    public static final double kMaxSpeedMetersPerSecond = 0.5;
    public static final double kMaxAccelerationMetersPerSecondSquared = 0.5;

    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    public static final boolean kGyroReversed = true;


}


