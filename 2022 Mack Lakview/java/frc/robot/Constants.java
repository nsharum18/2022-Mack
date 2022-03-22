// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final double ARM_INTAKE_VALUE = 5;
    public static final double ARM_STARTING_CONFIG = 119;

    //wrist encoder values
    public static final double WRIST_SCORE_VALUE = 70;
    public static final double WRIST_INTAKE_VALUE = 4;
    public static final double WRIST_STARTING_CONFIG = 60;
    public static final double WRIST_DOWN_VALUE = 46;

    //robot speeds
    public static final double AUTO_SPEED = .5;
    public static final double TURN_SPEED = .6;
    public static       double DRIVE_SPEED = .6;
    public static final double INTAKE_SPEED = .75;
    public static final double SCORE_SPEED = 1;

    //climb values
    public static final double LEXTEND_HEIGHT = 130;
    public static final double REXTEND_HEIGHT = 133;
    public static final double RETRACT_HEIGHT = 5;

    //misc values
    public static final double QUADRATURE_COUNT = 2048;
    public static final double RAMP_TIME = .5;

}


