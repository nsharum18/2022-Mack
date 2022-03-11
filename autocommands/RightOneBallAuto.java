package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RightOneBallAuto extends SequentialCommandGroup {


    public RightOneBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb, NavXSubsystem m_navx) {
        addCommands(
          
        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb, m_navx),

        //score position
        new AutoWristDown(m_wrist),

        //intake scoring
        new AutoScore(m_intake),

        //turns to the left
        new TurnCommand(true, Constants.RightOneBallAuto.AUTO_LTURN, Constants.AUTO_SPEED, m_drive, m_navx),

        //zeros drive
        new resetDriveEnc(m_drive),

        //drives forward
        new DriveCommand(false, Constants.RightOneBallAuto.AUTO_BACK1, Constants.AUTO_SPEED, m_drive),
        
        //intake position
        new IntakePosition(m_arm, m_wrist)


        );
      }
    
}
