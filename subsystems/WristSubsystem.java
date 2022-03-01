// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;


public class WristSubsystem extends SubsystemBase {

  //creates wrist motor
  private final WPI_TalonFX wrist = new WPI_TalonFX(Constants.WRIST_MOTOR);

  /** Creates a new ArmSubsytem. */
  public WristSubsystem() {

        //sets brake
        wrist.setNeutralMode(NeutralMode.Brake);
    
        //sets rotation
        wrist.setInverted(TalonFXInvertType.Clockwise);
  }

  public void resetWristEnc() {

    //resets wrist
    wrist.setSelectedSensorPosition(0);
  }

  public double getWristEnc() {

    //reads wrist encoder
    return wrist.getSelectedSensorPosition() / Constants.QUADRATURE_COUNT;

  }

  public void wristSetStartEnc() {

    //sets encoder to start config height
    wrist.setSelectedSensorPosition(Constants.WRIST_STARTING_CONFIG * Constants.QUADRATURE_COUNT);

  }

  public void wristSetIntake() {

    //sets wrist to intake

      wrist.set(-.25);
    
  }

  public void wristSetScore() {

    //sets wrist to score

      wrist.set(.25);
    
  }

  public void startScore(double speed) {

    //sets wrist in auto
    wrist.set(speed);

  }

  public void wristSetStart() {

    //sets wrist to start

      wrist.set(.25);
    
  }

  public void wristSetClimb() {

    
  }

  public void wristStop() {

    wrist.set(0);
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
