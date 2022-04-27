package Misc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class Util {
    public static ImageIcon scaleImage(ImageIcon icon, double scale)
    {
        int w = (int)(scale * icon.getIconWidth());
        int h = (int)(scale * icon.getIconHeight());
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_SMOOTH));
    }

    public static ImageIcon Blob_to_Image(byte[] img)
    {
        ImageIcon ret = null;

        try{
            ByteArrayInputStream inStreambj = new ByteArrayInputStream(img);
            BufferedImage image = ImageIO.read(inStreambj);

            ret = new ImageIcon(image.getScaledInstance(202, (int)((202.0 / image.getWidth()) * image.getHeight()), Image.SCALE_SMOOTH));
        }
        catch (Exception e)
        {
            System.out.println("Cannot load image");
        }
        return ret;
    }

}
