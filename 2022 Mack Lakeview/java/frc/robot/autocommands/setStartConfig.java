package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;


public class setStartConfig extends CommandBase {
    
    private final ArmSubsystem arm;
    private final DriveSubsystem drive;
    private final IntakeSubsystem intake;
    private final WristSubsystem wrist;
    private final LClimbSubsystem lclimb;
    private final RClimbSubsystem rclimb;


    public setStartConfig(ArmSubsystem m_arm, DriveSubsystem m_drive, IntakeSubsystem m_intake, WristSubsystem m_wrist, LClimbSubsystem l_climb, RClimbSubsystem r_climb) {
        arm = m_arm;
        drive = m_drive;
        wrist = m_wrist;
        intake = m_intake;
        lclimb = l_climb;
        rclimb = r_climb;
        addRequirements(m_arm);
    }

    public void initialize() {
        arm.armSetStartEnc();
        drive.resetEncoders();
        wrist.wristSetStartEnc();
        intake.resetIntakeEnc();
        lclimb.resetClimberEnc();
        rclimb.resetRClimberEnc();
        
    }

    public void execute() {
        arm.armSetStartEnc();
        drive.resetEncoders();
        wrist.wristSetStartEnc();
        intake.resetIntakeEnc();
        lclimb.resetClimberEnc();
        rclimb.resetRClimberEnc();
    }

    public void end(boolean inturrupted) {
    }

    public boolean isFinished() {
        return arm.getArmEnc() == Constants.ARM_STARTING_CONFIG && drive.getLMasterEncoder() == 0 
        && wrist.getWristEnc() == Constants.WRIST_STARTING_CONFIG && lclimb.getlClimberEnc() == 0 && rclimb.getrClimberEnc() == 0;
    }
}
