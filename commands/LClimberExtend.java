// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;

import frc.robot.subsystems.LClimbSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LClimberExtend extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final LClimbSubsystem lclimber;


    public LClimberExtend(LClimbSubsystem subsystem) {

      lclimber = subsystem;
      addRequirements(lclimber);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    lclimber.lClimbExtend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    lclimber.lClimbExtend();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    lclimber.lClimbStop();


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return lclimber.getlClimberEnc() >= Constants.EXTEND_HEIGHT;
  }
}
