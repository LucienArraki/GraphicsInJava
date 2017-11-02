import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zad4_2 {
    public static void main(String[] args)
    {
        System.out.println("Ring pattern synthesis");

        BufferedImage image;

        // Image resolution
        int x_res, y_res;

        // Ring center coordinates
        int x_c, y_c;

        // Predefined black and white RGB representations
        // packed as integers
        int black, white;

        // Loop variables - indices of the current row and column
        int i, j;

        // Fixed ring width
        final int w = 10;

        // Get required image resolution from command line arguments
        x_res = 0;
        y_res = 0;
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        try{
            img1 = ImageIO.read(new File("img1.jpg"));
            img2 = ImageIO.read(new File("img2.jpg"));
            // Get required image resolution from command line arguments
            x_res = img1.getWidth();
            y_res = img1.getHeight();
        }catch(Exception e){}

        // Initialize an empty image, use pixel format
        // with RGB packed in the integer data type
        image = new BufferedImage( x_res, y_res,
                BufferedImage.TYPE_INT_RGB);

        // Create packed RGB representation of black and white colors
        black = int2RGB( 0, 0, 0 );
        white = int2RGB( 255, 255, 255 );

        // Find coordinates of the image center
        x_c = x_res / 2;
        y_c = y_res / 2;

        // Process the image, pixel by pixel
        for ( i = 0; i < y_res; i++)
            for ( j = 0; j < x_res; j++)
            {
                double d;
                int r;

                // Calculate distance to the image center
                d = Math.sqrt( (i-y_c)*(i-y_c) + (j-x_c)*(j-x_c) );
                // Find the ring index

                int f = (int)(128 * Math.sin(d/w)+128);

                Color c1 = new Color(img1.getRGB(j, i));
                Color c2 = new Color(img2.getRGB(j, i));

                int red = (int)(f*c1.getRed()/255 + (255-f)*c2.getRed()/255);
                int green = (int)(f*c1.getGreen()/255 + (255-f)*c2.getGreen()/255);
                int blue = (int)(f*c1.getBlue()/255 + (255-f)*c2.getBlue()/255);

                int color = int2RGB(red,green,blue);
                image.setRGB(j, i, color);
            }

        // Save the created image in a graphics file
        try
        {
            ImageIO.write( image, "bmp", new File( "Zad4_2.bmp" ) );
            System.out.println( "Ring image created successfully");
        }
        catch (IOException e)
        {
            System.out.println( "The image cannot be stored" );
        }
    }

    // This method assembles RGB color intensities into single
    // packed integer. Arguments must be in <0..255> range
    static int int2RGB( int red, int green, int blue)
    {
        // Make sure that color intensities are in 0..255 range: red = red & 0x000000FF;
        green = green & 0x000000FF;
        blue = blue & 0x000000FF;

        // Assemble packed RGB using bit shift operations
        return (red << 16) + (green << 8) + blue;
    }
}
