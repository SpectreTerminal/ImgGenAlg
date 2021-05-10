package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Input/output operations.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class IO {
	private static String type;

	/**
	 * Using the buffered reader, extract the pixel data.
	 * 
	 * @param br - buffered reader reading from the file
	 * @param width - width of the image
	 * @param height - height of the image
	 * @return pixel data
	 * @throws IOException
	 */
	private static Pixel[] getPixelData(BufferedReader br, int width, int height) throws IOException {
		Pixel[] data = new Pixel[width * height];
		String line;
		int counter = 0;
		while((line = br.readLine()) != null) {
			String[] info = line.split(" ");
			// for the row, create the associated pixels
			for(int i = 0; i < info.length; i += 3) {
				int r = Integer.parseInt(info[i]);
				int g = Integer.parseInt(info[i + 1]);
				int b = Integer.parseInt(info[i + 2]);
				Pixel p = new Pixel(r, g, b);
				data[counter] = p;
				// move to the next pixel
				counter++;
			}
		}
		return data;
	}
	
	/**
	 * Using the buffered writer, write the pixel data to the file.
	 * 
	 * @param bw - buffered writer
	 * @param img - PPM image
	 * @throws IOException
	 */
	private static void writePixelData(BufferedWriter bw, PPMImage img) throws IOException{
		int width = img.getWidth();
		int height = img.getHeight();
		Pixel[] data = img.getData();
		
		// iterate through each pixel and write
		for(int row = 0; row < height; row++) {
			for(int column = 0; column < width; column++) {
				// get pixel at (row, column)
				Pixel p = data[row * width + column];
				int r = p.getR();
				int g = p.getG();
				int b = p.getB();
				bw.write(r + " " + g + " " + b + " ");
			}
			bw.newLine();
		}
	}

	/**
	 * Read a PPM image from a file
	 * 
	 * @param filename - file name
	 * @return ideal PPM image
	 */
	public static PPMImage readImage(String filename) {
		PPMImage image = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// first line contains the type
			type = br.readLine();

			// second line has the dimensions
			String dim = br.readLine();
			String[] dimArray = dim.split(" ");
			int width = Integer.parseInt(dimArray[0]);
			int height = Integer.parseInt(dimArray[1]);

			// third line has max colour
			int maxColour = Integer.parseInt(br.readLine());

			// get pixel data
			Pixel[] data = getPixelData(br, width, height);
			br.close();
			image = new PPMImage(data, width, height, maxColour);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Write a PPM image to a file
	 * 
	 * @param filename - file name
	 * @param img      - PPM image to write
	 */
	public static void writeImage(String filename, PPMImage img) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			// write header info
			bw.write(type);
			bw.newLine();
			bw.write(img.getWidth() + " " + img.getHeight());
			bw.newLine();
			bw.write(Integer.toString(img.getMaxColour()));
			bw.newLine();
			
			// write pixel data
			writePixelData(bw, img);
			bw.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
