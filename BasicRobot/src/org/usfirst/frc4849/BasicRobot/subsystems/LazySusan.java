/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4849.BasicRobot.RobotMap;

/**
 *
 * @author Cale
 */
public class LazySusan extends PIDSubsystem {
    SpeedController speedControllerLS = null;
    Counter lSE = RobotMap.LSE;
    
    public LazySusan() {
        super("LazySusan", 0.5, .035, 0.0);
        getPIDController().setContinuous(false);
        lSE.start();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
    protected double returnPIDInput() {
        double period = lSE.getPeriod();
        double percent = period / 0.004096;
        SmartDashboard.putNumber("PID IN", percent);
        return percent;
    }
    
    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("PID OUT", output);
        speedControllerLS.pidWrite(output);
    }
    
    public void spinCounterClockwise() {
        double input = returnPIDInput();
        while(input < 0.486) {
            speedControllerLS.set(0.2);
            input = returnPIDInput();
        }
        speedControllerLS.set(0);
    }
    
    public void spinClockwise() {
        double input = returnPIDInput();
        while(input > 0.89) {
            speedControllerLS.set(-0.2);
            input = returnPIDInput();
        }
        speedControllerLS.set(0);
    }
}
