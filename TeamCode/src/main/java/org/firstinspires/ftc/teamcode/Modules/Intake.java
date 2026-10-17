package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor Intake1, Intake2;

    public Intake (HardwareMap hardwareMap){
        Intake1=hardwareMap.get(DcMotor.class , "intakeM1");
        Intake2=hardwareMap.get(DcMotor.class, "intakeM2");
    }

    public void IntakeStart(){Intake1.setPower(1);}
    public void IntakeStop(){Intake1.setPower(0);}

}
