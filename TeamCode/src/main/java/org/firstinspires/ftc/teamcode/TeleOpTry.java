package org.firstinspires.ftc.teamcode;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class TeleOpTry extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor shooterLeft;
    private DcMotor shooterRight;
    private DcMotor intake;
    private Servo standRight;
    private Servo standLeft;



   // private boolean flag;

   // private double pose;

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void runOpMode() throws InterruptedException {
        // initialize
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        shooterLeft = hardwareMap.get(DcMotor.class, "shooterLeft");
        shooterRight = hardwareMap.get(DcMotor.class, "shooterRight");
        intake = hardwareMap.get(DcMotor.class,"intake");
        standRight = hardwareMap.get(Servo.class,"standRight");
        standLeft = hardwareMap.get(Servo.class,"standLeft");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterRight.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();
        while (opModeIsActive()) {
            //loop
            double y = -gamepad1.left_stick_y * Math.abs(gamepad1.left_stick_y)*Math.abs(gamepad1.left_stick_y); // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * Math.abs(gamepad1.left_stick_x)*Math.abs(gamepad1.left_stick_x)*1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x * Math.abs(gamepad1.right_stick_x)*Math.abs(gamepad1.right_stick_x);


            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            if (gamepad1.left_trigger > 0.05) {
                double speedMultiplier = 0.5;
                frontLeftPower *= speedMultiplier;
                backLeftPower *= speedMultiplier;
                frontRightPower *= speedMultiplier;
                backRightPower *= speedMultiplier;
            }

            frontLeft.setPower(frontLeftPower);
            backLeft.setPower(backLeftPower);
            frontRight.setPower(frontRightPower);
            backRight.setPower(backRightPower);

            if (gamepad1.a) {
                shooterLeft.setPower(Constant.shooterPower);
                shooterRight.setPower(Constant.shooterPower);

            }
            else {
              shooterLeft.setPower(0);
              shooterRight.setPower(0);
              }


            if(gamepad1.right_trigger>0.05){
                intake.setPower(Constant.intakePower);
                if(!gamepad1.a){
                    shooterRight.setPower(-Constant.shooterPower);
                    shooterLeft.setPower((-Constant.shooterPower));
                }else {
                    shooterLeft.setPower(Constant.shooterPower);
                    shooterRight.setPower(Constant.shooterPower);
                }
            } else if (gamepad1.a) {
                intake.setPower(0);
                shooterRight.setPower(Constant.shooterPower);
                shooterLeft.setPower(Constant.shooterPower);
            } else {
                intake.setPower(0);
                shooterLeft.setPower(0);
                shooterRight.setPower(0);
            }


            /*if (gamepad1.a) {
                shooterLeft.setPower(Constant.shooterPower);
                shooterRight.setPower(Constant.shooterPower);
            }*/




            if (gamepad1.y){//把车抬起来
                  standLeft.setPosition(Constant.standLeftDownPower);
                  standRight.setPosition(Constant.standRightDownPower);
              }
             if (gamepad1.x){//把车放下来
                 standLeft.setPosition(Constant.standLeftUpPower);
                 standRight.setPosition(Constant.standRightUpPower);
             }

               //if (gamepad1.y) {
                //flag = !flag;
            }

           // if(flag) servo.setPosition(1);
          //  else servo.setPosition(0);

        }
        //finish
    }

