package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

public class ClimbersExtend extends ParallelCommandGroup {


    public ClimbersExtend(LClimbSubsystem l_climb, RClimbSubsystem r_climb) {
        addCommands(

        //arm up
        new LClimberExtend(l_climb),

        //wrist up
        new RClimberExtend(r_climb)

        );
      }
    
}
