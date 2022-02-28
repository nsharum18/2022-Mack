// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class DefaultDrive extends CommandBase {

    
    private final DriveSubsystem m_drive;
    private final double m_forward;
    private final double m_rotation;


    public DefaultDrive(DriveSubsystem subsystem, double forward, double rotation) {
      m_drive = subsystem;
      m_forward = forward;
      m_rotation = rotation;
      addRequirements(m_drive);
    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_drive.arcadeDrive(m_forward, m_rotation);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  return false;
  }
}
