// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Boost extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    

    public Boost() {

      addRequirements();

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  Constants.DRIVE_SPEED = 1; 
 }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Constants.DRIVE_SPEED = 1; 
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    Constants.DRIVE_SPEED = .6;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  return false;  }
}
