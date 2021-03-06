// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4849.BasicRobot;

import org.usfirst.frc4849.BasicRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked forward to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held back and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick gamepad2;
    public Joystick leftjoy;
    public Joystick rightjoy;
    public Joystick gamepad;
    public DigitalOutput digOUt;
    public DigitalInput swith;
    public DigitalInput tripLever1;
    public DigitalInput tripLever4;
    //public static Counter lSE;
    public JoystickButton back;
    public JoystickButton forward;
    public JoystickButton left;
    public JoystickButton right;
    public JoystickButton up;
    public JoystickButton down;
    public JoystickButton trigger;
    public JoystickButton trigger2;
    public DigitalOutput light1;
    public DigitalOutput light2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightjoy = new Joystick(3);
        
        leftjoy = new Joystick(2);
        
        gamepad2 = new Joystick(1);
        
        gamepad = new Joystick(4);
        
        //formally 2
        swith = new DigitalInput(4);
        
        // fully down, fomally 3
        tripLever1 = new DigitalInput(1);
        
        // fully up, formally 4
        tripLever4 = new DigitalInput(2);
        
        //lSE = new Counter(1);
         
        back = new JoystickButton(gamepad, 2);
        
        forward = new JoystickButton(gamepad, 4);
        
        left = new JoystickButton(gamepad, 1);
        
        right = new JoystickButton(gamepad, 3);
        
        up = new JoystickButton(gamepad, 6);
        
        down = new JoystickButton(gamepad, 8);
        
        trigger = new JoystickButton(gamepad, 5);
        
        trigger2 = new JoystickButton(gamepad, 7);
        
        //light1 = new DigitalOutput(1);
        
        //light2 = new DigitalOutput(2);
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("DriveSequence", new DriveSequence());
        
        //SmartDashboard.putNumber("LazySusanEncoder", lSE.get());
        
        SmartDashboard.putNumber("BatteryLevel", DriverStation.getInstance().getBatteryVoltage());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        forward.whenPressed(new LazySusanMovement(0.7));
        left.whenPressed(new LazySusanMovement(0.89));
        right.whenPressed(new LazySusanMovement(0.486));
        up.whileHeld(new ArmMovement(false));
        down.whileHeld(new ArmMovement(true));
        trigger.whileHeld(new Compressor2());
        
        //lSE.setSamplesToAverage(1);
        //lSE.setSemiPeriodMode(true);
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    public Joystick getleftjoy() {
        return leftjoy;
    }

    public Joystick getrightjoy() {
        return rightjoy;
    }
    
    public Joystick getgamepad() {
        return gamepad;
    }
    
    public DigitalOutput getDigitalOutput() {
        return digOUt;
    }
    
    public DigitalInput getDigitalInput2() {
        return swith;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

