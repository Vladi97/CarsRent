/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author vmata
 */
public class Image {

    /**
     *
     * @param width of the image
     * @param height of the image
     * @param fileName (The name of the image file)
     * @returns an Icon
     */
    public static Icon getIcon(int width, int height, String fileName) {
        try {
            ImageIcon icon = new ImageIcon("C:\\Users\\vmata\\Desktop\\CarsRent\\CarsRent\\src\\Images\\" + fileName);
            java.awt.Image img = icon.getImage();
            java.awt.Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            System.out.println("C:\\Users\\vmata\\Desktop\\CarsRent\\CarsRent\\src\\Images\\" + fileName);
            return icon;
        } catch (Exception e) {
        }
        return null;
    }
}
