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
public class LazySusanMovement extends Command {
    public LazySusanMovement() {
        requires(Robot.lazySusan);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
        
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
        
    }
    
    protected void interrupted() {
        end();
    }
}
