package algorithms;

import java.awt.event.MouseWheelEvent;
import java.io.*;
import java.util.Random;

import Data.Point;

public class GenerateData {
	private static final int  NUM = 1000000;
	private static Point[]points = new Point[NUM];
	public static void main(String[] args) throws FileNotFoundException {
		GenerateData generateData = new GenerateData();
		File file = new File("E://data.txt");
		PrintWriter pw = new PrintWriter(file);
		for(int i = 0; i < 100; i++) {
			generateData.getRandom(points);
			System.out.println("第" + i + "批数据已生成!");
			for(int j = 0; j < NUM; j++) {
				pw.write(points[j].getX() + "," + points[j].getY() + "\n");
			}
		}
		pw.close();
	}
	public void getRandom(Point[]p) {
		int l = p.length;
		Random random = new Random(1000);
		for(int i = 0; i < l; i++) {
			double x = random.nextDouble() * 10000 + 1;
			double y = random.nextDouble() * 10000 + 1;
			p[i] = new Point(x, y);
		}
	}
	
	
}
