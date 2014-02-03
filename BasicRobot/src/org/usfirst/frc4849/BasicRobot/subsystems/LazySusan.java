/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4849.BasicRobot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4849.BasicRobot.RobotMap;

/**
 *
 * @author Cale
 */
public class LazySusan extends Subsystem {
    SpeedController speedControllerLS = RobotMap.driveSpeedControllerLazySusan;
    
    public void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
}
