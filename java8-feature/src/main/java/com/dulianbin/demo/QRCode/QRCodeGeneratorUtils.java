package com.dulianbin.demo.QRCode;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGeneratorUtils {

    //private static final String QR_CODE_IMAGE_PATH = "/mnt/sftp/mysftp/upload/img/qrcode/42543434.png";
    private static final String QR_CODE_IMAGE_PATH = "D:\\test\\";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static String create(String text){
        try {
            String randomImg=createRandomCode(100000)+".png";
            String filePath =QR_CODE_IMAGE_PATH+randomImg;
            generateQRCodeImage(text, 350, 350, filePath);
            return randomImg;
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        return null;
    }

    public static String createRandomCode(int size){
        return new Random().nextInt(size)+size+"";
    }



    public static void main(String[] args) {
        System.out.println(create("5325356436362345"));

        //System.out.println(createRandomCode(100000));
    }


}
