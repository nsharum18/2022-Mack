// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;

import frc.robot.subsystems.WristSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class WristUp extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final WristSubsystem m_wrist;

    public WristUp(WristSubsystem subsystem) {

      m_wrist = subsystem;
      addRequirements(m_wrist);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_wrist.wristSetScore();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_wrist.wristSetScore();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_wrist.wristStop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_wrist.getWristEnc() >= Constants.WRIST_SCORE_VALUE;
  }
}
