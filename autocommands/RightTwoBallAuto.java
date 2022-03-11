package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RightTwoBallAuto extends SequentialCommandGroup {


    public RightTwoBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb, NavXSubsystem m_navx) {
        addCommands(
          
        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb, m_navx),

        //score position
        new AutoWristDown(m_wrist),

        //scores
        new AutoScore(m_intake),

        //turn to the left
        new TurnCommand(true, Constants.RightTwoBallAuto.AUTO_LTURN1, Constants.AUTO_SPEED, m_drive, m_navx),

        //intake position
        new IntakePosition(m_arm, m_wrist),

         //zeros drive encoders
         new resetDriveEnc(m_drive),

        //drive forward with intake running
        new DriveIntakeCommand(true, Constants.RightTwoBallAuto.AUTO_FORWARD1, Constants.AUTO_SPEED * -1, m_drive, m_intake),

        //score position
        new ScorePosition(m_arm, m_wrist),

        //turn to the right
        new TurnCommand(true, Constants.RightTwoBallAuto.AUTO_LTURN2, Constants.AUTO_SPEED, m_drive, m_navx),

        //zeros drive encoders
        new resetDriveEnc(m_drive),

        //drives forward
        new DriveCommand(true, Constants.RightTwoBallAuto.AUTO_FORWARD2, Constants.AUTO_SPEED * -1, m_drive),

        //scores
        new AutoScore(m_intake)


        );
      }
    
}
