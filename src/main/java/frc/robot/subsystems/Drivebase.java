// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {}

  CANSparkMax m_leftMotor = new CANSparkMax(0,MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(1,MotorType.kBrushless);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  SparkMaxAlternateEncoder m_leftEncoder = m.leftMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature,20);
  SparkMaxAlternateEncoder m_rightEncoder = m.rightMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature,20);

  public void arcadeDrive(double forwardSpeed, double rotationSpeed){
    m_drive.arcadeDrive(forwardSpeed, rotationSpeed);
  }

  public void resetEncoders(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftDistanceInch(){
    return (m_leftEncoder.getPosition() * diameter * Math.PI);
  }

  public void getRightDistanceInch(){
    return (m_leftEncoder.getPosition() * diameter * Math.PI);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}