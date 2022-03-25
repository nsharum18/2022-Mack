package frc.robot.autocommands;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.Intake;
import frc.robot.commands.IntakePosition;
import frc.robot.commands.ScorePosition;
import frc.robot.subsystems.*;

public class LeftTwoBallAuto extends SequentialCommandGroup {

    public LeftTwoBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb) {

      Trajectory l2b1 = m_drive.generateTrajectroy(Constants.l2b1);
      Trajectory l2b2 = m_drive.generateTrajectroy(Constants.l2b2);

        addCommands(

            new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb),

            new AutoWristDown(m_wrist),

            new AutoScore(m_intake),

            new InstantCommand(() -> m_drive.resetOdometry(l2b1.getInitialPose())),

            new ParallelDeadlineGroup(
              new FollowTrajectory(m_drive, l2b1),
              new IntakePosition(m_arm, m_wrist),
              new Intake(m_intake)
            ),

            new ParallelDeadlineGroup(
              new FollowTrajectory(m_drive, l2b2),
              new ScorePosition(m_arm, m_wrist)
            ),

            new AutoScore(m_intake)

        );
      }
}
