package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class PinPoint {
    GoBildaPinpointDriver pinpoint;
    static double x,y;
    public PinPoint(HardwareMap hardwareMap){
        pinpoint=hardwareMap.get(GoBildaPinpointDriver.class, "Pinpoint");

        pinpoint.setOffsets(0.0,-80.0, DistanceUnit.MM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pinpoint.resetPosAndIMU();
        x= pinpoint.getPosX(DistanceUnit.INCH);
        y= pinpoint.getPosY(DistanceUnit.INCH);
    }
    public void Update(){pinpoint.update();}
    public double GetX(){return pinpoint.getPosX(DistanceUnit.INCH);}
    public double GetY(){return  pinpoint.getPosY(DistanceUnit.INCH);}
    public double GetHeading(){return pinpoint.getHeading(AngleUnit.DEGREES);}
    public void SetPose(double x, double y, double heading) {
        pinpoint.setPosition(
                new Pose2D(
                        DistanceUnit.INCH,
                        x,
                        y,
                        AngleUnit.DEGREES,
                        heading ) );}
}


