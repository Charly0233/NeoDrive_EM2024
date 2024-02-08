package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveTrain;
import frc.robot.subsystems.*;
import frc.robot.commands.Joysticks;

public class Robot extends TimedRobot {
  
  private final XboxController controller = new XboxController(0);
  private final DriveTrain swerve = DriveTrain.getInstance();
  private final double DEADBAND = 0;
  private boolean FieldRelativeTeleop = true;

  private Spark leftMotor1 = new Spark(0);
  private Spark leftMotor2 = new Spark(1);
  private Spark rightMotor1 = new Spark(2);
  private Spark rightMotor2 = new Spark(3);

  private Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);
  private final double kDriveTick2Feet = 1.0 / 128 * 6 * Math.PI / 12;


  @Override
  public void robotInit() {
    SmartDashboard.putBoolean("FieldRelativeTeleop", FieldRelativeTeleop);

  @Override
  public void robotPeriodic(){
    swerve.periodic();
  } 

  @Override
  public void teleopPeriodic() {
    boolean FRT = SmartDashboard.getBoolean("FieldRelativeTeleop", true);
    if(FRT != FieldRelativeTeleop){ FieldRelativeTeleop = FRT;}
    driveWithController(FieldRelativeTeleop);
  }

  @Override
  public void autonomousInit() {
    //encoder. 
    encoder.reset();
  }

  final double kP = 0.5;

  double setpoint = 0;

  @Override
  public void autonomousPeriodic() {
    // get joystick command
    if (joy1.getRawButton(1)) {
      setpoint = 10;
    } else if (joy1.getRawButton(2)) {
      setpoint = 0;
    }

    double sensorPosition = encoder.get() * DriveTick2Feet;

    // calculations
    double error = setpoint - sensorPosition;

    double outputSpeed = kP * error;

    // output to motors
    leftMotor1.set(outputSpeed);
    leftMotor2.set(outputSpeed);
    rightMotor1.set(-outputSpeed);
    rightMotor2.set(-outputSpeed);
  }

  @Override
  public void robotPeriodic(){
    swerve.periodic(Start);
    Joysticks.Start(controller.getAButton())
    //Función para que entre en movimiento a 10 m 
    
  } 

  private void driveWithController(boolean fieldRelative){
    var xSpeed = MathUtil.applyDeadband(controller.getLeftX(), DEADBAND);
    var ySpeed = -MathUtil.applyDeadband(controller.getLeftY(), DEADBAND);
    var rot = -MathUtil.applyDeadband(controller.getRightX(), DEADBAND);
    swerve.drive(xSpeed, ySpeed, rot, fieldRelative);
  }
}

