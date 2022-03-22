// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;


public class NavXSubsystem extends SubsystemBase {

//creates navx
public AHRS NavX = new AHRS(edu.wpi.first.wpilibj.SPI.Port.kMXP);


  /** Creates a new ArmSubsytem. */
  public NavXSubsystem() {



  }

  public void resetAngle() {

   NavX.reset();

  }

  public double getAngle() {

    return NavX.getAngle();

  }

  public double getPitch() {

    return NavX.getPitch();
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
