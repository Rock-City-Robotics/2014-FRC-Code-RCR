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
    SpeedController speedControllerLS = RobotMap.driveSpeedControllerLazySusan;
    Counter lSE = RobotMap.LSE;
    
    public LazySusan() {
        super("LazySusan", 0.75, .035, 0.0);
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
}
