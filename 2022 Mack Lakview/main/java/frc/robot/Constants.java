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

    //trajectory constants
    public static final double ksVolts = .72;
    public static final double kvVoltSecondsPerMeter = 1.36;
    public static final double kaVoltSecondsSquaredPerMeter = .49;
    public static final double kPDriveVel = 21.11;

    public static final double kTrackwidthMeters = .6858;

    public static final double kWheelDiameterMeters = .152;
    public static final double kEncoderCPR = 2048;
    public static final double kEncoderDistancePerPulse = (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;

    public static final double gearRatio = 1 / 6;
    
    public static final DifferentialDriveKinematics kDriveKinematics =
                    new DifferentialDriveKinematics(kTrackwidthMeters);

    public static final double kMaxSpeedMetersPerSecond = .2;
    public static final double kMaxAccelerationMetersPerSecondSquared = .2;

    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

/********************** Left Two Ball Auto **********************/

public static final class LeftTwoBallAuto {

    //LeftTwoBallAuto values
    public static final double AUTO_LTURN = -156;
    public static final double AUTO_FORWARD1 = 18;
    public static final double AUTO_RTURN = -10;
    public static final double AUTO_FORWARD2 = 10;


    }

/********************** Left One Ball Auto **********************/

public static final class LeftOneBallAuto{

    //LeftOneBallAuto values
    public static final double AUTO_RTURN = 23;
    public static final double AUTO_BACK1 = -22;

}

/********************** Right Three Ball Auto **********************/

public static final class RightThreeBallAuto{

    //RightThreeBall values
    public static final double AUTO_LTURN1 = -112;
    public static final double AUTO_FORWARD1 = 18;
    public static final double AUTO_LTURN2 = -242;
    public static final double AUTO_FORWARD2 = 27;
    public static final double AUTO_LTURN3 = -355;
    public static final double AUTO_FORWARD3 = 9;


}

/********************** Right Two Ball Auto **********************/

public static final class RightTwoBallAuto{

    //RightTwoBall values
    public static final double AUTO_LTURN1 = -112;
    public static final double AUTO_FORWARD1 = 18;
    public static final double AUTO_LTURN2 = -302;
    public static final double AUTO_FORWARD2 = 16;

}

/********************** Right One Ball Auto **********************/

public static final class RightOneBallAuto{

    //RightOneBall values
    public static final double AUTO_LTURN = -25;
    public static final double AUTO_BACK1 = -20;

}

/********************** Back One Ball Auto **********************/

public static final class BackOneBallAuto{

    //BackOneBall values
    public static final double AUTO_BACKUP1 = -30;

}

}


