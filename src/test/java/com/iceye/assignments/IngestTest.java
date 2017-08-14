package com.iceye.assignments;

import com.iceye.assignments.service.ImageService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
public class IngestTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    @Autowired
    private ImageService imageService;

    @Test
    public void testCreateImageOk() throws IOException {
        File tempFile = testFolder.newFile("file.txt");
        File tempFolder = testFolder.newFolder("folder");


        String key = "public static void main(String arg[]) throws IOException {\n" +
                "String key = \"Sample\";\n" +
                "BufferedImage bufferedImage = new BufferedImage(170, 30,                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);33333BufferedImage bufferedImage = new BufferedImage(170, 30,                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);                BufferedImage.TYPE_INT_RGB);33333\n" +
                "                BufferedImage.TYPE_INT_RGB);\n" +
                "Graphics graphics = bufferedImage.getGraphics();\n" +
                "        graphics.setColor(Color.LIGHT_GRAY);\n" +
                "        graphics.fillRect(0, 0, 200, 50);\n" +
                "        graphics.setColor(Color.BLACK);\n" +
                "        graphics.setFont(new Font(\"Arial Black\", Font.BOLD, 20));                \n" +
                "        graphics.drawString(key, 10, 25);\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "        ImageIO.write(bufferedImage, \"jpg\", new File(\n" +
                "                \"C:/Users/admin/desktop/image.jpg\"));\n" +
                "        System.out.println(\"Image Created\");";
//        String key="h";
        String[] lines = key.split("\n");
        int h = lines.length;
        System.out.println(h);
        int w = 0;
        for (int i = 0; i < h; i++) {
            if (lines[i].length() > w) {
                w = lines[i].length();
            }
        }
        BufferedImage bufferedImage = new BufferedImage(20 * w + 50, 40 * h + 50,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        int lineHeight = g.getFontMetrics().getHeight();
        for (int lineCount = 0; lineCount < lines.length; lineCount++) {
            int xPos = 50;
            int yPos = 50 + lineCount * lineHeight;
            String line = lines[lineCount];
            g.drawString(line, xPos, yPos);
        }
        g.dispose();
        File image = testFolder.newFile("image.jpg");
        ImageIO.write(bufferedImage, "jpg", image);
        Assert.assertTrue(image.exists());
    }
}
