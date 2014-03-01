/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4849.BasicRobot.Robot;

/**
 *
 * @author Cale
 */
public class fizLazySusan extends Command {
    
    public fizLazySusan() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.lazySusan);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.lazySusan.getPosition() < 0.45) {
            Robot.lazySusan.spinCounterClockwise();
        } else if(Robot.lazySusan.getPosition() > 0.94) {
            Robot.lazySusan.spinClockwise();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}