package Misc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    public static final Color _barColor = new Color(147, 112, 219);
    public static final Color _bodyColor = new Color(250, 235, 215);

    public static enum Emode {Modificar, Anadir, Consultar};

    //public static final Color _barColor = new Color(49, 55, 70);
    //public static final Color _bodyColor = new Color(250, 235, 215);

    /**
     * esta clase sirve para escalar una imagen en otra de distinto tamaño
     * metiendo sus dimensiones en enteros locales y creando nuevas dimensiones con
     * la escala pasada por parametro
     * @param icon por aqui se pasa una imagen de tipo ImageIcon que va a ser reescalada
     * @param scale este es el numero en el que la imagen va a ser reescalada (ej. 0,5 para la mitad ; 0,25 para un cuarto...)
     * @return devuelve un nuevo ImageIcon con dimensiones reescaladas
     */
    public static ImageIcon scaleImage(ImageIcon icon, double scale) {
        int w = (int) (scale * icon.getIconWidth());
        int h = (int) (scale * icon.getIconHeight());
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_SMOOTH));
    }
    //TODO JAVADOC blob to image
    /**
     * funcion que se encarga de transformar un blob almacenado (bytes de arrays)  en la base de datos en una imagen
     * @param img
     * @return
     */
    public static ImageIcon Blob_to_Image(byte[] img) {
        ImageIcon ret = null;

        try {
            ByteArrayInputStream inStreambj = new ByteArrayInputStream(img);
            BufferedImage image = ImageIO.read(inStreambj);

            double size = 215;
            ret = (image.getHeight() < image.getWidth()) ? new ImageIcon(image.getScaledInstance((int) size, (int) ((size / image.getWidth()) * image.getHeight()), Image.SCALE_SMOOTH)) : new ImageIcon(image.getScaledInstance((int) ((size / image.getHeight()) * image.getWidth()), (int) size, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Cannot load image");
        }
        return ret;
    }
    //TODO JAVADOC HASH256
    public static String hash256(String input) {

        // Static getInstance method is called
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
        }


        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, digest);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString().toUpperCase();
    }

    //DAO UTILS
    private static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";
    public static Connection conn;
    public static void startConnection()
    {
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection opened");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void closeConnection()
    {
        try {
            conn.close();
            System.out.println("Connection closed");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


