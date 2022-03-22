// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autocommands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final DriveSubsystem m_drive;
    private final double m_angle;
    private final double m_speed;
    private final boolean m_left;
    private final NavXSubsystem m_navx;



    public TurnCommand(Boolean left, Double angle, Double speed, DriveSubsystem subsystem, NavXSubsystem navx) {

      m_left = left;
      m_drive = subsystem;
      m_navx = navx;
      m_angle = angle;
      m_speed = speed;
      addRequirements(m_drive);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_drive.arcadeDrive(0, m_speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

        m_drive.arcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_left){
    return  m_navx.getAngle() <= m_angle; 
  } else {

    return m_navx.getAngle() >= m_angle;
  }
}
}
