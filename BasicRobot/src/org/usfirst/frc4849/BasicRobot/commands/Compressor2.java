/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4849.BasicRobot.RobotMap;

/**
 *
 * @author Cale
 */
public class Compressor2 extends Command {
    Relay compressor = RobotMap.gripper;
    public Compressor2() {
        
    }
    
    protected void initialize() {
        
    }
    
    protected void execute() {
        compressor.set(Relay.Value.kOn);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
        compressor.set(Relay.Value.kOff);
    }
    
    protected void interrupted() {
        compressor.set(Relay.Value.kOff);
    }
}
