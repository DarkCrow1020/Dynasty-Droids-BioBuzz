package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class DriveTrain {
    private DcMotor fl, fr, bl, br;
    private PinPoint pinPoint;
    double targetAngle = 90;
    public DriveTrain(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "frontLeft");
        fr = hardwareMap.get(DcMotor.class, "frontRight");
        bl = hardwareMap.get(DcMotor.class, "backLeft");
        br = hardwareMap.get(DcMotor.class, "backRight");
        pinPoint= new PinPoint(hardwareMap);
        fl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.FORWARD);



    }

    public void drive(double forward, double strafe, double rotate) {
        double flp = forward + strafe + rotate;
        double frp = forward - strafe - rotate;
        double blp = forward - strafe + rotate;
        double brp = forward + strafe - rotate;

        double max = Math.max(Math.max(Math.abs(flp), Math.abs(frp)),
                Math.max(Math.abs(blp), Math.abs(brp)));

        if (max > 1.0) {
            flp /= max; frp /= max; blp /= max; brp /= max;
        }

        fl.setPower(flp);
        fr.setPower(frp);
        bl.setPower(blp);
        br.setPower(brp);
    }
    public double AngleUpdate (){
        double x= pinPoint.GetX(), y=pinPoint.GetY();
        double xBasketRedFront=15,yBasketRedFront=15,xBasketRedBack=15,yBasketRedBack=-15;
        double Lenght,Width;
        double angleNeeded;
        if(y<0){
            Lenght = yBasketRedFront - y; Width  = xBasketRedFront - x;
        }else {
            Lenght = yBasketRedBack - y;Width  = xBasketRedBack - x;
        }
        angleNeeded = Math.toDegrees(Math.atan2(Lenght, Width));
        return angleNeeded;
    }
    public void aimBasket (double targetAngle){
        targetAngle=AngleUpdate();
        double heading = pinPoint.GetHeading();
        double error = targetAngle - heading;
        while (error > 180) error -= 360;
        while (error < -180) error += 360;
        double turnPower = error * 0.01;
        turnPower = Math.max(-0.6, Math.min(0.6, turnPower));
        drive(0, 0, turnPower);
        if (Math.abs(error) < 2) {
            drive(0, 0, 0);
        }
    }


}