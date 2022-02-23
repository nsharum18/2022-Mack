// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final DriveSubsystem m_drive;

    public DriveCommand(DriveSubsystem subsystem) {

      m_drive = subsystem;
      addRequirements(m_drive);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_drive.resetEncoders();
    m_drive.arcadeDrive(Constants.AUTO_SPEED, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_drive.arcadeDrive(Constants.AUTO_SPEED, 0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

        m_drive.arcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_drive.getLMasterEnc() >= 100;
  }
}
