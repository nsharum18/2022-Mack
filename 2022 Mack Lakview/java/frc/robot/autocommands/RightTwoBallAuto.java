package frc.robot.autocommands;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RightTwoBallAuto extends SequentialCommandGroup {

    public RightTwoBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb) {

      Trajectory Motion1 = m_drive.generateTrajectroy(Constants.r2b1);
      Trajectory Motion2 = m_drive.generateTrajectroy(Constants.r2b2);

        addCommands(

            new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb),

            new AutoWristDown(m_wrist),

            new AutoScore(m_intake),

            new InstantCommand(() -> m_drive.resetOdometry(Motion1.getInitialPose())),

            new ParallelDeadlineGroup(
              new FollowTrajectory(m_drive, Motion1),
              new IntakePosition(m_arm, m_wrist),
              new Intake(m_intake)
            ),

            new ParallelDeadlineGroup(
              new FollowTrajectory(m_drive, Motion2),
              new ScorePosition(m_arm, m_wrist)
            ),

            new AutoScore(m_intake)

        );
      }
}
