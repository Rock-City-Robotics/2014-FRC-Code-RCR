/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc4849.BasicRobot.Robot;
import org.usfirst.frc4849.BasicRobot.RobotMap;

/**
 *
 * @author Cale
 */
public class ArmMovement extends Command {
    private final boolean back;
    SpeedController arm = RobotMap.dSCarm;
    private double m;
    private double q = 1;
    
    public ArmMovement(boolean back) {
        this.back = back;
    }
    
    protected void initialize() {
        
    }
    
    protected void execute() {
        if(back == false & Robot.oi.tripLever4.get() == true) {
            m = 0;
        } else if(back == false & Robot.oi.tripLever4.get() == false) {
            m = -1;
        } else if(back == true & Robot.oi.tripLever1.get() == false) {
            m = 1;
        } else if(back == true & Robot.oi.tripLever1.get() == true) {
            m = 0;
        }
        if(Robot.oi.trigger2.get() == false) {
            q = 0.6;
        } else {
            q = 1;
        }
        arm.set(m * q * 0.9);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
        arm.set(0);
    }
    
    protected void interrupted() {
        arm.set(0);
        end();
    }
}
