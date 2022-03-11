package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class BackOneBallAuto extends SequentialCommandGroup {


    public BackOneBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb, NavXSubsystem m_navx) {
        addCommands(
          
        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb, m_navx),

        //score position
        new AutoWristDown(m_wrist),

        //intake scoring
        new AutoScore(m_intake),

         //drive to a backward set number, at a certain speed
        new DriveCommand(false, Constants.BackOneBallAuto.AUTO_BACKUP1, Constants.AUTO_SPEED, m_drive),
        
        //intake position
        new IntakePosition(m_arm, m_wrist)


        );
      }
    
}
