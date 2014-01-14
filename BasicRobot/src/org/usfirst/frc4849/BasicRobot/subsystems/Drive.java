// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4849.BasicRobot.subsystems;
import org.usfirst.frc4849.BasicRobot.RobotMap;
import org.usfirst.frc4849.BasicRobot.commands.ArcadeDrive;
//import org.usfirst.frc4849.BasicRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4849.BasicRobot.Robot;
/**
 *
 */
public class Drive extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController speedControllerLeft = RobotMap.driveSpeedControllerLeft;
    SpeedController speedControllerRight = RobotMap.driveSpeedControllerRight;
    RobotDrive robotDrive = RobotMap.driveRobotDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	setDefaultCommand(new ArcadeDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void takeJoystick(int mode) {
        if(mode == 1) {
            robotDrive.arcadeDrive(Robot.oi.extreme3DPro);
        } else if(mode == 2) {
            robotDrive.tankDrive(Robot.oi.leftJoy, Robot.oi.rightJoy);
        }
        
    }
    
    public void stop() {
        robotDrive.drive(0, 0);
    }
}
