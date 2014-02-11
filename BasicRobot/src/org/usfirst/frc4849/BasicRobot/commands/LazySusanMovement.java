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
    private final double setPoint;
    
    public LazySusanMovement(double setPoint) {
        this.setPoint = setPoint;
        requires(Robot.lazySusan);
    }
    
    protected void initialize() {
        Robot.lazySusan.setSetpoint(setPoint);
    }
    
    protected void execute() {
        
    }
    
    protected boolean isFinished() {
        return Math.abs(setPoint - Robot.lazySusan.getPosition()) < 0.025;
    }
    
    protected void end() {
        
    }
    
    protected void interrupted() {
        
        end();
    }
}
