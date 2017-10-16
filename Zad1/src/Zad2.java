import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zad2 {
        public Zad2(String name)
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
            x_res = 0;
            y_res = 0;
            BufferedImage img = null;
            try{
                img = ImageIO.read(new File(name));
                // Get required image resolution from command line arguments
                x_res = img.getWidth();
                y_res = img.getHeight();
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
                    boolean right = (i+j)/w % 2 == 1;
                    boolean left = (i-j+x_res)/w % 2 == 0;
                    if (right && left || !right && !left )
                        // Even ring - set black color
                        //if(left)
                        image.setRGB( j, i, black );
                    else
                        // Odd ring - set white color
                        image.setRGB( j, i, img.getRGB(j, i));
                }

            // Save the created image in a graphics file
            try
            {
                ImageIO.write( image, "bmp", new File( "Zad2.bmp" ) );
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
