/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc4849.BasicRobot.RobotMap;

/**
 *
 * @author Cale
 */
public class ArmMovement extends Command {
    private final boolean back;
    SpeedController arm = RobotMap.dSCarm;
    private double m;
    
    public ArmMovement(boolean back) {
        this.back = back;
    }
    
    protected void initialize() {
        if(back == false) {
            m = 1;
        } else {
            m = -1;
        }
    }
    
    protected void execute() {
        arm.set(0.1 * m);
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
