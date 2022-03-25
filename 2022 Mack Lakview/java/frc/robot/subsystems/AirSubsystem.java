// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class AirSubsystem extends SubsystemBase {
  
  Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  DoubleSolenoid left = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  DoubleSolenoid right = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);


  /** Creates a new ArmSubsytem. */
  public AirSubsystem() {
  
      
  }

  public void shiftLow() {

    left.set(kForward);
    right.set(kForward);

  }

  public void shiftHigh() {

    left.set(kReverse);
    right.set(kReverse);
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
