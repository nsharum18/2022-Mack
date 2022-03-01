// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.Constants.*;


public class DriveSubsystem extends SubsystemBase {

  //creating drive motors
 private final WPI_TalonFX LMaster = new WPI_TalonFX(LEFT_DRIVE_MASTER);
 private final WPI_TalonFX LFollower = new WPI_TalonFX(LEFT_DRIVE_FOLLOWER);
 private final WPI_TalonFX RMaster = new WPI_TalonFX(RIGHT_DRIVE_MASTER);
 private final WPI_TalonFX RFollower = new WPI_TalonFX(RIGHT_DRIVE_FOLLOWER);

 //creating drivetrain
 private final DifferentialDrive DriveTrain = new DifferentialDrive(LMaster, RMaster);


  /** Creates a new ArmSubsytem. */
  public DriveSubsystem() {

    //sets followers
    LFollower.follow(LMaster);
    LFollower.setInverted(InvertType.FollowMaster);
    RFollower.follow(RMaster);
    RFollower.setInverted(InvertType.FollowMaster);

    //sets brake
    LMaster.setNeutralMode(NeutralMode.Brake);
    LFollower.setNeutralMode(NeutralMode.Brake);
    RMaster.setNeutralMode(NeutralMode.Brake);
    RFollower.setNeutralMode(NeutralMode.Brake);

    //sets rotation
    LMaster.setInverted(TalonFXInvertType.CounterClockwise);
    RMaster.setInverted(TalonFXInvertType.CounterClockwise);

    //ramp rate
    LMaster.configOpenloopRamp(Constants.RAMP_TIME);
    RMaster.configOpenloopRamp(Constants.RAMP_TIME);

  }

  public void resetEncoders() {

    //sets drive encoders to 0
    LMaster.setSelectedSensorPosition(0);
    RMaster.setSelectedSensorPosition(0);


  }

  public double getLMasterEnc() {
    
    //returns lmaster encoder
    return LMaster.getSelectedSensorPosition() / Constants.QUADRATURE_COUNT;

  }

  public double getRMasterEnc() {
    
    //returns rmaster encoder
    return RMaster.getSelectedSensorPosition() / Constants.QUADRATURE_COUNT;

  }

  public double getAverage() {

    return (getRMasterEnc() + getLMasterEnc()) / 2;
  }

  public void arcadeDrive (double fwd, double rot) {

    //setting up drivetrain
    DriveTrain.arcadeDrive(fwd, rot);
  }

  public void setDriveSpeed() {

    DriveTrain.setMaxOutput(Constants.DRIVE_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
