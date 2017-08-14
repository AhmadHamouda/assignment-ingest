package com.iceye.assignments.service;

import com.iceye.assignments.exception.ImageNotExist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Service
public class ImageService {

    @Value("${image.base.get.url}")
    private String imageBaseGetURL;
    @Value("${images.base.path}")
    private String imagesBasePath;
    private int charWidth = 20;
    private int charHeight = 40;
    private int shift = 50;

    public String saveTextAsImage(String text) throws IOException {

        String[] lines = text.split("\n");
        BufferedImage bufferedImage = createImage(lines);
        drawTextOnImage(lines, bufferedImage);

        return saveImage(bufferedImage);
    }

    private BufferedImage createImage(String[] lines) {
        int textHeight = lines.length;
        int textWidth = 0;
        for (int i = 0; i < textHeight; i++) {
            if (lines[i].length() > textWidth) {
                textWidth = lines[i].length();
            }
        }
        return new BufferedImage(charWidth * textWidth + shift, charHeight * textHeight + shift,
                BufferedImage.TYPE_INT_RGB);
    }

    private void drawTextOnImage(String[] lines, BufferedImage bufferedImage) {
        Graphics g = bufferedImage.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        int lineHeight = g.getFontMetrics().getHeight();
        for (int lineCount = 0; lineCount < lines.length; lineCount++) {
            int xPos = shift;
            int yPos = shift + lineCount * lineHeight;
            String line = lines[lineCount];
            g.drawString(line, xPos, yPos);
        }
        g.dispose();
    }


    private String saveImage(BufferedImage bufferedImage) throws IOException {

        File image = new File(getImagePath());
        image.getParentFile().mkdirs();
        ImageIO.write(bufferedImage, "jpeg", image);
        System.out.println(imageBaseGetURL);
        return imageBaseGetURL + image.getAbsolutePath();
    }

    public String getImagePath() {
        String format = "yyyy-MM-dd";
        DateFormat dateFormatter = new SimpleDateFormat(format);
        String today = dateFormatter.format(new Date());
        return imagesBasePath + File.separator + today + File.separator + java.util.UUID.randomUUID() + ".jpeg";
    }

    public InputStream getImage(String imageURl) throws FileNotFoundException {
        try {
            FileInputStream image = new FileInputStream(imageURl);
            return image;
        } catch (FileNotFoundException ex) {
            throw new ImageNotExist();
        }
    }
}
