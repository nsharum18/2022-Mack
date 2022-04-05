// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;


public class RClimbSubsystem extends SubsystemBase {

  private final WPI_TalonFX lclimber = new WPI_TalonFX(Constants.LEFT_CLIMBER);
  private final WPI_TalonFX rclimber = new WPI_TalonFX(Constants.RIGHT_CLIMBER);



  
  /** Creates a new ArmSubsytem. */
  public RClimbSubsystem() {

        //sets brake
        lclimber.setNeutralMode(NeutralMode.Brake);
        rclimber.setNeutralMode(NeutralMode.Brake);

        //sets rotation
        lclimber.setInverted(TalonFXInvertType.CounterClockwise);
        rclimber.setInverted(TalonFXInvertType.CounterClockwise);
  }

  public void resetRClimberEnc(){

    rclimber.setSelectedSensorPosition(0);

  }


  public double getrClimberEnc() {

    return rclimber.getSelectedSensorPosition() / Constants.QUADRATURE_COUNT;

  }


  public void rClimbExtend() {

      rclimber.set(1);
    
  }

  public void rClimbRetract() {

    rclimber.set(-1);
  }

  

  public void rClimbStop() {

    rclimber.set(0);
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
