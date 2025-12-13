package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MotorTest extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private   DcMotor backRight;

    private DcMotor shooterRight;
    private DcMotor shooterLeft;
    private DcMotor intake;

    @Override
    public void runOpMode() throws InterruptedException {
        // initialize
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, " frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterRight = hardwareMap.get(DcMotor.class, "shooterRight");
        shooterLeft = hardwareMap.get(DcMotor.class,"shooterLeft");
        intake = hardwareMap.get(DcMotor.class,"intake");

        shooterRight.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                frontLeft.setPower(1);
            }
            else frontLeft.setPower(0);

            if (gamepad1.b) {
                frontRight.setPower(1);
            }
            else frontRight.setPower(0);

            if (gamepad1.dpad_up) {
                backLeft.setPower(1);
            }
            else backLeft.setPower(0);

            if (gamepad1.dpad_down) {
                backRight.setPower(1);
            }
            else backRight.setPower(0);
            if(gamepad1.a){
                shooterRight.setPower(Constant.shooterPower);
                shooterLeft.setPower(1);
            }
            else {
                shooterRight.setPower(Constant.shooterPower);
                shooterLeft.setPower(0);
            }
            if(gamepad1.b)intake.setPower(Constant.intakePower);
            else intake.setPower(0);
        }
        //finish
    }
}
