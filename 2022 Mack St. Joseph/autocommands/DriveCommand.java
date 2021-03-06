// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autocommands;

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
    
    private final boolean m_forward;
    private final DriveSubsystem m_drive;
    private final double m_distance;
    private final double m_speed;



    public DriveCommand(boolean forward, Double distance, Double speed, DriveSubsystem subsystem) {
      m_forward = forward;
      m_drive = subsystem;
      m_distance = distance;
      m_speed = speed;
      addRequirements(m_drive);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.resetEncoders();
    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_drive.arcadeDrive(m_speed, 0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

        m_drive.arcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_forward) {
    return m_drive.getLMasterEnc() >= m_distance;
    } else {
    return m_drive.getLMasterEnc() <= m_distance;

    }
  }
}
