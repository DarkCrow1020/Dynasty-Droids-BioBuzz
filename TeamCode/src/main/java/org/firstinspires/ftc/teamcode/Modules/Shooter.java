package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
  DcMotor Flywheel1,Shooter;
  private PinPoint pinPoint;
  Servo Hood;
  public Shooter(HardwareMap hardwareMap){
      Flywheel1= hardwareMap.get(DcMotor.class, "flywheel");
      Shooter= hardwareMap.get(DcMotor.class, "shooterM");
      Hood= hardwareMap.get(Servo.class,"Hood");
  }
}
