/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.GenericEntry;
//import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This is a singleton class that will hold all the Shuffleboard entries. This class
 * is where the Shuffleboard layout will be taken care of.  A singleton class is 
 * a class instance where there is only one of them instantiated.  It allows a nice
 * communication method for each of the Subsystems to be able to talk to each other
 * through well-known Network Table entries.
 * 
 * This should enable things like the Drivetrain directing the LED subsystem  
 * bits of information that the LEDs  can communicate to the drive team.
 * 
 * It will take care of giving access to all the various pieces of information
 */
public class ShuffleboardInfo {
    // One tab for each subsystem (or informational piece)
    //private final GenericEntry m_driver_tab; /*, m_auto_tab, m_climber_tab, m_intake_tab, m_shooter_tab, m_vision_tab;*/

    // Driver Tab Entries
    private final GenericEntry m_LowGearEntry, m_IntakeOn, m_Shooting, m_ClimberUp, m_isTargetValid, m_bottomBeam, m_2ndBeam, m_3rdBeam, m_topBeam;

    // Temporary Tuning values
    private final GenericEntry m_kpSteer, m_kpDrive;
    // private constructors is how you can create a singleton, then provide some 
    // sort of accessor method like getInstance(). Then the getinstance checks
    // whether or not we have an instantiated instance, and if not, then creates 
    // it.
    private static ShuffleboardInfo instance = null;

    private ShuffleboardInfo(){
        // Create the various tabs
        //m_auto_tab = Shuffleboard.getTab("Autonomous");
       // m_led_tab = Shuffleboard.getTab("LEDs");
        //m_driver_tab = Shuffleboard.getTab("Driver");
        
        //m_climber_tab = Shuffleboard.getTab("Climber");
        //m_intake_tab = Shuffleboard.getTab("Intake");
        //m_shooter_tab = Shuffleboard.getTab("Shooter");
        //m_vision_tab = Shuffleboard.getTab("Vision");

        // Setup the Driver tab
        m_LowGearEntry = Shuffleboard.getTab("Driver").add("Low Gear", false)
        .withPosition(0,1)
        .withSize(1, 1)
        .withWidget(BuiltInWidgets.kBooleanBox)
        .getEntry();

        m_IntakeOn = Shuffleboard.getTab("Driver").add("Intake On", false)
            .withPosition(1, 1)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        m_Shooting = Shuffleboard.getTab("Driver").add("Shooting", false)
            .withPosition(2, 1)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();
        
        m_ClimberUp = Shuffleboard.getTab("Driver").add("Climber Up", false)
            .withPosition(3, 1)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        // Shuffleboard.getTab("Driver").add("Limelight", new HttpCamera("Limelight", "http://10.18.95.11:5800/stream.mjpg"))
        //     .withWidget(BuiltInWidgets.kCameraStream)
        //     .withPosition(4, 0)
        //     .withSize(3, 3);
        
        m_isTargetValid = Shuffleboard.getTab("Driver").add("Valid Target?", false)
            .withPosition(2, 0)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        m_bottomBeam = Shuffleboard.getTab("Driver").add("Bottom Broken?", false)
            .withPosition(0, 2)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        m_2ndBeam = Shuffleboard.getTab("Driver").add("2nd Broken?", false)
            .withPosition(1, 2)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        m_3rdBeam = Shuffleboard.getTab("Driver").add("3rd Broken?", false)
            .withPosition(2, 2)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();

        m_topBeam = Shuffleboard.getTab("Driver").add("Top Broken?", false)
            .withPosition(3, 2)
            .withSize(1, 1)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .getEntry();
        
        // Setup the Vision
        m_kpSteer = Shuffleboard.getTab("VisionAlign").add("Steering KP", -0.055).getEntry();
        m_kpDrive = Shuffleboard.getTab("VisionAlign").add("Drive KP", -0.055).getEntry();
        // Setup the LED tab information


    }

    public static ShuffleboardInfo getInstance(){
        if( instance == null ){
            instance = new ShuffleboardInfo();
        }

        return instance;
    }

    public GenericEntry getDriverLowGearEntry(){
        return m_LowGearEntry;
    }

    public GenericEntry getShootingEntry() {
        return m_Shooting;
    }

    public GenericEntry getIntakeOnEntry() {
        return m_IntakeOn;
    }

    public GenericEntry getClimberUpEntry() {
        return m_ClimberUp;
    }

    public GenericEntry getTargetEntry() {
        return m_isTargetValid;
    }

    public GenericEntry getBottomBeamEntry() {
        return m_bottomBeam;
    }

    public GenericEntry get2ndBeamEntry() {
        return m_2ndBeam;
    }

    public GenericEntry get3rdBeamEntry() {
        return m_3rdBeam;
    }

    public GenericEntry getTopBeamEntry() {
        return m_topBeam;
    }

    public GenericEntry getKPsteerEntry() {
        return m_kpSteer;
    }

    public GenericEntry getKPDriveEntry(){
        return m_kpDrive;
    }
    
	public void addAutoChooser(SendableChooser<Command> m_auto_chooser) {
        Shuffleboard.getTab("Driver").add("Autonomous Chooser", m_auto_chooser)
            .withWidget(BuiltInWidgets.kComboBoxChooser)
            .withPosition(0, 0)
            .withSize(2, 1);
	}
}