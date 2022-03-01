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
    public static final double ARM_SCORE_VALUE = 118;
    public static final double ARM_INTAKE_VALUE = 5;
    public static final double ARM_STARTING_CONFIG = 118;

    //wrist encoder values
    public static final double WRIST_SCORE_VALUE = 11;
    public static final double WRIST_INTAKE_VALUE = 2;
    public static final double WRIST_STARTING_CONFIG = 18;

    //robot speeds
    public static final double AUTO_SPEED = .5;
    public static final double TURN_SPEED = .5;
    public static final double DRIVE_SPEED = .6;
    public static final double INTAKE_SPEED = .6;
    public static final double SCORE_SPEED = 1;

    //climb values
    public static final double EXTEND_HEIGHT = 75;
    public static final double RETRACT_HEIGHT = 5;

    //misc values
    public static final double QUADRATURE_COUNT = 2048;
    public static final double RAMP_TIME = 1;

/********************** Left Auto **********************/

public static final class LeftAuto {

    //LeftAuto values
    public static final double AUTO_BACKUP1 = -20;
    public static final double AUTO_LTURN = -50;
    public static final double AUTO_FORWARD1 = -10;
    public static final double INTAKE_VALUE = 50;
    public static final double AUTO_RTURN = 30;
    public static final double AUTO_FORWARD2 = 60;


    }

/********************** Left One Ball Auto **********************/

public static final class LeftOneBallAuto{

    //LeftAuto values
    public static final double AUTO_BACKUP1 = -20;
    public static final double AUTO_LTURN = -40;
    public static final double AUTO_FORWARD1 = -10;

}

/********************** Right One Ball Auto **********************/

public static final class RightOneBallAuto{

    //LeftAuto values
    public static final double AUTO_BACKUP1 = -20;
    public static final double AUTO_RTURN = 20;
    public static final double AUTO_FORWARD1 = 50;

}

/********************** Back One Ball Auto **********************/

public static final class BackOneBallAuto{

    //LeftAuto values
    public static final double AUTO_BACKUP1 = -30;

}

}


