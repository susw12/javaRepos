package mr.gonzalez.aoa.exercise6;
import images.APImage;
import images.Pixel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Graph centrality, triangles, and clustering exercise
 *
 * <p>Removes "extra" or dull parts of an image using Dykstra's Algorithm and the APImage API.</p>
 *
 *
 * AoA Exercise 06: Seam Carving
 * 4/28/19
 *
 * @author Sujay Swain
 */

public class SeamCarving {
	/**
	 * Seam carves the picture
	 *
	 * <p>Asks for amount of carves wanted and seam carves the image based on Dykstra's algorithm and a modified gradient magnitude weighting system.</p>
	 *
	 *
	 * @author Sujay Swaiin
	 */
	public static void main(String[] args) {
		APImage editableImg = new APImage("image.jpg");
		editableImg.draw();
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number seams to remove: ");
		int n = reader.nextInt();
		for (int counter = 0; counter < n; counter++) {
			APImage weightedImg = weightedImage(editableImg);
			//editableImg.draw();
			//weightedImg.draw();
			int[][] weights = new int[editableImg.getHeight()][editableImg.getWidth()];
			for (int y = 0; y < editableImg.getHeight(); y++) {
				for (int x = 0; x < editableImg.getWidth(); x++) {
					if (y == 0) {
						weights[y][x] = (Integer) (int) Math.abs((Math.pow(weightedImg.getPixel(x, y).getBlue(), 2) - Math.pow(weightedImg.getPixel(x, y + 1).getBlue(), 2)));
					} else if (y == editableImg.getHeight() - 1) {
						weights[y][x] = (Integer) (int) Math.abs((Math.pow(weightedImg.getPixel(x, y).getBlue(), 2) - Math.pow(weightedImg.getPixel(x, y - 1).getBlue(), 2)));
					} else {
						weights[y][x] = (Integer) (int) Math.abs((Math.pow(weightedImg.getPixel(x, y).getBlue(), 2) - Math.pow((weightedImg.getPixel(x, y + 1).getBlue() + weightedImg.getPixel(x, y - 1).getBlue()) / 2, 2)));
					}
				}
			}
			ArrayList<ArrayList<Integer>> weightsArrayList = new ArrayList<>();
			for (int i = 0; i < editableImg.getHeight(); i++) {
				weightsArrayList.add(new ArrayList<>());
				for (int j = 0; j < editableImg.getWidth(); j++) {
					weightsArrayList.get(i).add(weights[i][j]);
				}
			}
			int[] xPos = new int[editableImg.getHeight()];
			for (int y = 0; y < editableImg.getHeight()-1; y++) {
				if (y == 0) {
					xPos[y] = weightsArrayList.get(y).indexOf(Collections.min(weightsArrayList.get(y)));
				} else {
					ArrayList<Integer> aboveVal = new ArrayList<>();
					try {
						aboveVal.add(weightsArrayList.get(y).get(xPos[y - 1] - 1));
					} catch (IndexOutOfBoundsException e) {
					}
					aboveVal.add(weightsArrayList.get(y).get(xPos[y - 1]));
					try {
						aboveVal.add(weightsArrayList.get(y).get(xPos[y - 1] + 1));
					} catch (IndexOutOfBoundsException e1) {
					}
					if (aboveVal.indexOf(Collections.min(aboveVal)) - 1 + xPos[y-+ 1] < 0) {
						xPos[y] = 0;
					} else {
						xPos[y] = aboveVal.indexOf(Collections.min(aboveVal)) - 1 + xPos[y - 1];
					}
				}
			}
			APImage updateImage = new APImage(editableImg.getWidth() - 1, editableImg.getHeight());
			for (int y = 0; y < editableImg.getHeight() - 1; y++) {
				for (int x = 0; x < editableImg.getWidth(); x++) {
					if (x < xPos[y])
						updateImage.setPixel(x, y, editableImg.getPixel(x, y));
					else if (x > xPos[y]) {
						updateImage.setPixel(x - 1, y, editableImg.getPixel(x, y));
					}
				}
			}

			editableImg = updateImage;
		}
		editableImg.draw();
		editableImg.saveAs();
	}

	/**
	 * Grayscales it
	 *
	 * <p>Creates a grayscale image to use to find the weights of each pixel.</p>
	 *
	 *
	 * @author Sujay Swaiin
	 * @param seamCarveImage an image
	 * @return weightedImage a grayscale image
	 */
	public static APImage weightedImage(APImage seamCarveImage) {
		APImage weightedImage = new APImage(seamCarveImage.getWidth(), seamCarveImage.getHeight());
		for (int y = 0; y < seamCarveImage.getHeight(); y++) {
			for (int x = 0; x < seamCarveImage.getWidth(); x++){
				Pixel regImage = seamCarveImage.getPixel(x, y);
				Pixel weightedPixel = new Pixel(0, 0, 0);
				weightedPixel.setBlue(colorAverage(regImage));
				weightedPixel.setGreen(colorAverage(regImage));
				weightedPixel.setRed(colorAverage(regImage));
				weightedImage.setPixel(x, y, weightedPixel);
			}
		}
		return weightedImage;

	}

	/**
	 * Average function
	 *
	 * <p>Averages RGB values</p>
	 *
	 *
	 * @author Sujay Swaiin
	 * @param pixel A pixel
	 * @return average color value
	 */
	public static int colorAverage(Pixel pixel) {
		return (pixel.getBlue() + pixel.getGreen() + pixel.getRed())/3;
	}

}
