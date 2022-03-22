package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

public class ClimbersRetract extends ParallelCommandGroup {


    public ClimbersRetract(LClimbSubsystem l_climb, RClimbSubsystem r_climb) {
        addCommands(

        //arm up
        new LClimberRetract(l_climb),

        //wrist up
        new RClimberRetract(r_climb)

        );
      }
    
}
