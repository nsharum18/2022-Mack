package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class setStartConfig extends CommandBase {
    
    private final ArmSubsystem arm;
    private final DriveSubsystem drive;
    private final IntakeSubsystem intake;
    private final WristSubsystem wrist;
    private final ClimberSubsystem climb;

    public setStartConfig(ArmSubsystem m_arm, DriveSubsystem m_drive, IntakeSubsystem m_intake, WristSubsystem m_wrist, ClimberSubsystem m_climb) {
        arm = m_arm;
        drive = m_drive;
        wrist = m_wrist;
        intake = m_intake;
        climb = m_climb;
        addRequirements(m_arm);
    }

    public void initialize() {
        arm.armSetStartEnc();
        drive.resetEncoders();
        wrist.wristSetStartEnc();
        intake.resetIntakeEnc();
        climb.resetClimberEnc();
        
    }

    public void execute() {
    }

    public void end(boolean inturrupted) {
    }

    public boolean isFinished() {
        return true;
    }
}
