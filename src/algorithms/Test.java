package algorithms;

import java.lang.Math;

import javax.xml.parsers.DocumentBuilder;

import Data.Point;
import java.io.*;
import java.util.*;
public class Test {
	private static final int NUM = 1000000;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		int []a = new int[]{2,3,4,1,6,8,5,5,10,9,17,20,15};
//		myalo.BubbleSort(a);
	    algorithms myalo = new algorithms();
	    Test test = new Test();
		int []a = new int[]{2, 3, 4, 1, 6, 8, 5, 10, 9, 1, 11, 4, 21, 0, 6, 10, 20, 29, -1, -67, 100, 5, 28};
//		myalo.InsertionSort(a);
//		test.print(a);
//		File file = new File("E://data.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		Point[]points = new Point[NUM];
//		int k = 0;
//		String line = "";
//		System.out.println("���ڶ�ȡ�ļ�");
//		while((line = br.readLine()) != null && k < NUM) {
//			if(line.isEmpty())
//				continue;
//			String[]XY = line.split(",");
//			points[k] = new Point(Double.parseDouble(XY[0]), Double.parseDouble(XY[1]));
//			k++;
//		}
//		System.out.println("��ȡ�ļ����");
//		Point[] points = new Point[100000000];
//		test.getRandom(points);
//		int []a = new int[]{8,3,2,9,7,1,5,4,10};
//		myalo.BubbleSort(a);
//		Point[] points;
//		Point p1 = new Point(12.4, 12.1);
//		Point p2 = new Point(13.6, 15.6);
//		Point p3 = new Point(14.2, 11.5);
//		Point p4 = new Point(17.8, 6.8);
//		Point p5 = new Point(14.2, 20.9);
//		points = new Point[]{p1, p2, p3, p4, p5};
//		double dis = myalo.EfficientClosestPair(points);
//		System.out.println(dis);
//		File file = new File("C:\\Users\\Hongyin\\Desktop\\ClosestPairProblem-master\\test\\InputFiles\\sample_input_2_8.tsv");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String line = "";
//		Point[]p = new Point[8];
//		int k = 0;
//		while((line = br.readLine()) != null) {
//			String[]strings = line.split("\t");
//			p[k] = new Point();
//			p[k].setX(Double.parseDouble(strings[0]));
//			p[k].setY(Double.parseDouble(strings[1]));
//			k++;
//		}
//		test.printPoint(p);
//		System.out.println("�����㷨��ʼ");
//		long startTime = System.currentTimeMillis();
//		myalo.QuickSortPointByX(points, 0, points.length - 1);
//		test.printPoint(points);
//		myalo.QuickSortPointByY(points, 0, points.length - 1);
//		test.printPoint(points);
//		System.out.println();
//		double dis = myalo.EfficientClosestPair(points);
//		System.out.println(dis);
//		long endTime = System.currentTimeMillis();
//		System.out.println("���η�����ʱ�䣺" + (endTime - startTime) + "ms");
//		long startTime1 = System.currentTimeMillis();
//		System.out.println("�����㷨��ʼ");
//		double true_dis = myalo.BruteForceCloestPoint(points);
//		System.out.println(true_dis);
//		long endTime1 = System.currentTimeMillis();
//		System.out.println("�����㷨����ʱ�䣺" + (endTime1 -  startTime1) + "ms");
//		myalo.BruteForceCloestPoint(points);
//		myalo.Mergesort(a);;
//		myalo.QuickSort(a, 0, a.length - 1);
//		myalo.QuickSortAnother(a, 0, a.length - 1);
//		test.print(a);
//		int large_a = 1234;
//		int large_b = 6789;
//		int n = 4;
//		int c = myalo.Large_Integer_Multiply(large_a, large_b, n);
//		System.out.println(c);
//		
//		
//		int result = myalo.RussainPeasantMethod(20, 26);
//		System.out.println(result);
		
		
		
		String S = "bacbabababacaababacaabc";
		String P = "ababa";
		myalo.KMP_Matcher(S, P);
//		BoyerMoore bm = new BoyerMoore();
//		bm.Boyer_Moore(S, P);
		
	}
	
	public void print(int A[]) {
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}
	
	public void printPoint(Point[]p) {
		for(int i = 0; i < p.length; i++)
			System.out.print(p[i].getX() + "," + p[i].getY() + "    ");
		System.out.println();
	}
	public static void getRandom(Point[]p) {
		int l = p.length;
		Random random = new Random(1000);
		for(int i = 0; i < l; i++) {
			double x = random.nextDouble() * 10000 + 1;
			double y = random.nextDouble() * 10000 + 1;
			p[i] = new Point(x, y);
		}
	}
}
	


