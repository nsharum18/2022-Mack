// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class IntakeStop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final IntakeSubsystem m_intake;

    public IntakeStop(IntakeSubsystem subsystem) {

      m_intake = subsystem;
      addRequirements(m_intake);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_intake.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_intake.stop();
    
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