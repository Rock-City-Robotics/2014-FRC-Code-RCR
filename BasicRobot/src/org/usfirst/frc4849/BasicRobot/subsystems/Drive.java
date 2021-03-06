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
import org.usfirst.frc4849.BasicRobot.commands.*;
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
    SpeedController lazySusan = null;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveSequence());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void takeJoystick(Joystick left, Joystick right) {
        robotDrive.tankDrive(left, right);
    }
    
    public void takeGamepad(Joystick pad, int leftAxis, int rightAxis, double modifier) {
        double right = pad.getRawAxis(rightAxis);
        double left = pad.getRawAxis(leftAxis);
        if(Robot.oi.trigger2.get() == true) {
            modifier = modifier * 0.7;
        }
        robotDrive.arcadeDrive(-right * modifier, -left * modifier * 0.6);
        //robotDrive.m
    }
    
    public void pneumatics(DigitalInput digIn) {
        boolean a = digIn.get();
        if (a == true) {
            org.usfirst.frc4849.BasicRobot.RobotMap.pneumatics.set(Relay.Value.kOff);
        } else {
            org.usfirst.frc4849.BasicRobot.RobotMap.pneumatics.set(Relay.Value.kOn);
        }
    }
    
    public void light(DigitalOutput digOut) {
        digOut.set(true);
    }
    
    public void stop() {
        robotDrive.drive(0, 0);
    }
    
    public void checkLazySusan() {
        double input = Robot.lazySusan.returnPIDInput();
        if(input > 0.85) {
            while(input > 0.85) {
                lazySusan.set(-0.2);
                input = Robot.lazySusan.returnPIDInput();
            }
            lazySusan.set(0);
        } else if(input < 0.3) {
            while(input < 0.3) {
                lazySusan.set(0.2);
                input = Robot.lazySusan.returnPIDInput();
            }
            lazySusan.set(0);
        }
    }
    
    /*
    public void fixProblem(double bounds, double movespeed) {
        double input = Robot.lazySusan.returnPIDInput();
        org.usfirst.frc4849.BasicRobot.commands.LazySusanMovement.override = true;
            while(input < bounds) {
                lazySusan.set(movespeed);
                input = Robot.lazySusan.returnPIDInput();
            }
            lazySusan.set(0);
            org.usfirst.frc4849.BasicRobot.commands.LazySusanMovement.override = false;
    }*/
}

