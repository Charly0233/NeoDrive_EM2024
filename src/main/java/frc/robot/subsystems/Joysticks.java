public class Joysticks {
    public class Joysticks extends package frc.robot.subsystems;

package frc.robot.subsystems; 

import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.math.controller.PIDController; 

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    
  }

  @Override
  public void periodic(double _input) {
    // This method will be called once per scheduler run
    motor.set(_input);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
 

/*{
    
    public static void main(String[] args) {
        double kP = 5;
        double kI = 0.1;
        double kD = 0.2;


        // Creates a PIDController with gains kP, kI, and kD.
        PIDController pid = new PIDController(kP, kI, kD);
        double calculPID = pid.calculate(encoder.getDistance());

        double output = pid.calculate(sensorReading); 

        motor.set(calculPID, 0); 

        // Enables continuous input on a range from -180 to 180.
        pid.enableContinuousInput(-180, 180);

        //System.out.print("PID: " + valor); 

    }
}

*/
}
