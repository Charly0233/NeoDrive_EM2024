package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class exampleSubsistem extends SubsystemBase {
    
    private static final CANSparkMax motor = new CANSparkMax(11, MotorType.kBrushless);

    public exampleSubsistem(){
    }

    public void move(double _input){
        motor.set(_input);
    }

    @Override
    public void periodic(){
    }


}
