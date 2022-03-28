package frc.robot.autocommands;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

import frc.robot.subsystems.*;

public class TrajectoryTest extends SequentialCommandGroup {

    public TrajectoryTest(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb) {

      Trajectory Motion1 = m_drive.generateTrajectroy(Constants.r2b1);
      Trajectory Motion2 = m_drive.generateTrajectroy(Constants.r2b2);
      Trajectory Motion3 = m_drive.generateTrajectroy(Constants.r3b3);


        addCommands(
            new InstantCommand(() -> m_drive.resetOdometry(Motion1.getInitialPose())),

            new FollowTrajectory(m_drive, Motion1),

            new FollowTrajectory(m_drive, Motion2)//,

            //new FollowTrajectory(m_drive, Motion3)

        );
      }
}
