/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4849.BasicRobot.Robot;
import org.usfirst.frc4849.BasicRobot.subsystems.LazySusan;

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
        if(Robot.oi.tripLever4.get() == true) {
            Robot.lazySusan.enable();
        }
    }
    
    protected void execute() {
        
    }
    
    protected boolean isFinished() {
        if(Robot.lazySusan.getPosition() < 0.45) {
            return true;
        } else if(Robot.lazySusan.getPosition() > 0.94) {
            return true;
        } else {
            return Math.abs(setPoint - Robot.lazySusan.getPosition()) < 0.0025;
        }
    }
    
    protected void end() {
        Robot.lazySusan.disable();
    }
    
    protected void interrupted() {
        
        end();
    }
}
