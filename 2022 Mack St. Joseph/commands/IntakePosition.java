package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

public class IntakePosition extends ParallelCommandGroup {


    public IntakePosition(ArmSubsystem m_arm, WristSubsystem m_wrist) {
        addCommands(

        //arm Down
        new ArmDown(m_arm),

        //wrist Down
        new WristDown(m_wrist)

        );
      }
    
}
