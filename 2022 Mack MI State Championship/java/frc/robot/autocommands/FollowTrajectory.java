package frc.robot.autocommands;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants;


public class FollowTrajectory extends SequentialCommandGroup {
    //String path = "pathplanner/generatedJSON/TestPath2.wpilib.json";
    private final DriveSubsystem drive;

    public  FollowTrajectory(DriveSubsystem m_drive, Trajectory trajectory) {
      drive = m_drive;

      RamseteCommand ramseteCommand =
      new RamseteCommand(
      trajectory,
      drive::getPose,
      new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
      new SimpleMotorFeedforward(
      Constants.ks,
      Constants.kv,
      Constants.ka),
      Constants.kDriveKinematics,
      drive::getWheelSpeeds,
      new PIDController(Constants.kp, 0, 0),
      new PIDController(Constants.kp, 0, 0),
      drive::tankDriveVolts,
      drive);

      addCommands(

        ramseteCommand.andThen(() -> drive.tankDriveVolts(0,0)));
    

}
 

}
