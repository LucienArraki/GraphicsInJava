import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Zad3_1 {
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
        final int w = 40;

        int n = 5;
        // Get required image resolution from command line arguments
        x_res = 520;
        y_res = 520;

        // Initialize an empty image, use pixel format
        // with RGB packed in the integer data type
        image = new BufferedImage( x_res, y_res,
                BufferedImage.TYPE_INT_RGB);

        // Create packed RGB representation of black and white colors
        black = int2RGB( 0, 0, 0 );
        white = int2RGB( 200, 200, 200 );

        // Find coordinates of the image center
        x_c = x_res / 2;
        y_c = y_res / 2;

        // Process the image, pixel by pixel
        for ( i = 0; i < y_res; i++)
            for ( j = 0; j < x_res; j++)
            {
                int x = x_res / n;
                int y = y_res / n;
                x_c = x/2+(i*n)/x_res*x;
                y_c = y/2+(j*n)/x_res*y;

                double d = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));
                if(d<w)
                    image.setRGB(i, j, black);
                else
                    image.setRGB(i, j, white);
            }

        // Save the created image in a graphics file
        try
        {
            ImageIO.write( image, "bmp", new File( "Zad3_1.bmp" ) );
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
