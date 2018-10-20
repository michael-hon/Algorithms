package algorithms;


import Data.Point;

import java.util.*;
import java.lang.Math;
import java.util.zip.CRC32;

import javax.print.attribute.ResolutionSyntax;
import javax.security.auth.x500.X500Principal;
import javax.xml.ws.AsyncHandler;
public class algorithms {
	
	//冒泡排序

	public void BubbleSort(int []a){
		int len = a.length;
		for(int i = 0; i <= len-2; i++){
			for(int j = 0; j <= len-i-2; j++){
				if(a[j] > a[j+1]){
					int index = a[j];
					a[j] = a[j+1];
					a[j+1] = index;
				}
			}
		}
		for(int i = 0; i < len; i++)
			System.out.print(a[i] + " ");
		
	}
	
	// 最近点对蛮力算法
	public double BruteForceCloestPoint(Point[]points) {
		double min_dis = Double.MAX_VALUE;
		int len = points.length;
//		int index1 = -1;
//		int index2 = -1;
		for(int i=0; i< len-1; i++) {
			for(int j = i+1; j < len; j++) {
				double dis = Math.pow(points[i].getX() - points[j].getX(), 2) 
						       + Math.pow(points[i].getY() - points[j].getY(), 2);
				min_dis = Math.min(min_dis, dis);
//				if(dis < min_dis) {
//					index1 = i;
//					index2 = j;
//					min_dis = dis;
//				}
			}
		}
//		System.out.println(min_dis);
		return Math.sqrt(min_dis);
	}
	
	//归并排序
	public void Mergesort(int[]A) {
		int len = A.length;
		//递归终止条件，当数组长度为1时，不用排序
		if(len > 1) {
			int B_len = (int)Math.floor(len/2.0); // int B_len = len / 2;
			int C_len = (int)Math.ceil(len/2.0);  // int C_len = len - B_len;
			int []B = new int[B_len];
			int []C = new int[C_len];
			//复制数组
			for(int i=0; i<B_len; i++) {
				B[i] = A[i];
			}
			for(int i = 0; i<C_len; i++) {
				C[i] = A[B_len + i]; 
			}
			//对数组B归并排序
			Mergesort(B);
			//对数组C归并排序
			Mergesort(C);
			//合并
			Merge(B, C, A);
		}
	}
	
	//合并排序结果
	public void Merge(int[]B, int[]C, int[]A) {
		int len_B = B.length;
		int len_C = C.length;
		int len_A = A.length;
		//三个指针
		int i = 0, j = 0, k = 0;
		while(i < len_B && j < len_C) {
			if(B[i]<=C[j]){
				A[k] = B[i];
				i++;
			}
			else {
				A[k] = C[j];
				j++;
			}
			k++;
		}
		//把剩余元素复制到A
		if(i==len_B) {
			for(;j < len_C;j++) {
				A[k] = C[j];
				k++;
			}
		}
		else {
			for(;i < len_B;i++) {
				A[k] = B[i];
				k++;
			}
		}
	}
	
	//快速排序
	public void QuickSort(int A[], int left, int right) {
		if(left < right) {
			int par_pos = HoarePartition(A, left, right);
			//对左子数组递归快速排序
			QuickSort(A, left, par_pos - 1);
			//对右子数组递归快速排序
			QuickSort(A, par_pos + 1, right);
		}
	}
	
	//划分算法
	public int HoarePartition(int A[], int left, int right) {
		int i = left + 1;
		int j = right;
		int p = A[left];
		while(i < j) {
			while(A[i] < p && i <= right) {
				i++;
			}
			while(A[j] > p && j >= left) {
				j--;
			}
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp; 
		}
		//(i - j)应该只会等于0或者1
		System.out.println(i - j);
		//撤销最后一次交换
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		//交换A[j]与p
		temp = A[j];
		A[j] = A[left];
		A[left] = temp;
//		System.out.print("par:  " + j + "   ");
//		print(A);
		return j;
	}
	
	//快速排序另一个版本
	public void QuickSortAnother(int[]A, int left, int right) {
		if(left < right) {
			int p = A[left];
			int s = left;
			for(int i = left + 1; i <= right; i++) {
				if(A[i] <= p) {
					s++;
					int temp = A[i];
					A[i] = A[s];
					A[s] = temp; 
				}
			}
			int temp = A[s];
			A[s] =  A[left];
			A[left] = temp;
			//对左子数组快速排序
			QuickSortAnother(A, left, s - 1);
			//对右子数组快速排序
			QuickSortAnother(A, s + 1, right);
		}
	}
	
	
	public void print(int A[]) {
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println();
	}
	
	//分治法：大整数相乘
	//该算法限制a与b的位数相同
	public int Large_Integer_Multiply(int a, int b, int n) {
		int sign_num = sign(a) * sign(b);
		int abs_a = Math.abs(a);
		int abs_b = Math.abs(b);
		if(abs_a == 0 || abs_b == 0)
			return 0;
		//当位数为1时，直接相乘
		if(n == 1)
			return sign_num * abs_a * abs_b;
		else {
			//分治思想：将n位数相乘规模减半，即n/2位数相乘
			int a1 = abs_a / (int)Math.pow(10, n / 2);
			int a0 = abs_a - a1 * (int)Math.pow(10, n / 2);
			int b1 = abs_b / (int)Math.pow(10, n / 2);
			int b0 = abs_b - b1 * (int)Math.pow(10, n / 2);
			int c2 = Large_Integer_Multiply(a1, b1, n / 2);
			int c0 = Large_Integer_Multiply(a0, b0, n / 2);
			int c1 = Large_Integer_Multiply((a1 - a0), (b0 - b1), n / 2) + c2 + c0;
			return sign_num * ( c2 * (int)Math.pow(10, n) + c1 * (int)Math.pow(10, n / 2) + c0 );
		}
	}
	
	//判断正负数
	public int sign(int a){
		return a > 0? 1 : -1;
	}
	
	
	//使用分治算法来求解最近点对问题
	public double EfficientClosestPair(Point[]P) {
		/*
		 * Param1：数组P中存储了平面上的n>=2个点，并且按照这些点的x轴坐标升序排列
		 * Param2：数组Q中存储了与P相同的点，只是它是按照这点的y轴坐标升序排列
		 * Output：最近点对之间的欧几里得距离 
		 */
		int n = P.length;
		//递归终止条件，当集合点个数为3时，使用蛮力算法求解
		if(n <= 3) {
			return BruteForceCloestPoint(P);
		}
		else {

			int P_left_len = (int)Math.ceil(n / 2.0);
			int P_right_len = (int)Math.floor(n / 2.0);
			Point[]P_left = new Point[P_left_len];
			Point[]P_right = new Point[P_right_len];
			for(int i = 0; i < P_left_len; i++) 
				P_left[i] = P[i];
			for(int i = 0; i < P_right_len; i++)
				P_right[i] = P[P_left_len + i];
			double d1 = EfficientClosestPair(P_left);
			double d2 = EfficientClosestPair(P_right);
			double d = Math.min(d1, d2);
			double x = P[P_left_len - 1].getX();
			Point[]Q = P.clone();
			QuickSortPointByY(Q, 0, Q.length - 1);
			Point[]S = new Point[Q.length];
			int num = 0;
			double d_min = d;
			//取垂直域的所有点
			for(int i = 0; i < Q.length; i++) {
				if(Math.abs(Q[i].getX() - x) < d) {
					S[num] = Q[i];
					num++;
				}
				
			}
			//取垂直域最小距离（遍历）
			for(int i = 0; i < num - 1; i++) {
				for(int j = i + 1; j < num; j++) {
//					if(S[i] == null) {
//						System.out.print("i :" + i);
//					}
//					System.out.println();
//					if(S[j] == null) {
//						System.out.print("j: " + j);
//					}
					if(Math.abs(S[i].getY() - S[j].getY()) < d_min)
						d_min = Math.min(d_min, caculate(S[i], S[j]));
				}
			}
			return d_min;
		}
		
	}
	
	public void QuickSortPointByY(Point[]points, int left, int right) {
		if(left < right) {
			Point p = points[left];
			int s = left;
			for(int i = left + 1; i <= right; i++) {
				if(points[i].getY() <= p.getY()) {
					s++;
					Point temp = points[i];
					points[i] = points[s];
					points[s] = temp; 
				}
			}
			Point temp = points[s];
			points[s] =  points[left];
			points[left] = temp;
			//对左子数组快速排序
			QuickSortPointByY(points, left, s - 1);
			//对右子数组快速排序
			QuickSortPointByY(points, s + 1, right);
		}
	}
	
	//计算点p1与p2之间的距离
	public double caculate(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
		return distance;
	}
	
	
	public void QuickSortPointByX(Point[]points, int left, int right) {
		if(left < right) {
			Point p = points[left];
			int s = left;
			for(int i = left + 1; i <= right; i++) {
				if(points[i].getX() <= p.getX()) {
					s++;
					Point temp = points[i];
					points[i] = points[s];
					points[s] = temp; 
				}
			}
			Point temp = points[s];
			points[s] =  points[left];
			points[left] = temp;
			//对左子数组快速排序
			QuickSortPointByX(points, left, s - 1);
			//对右子数组快速排序
			QuickSortPointByX(points, s + 1, right);
		}
	}
	
	//快包算法：使用分治法解决凸包问题
	public List<Point> QuickHull(Point[]points) {
		//输入：点集合，按照x坐标升序排列
		//输出：点集合的凸包	
		List<Point> result = new ArrayList<Point>();
		int n = points.length;
		//点集合为空时，直接返回空链表
		if(n == 0)
			return result;
		//点集合只有1个或者两个时，直接返回点集合
		if(n == 1 || n == 2) {
			for(int i = 0; i < n; i++)
				result.add(points[i]);
			return result;
		}
		//取最左面的点和最右面的点，并且这两个点确定属于凸包
		Point p1 = points[0];
		Point pn = points[n - 1];
		result.add(p1);
		result.add(pn);
		//求线段左集合,记为p_left,包含p1,pn端点
		Point[] p_left = getLeftSet(points, p1, pn);	
		//求线段右集合，记为p_right,包含p1,pn端点
		Point[] p_right = getRightSet(points, p1, pn);
		List<Point> r1 = UpperHull(p_left);
		List<Point> r2 = lowerHull(p_right);
		
		for(int i = 0; i < r1.size(); i++) {
			if(result.contains(r1.get(i)))
				continue;
			result.add(r1.get(i));
		}
		
		for(int i = 0; i < r2.size(); i++) {
			if(result.contains(r2.get(i)))
				continue;
			result.add(r2.get(i));
		}
		return result;
	}
	
	//求上包
	public List<Point> UpperHull(Point[]points){
		List<Point> result = new ArrayList<Point>();
		int n = points.length;
		if(n == 2) {
			for(int i = 0; i < n; i++)
				result.add(points[i]);
			return result;
		}
		Point p1 = points[0];
		Point pn = points[n - 1];
		Point pmax = getMax(points, p1, pn);
		result.add(p1);
		result.add(pn);
		result.add(pmax);
		//获取线段左集合，记为p_left,包含p1,pmax端点,右集合并不考虑
		Point[] p1_left = getLeftSet(points, p1, pmax);
		
		//获取线段左集合，记为p_right,包含pmax,pn端点，右集合不考虑
		Point[] p2_left = getLeftSet(points, pmax, pn);
		
		List<Point> r1 = UpperHull(p1_left);
		List<Point> r2 = UpperHull(p2_left);
		
		for(int i = 0; i < r1.size(); i++) {
			if(result.contains(r1.get(i)))
				continue;
			result.add(r1.get(i));
		}
		for(int i = 0; i < r2.size(); i++) {
			if(result.contains(r2.get(i)))
				continue;
			result.add(r1.get(i));
		}
		return result;
	}
	
	public List<Point> lowerHull(Point[]points){
		List<Point> result = new ArrayList<Point>();
		int n = points.length;
		if(n == 2) {
			for(int i = 0; i < n; i++)
				result.add(points[i]);
			return result;
		}
		Point p1 = points[0];
		Point pn = points[n - 1];
		Point pmax = getMax(points, p1, pn);
		result.add(p1);
		result.add(pn);
		result.add(pmax);
		//获取线段右集合，记为p_right,包含p1,pmax端点,右集合并不考虑
		Point[] p1_right = getRightSet(points, p1, pmax);
		
		//获取线段右集合，记为p_right,包含pmax,pn端点，右集合不考虑
		Point[] p2_right = getRightSet(points, pmax, pn);
		
		List<Point> r1 = lowerHull(p1_right);
		List<Point> r2 = lowerHull(p2_right);
		
		for(int i = 0; i < r1.size(); i++) {
			if(result.contains(r1.get(i)))
				continue;
			result.add(r1.get(i));
		}
		for(int i = 0; i < r2.size(); i++) {
			if(result.contains(r2.get(i)))
				continue;
			result.add(r1.get(i));
		}
		return result;
	}
	
	
	//获取左子集合
	public Point[] getLeftSet(Point[]point, Point p1, Point pn) {
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = pn.getX();
		double y2 = pn.getY();
		int n = point.length;
		List<Point> re_list = new ArrayList<Point>();
		re_list.add(p1);
		for(int i = 1; i < n - 1; i++) {
			double x3 = point[i].getX();
			double y3 = point[i].getY();
			double s = x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3;
			if(s > 0)
				re_list.add(point[i]);
		}
		re_list.add(pn);
		Point[] result = (Point[])re_list.toArray(new Point[re_list.size()]);
		return result;
	}
	
	//获取右子集合
	public Point[] getRightSet(Point[]point, Point p1, Point pn) {
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = pn.getX();
		double y2 = pn.getY();
		int n = point.length;
		List<Point> re_list = new ArrayList<Point>();
		re_list.add(p1);
		for(int i = 1; i < n - 1; i++) {
			double x3 = point[i].getX();
			double y3 = point[i].getY();
			double s = x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3;
			if(s <= 0)
				re_list.add(point[i]);
		}
		re_list.add(pn);
		Point[] result = (Point[])re_list.toArray(new Point[re_list.size()]);
		return result;
	}
	
	
	public Point getMax(Point[]point, Point p1, Point pn) {
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = pn.getX();
		double y2 = pn.getY();
		int n = point.length;
		Point p = new Point();
		int index = 0;
		double s_max = Double.MIN_VALUE;
		for(int i = 1; i < n - 1; i++) {
			double x3 = point[i].getX();
			double y3 = point[i].getY();
			double s = x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3;
			s = Math.abs(s);
			if(s > s_max)
				index = i;
			else {
				if(s == s_max) {
					if(x3 < point[index].getX())
						index = i;
				}
			}
		}
		p = point[index];
		return p;
	}
	
	//插入排序
	public void InsertionSort(int A[]) {
		int n = A.length;
		if(n == 0) {
			System.out.println("数组为空，请确认输入");
			System.exit(1);
		}
		for(int i = 1; i < n; i++) {
			int j = i - 1;
			int temp = A[i];
			while(j >= 0 && A[j] > temp) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = temp;
		}
	}
	
	//俄式乘法
	public int RussainPeasantMethod(int n, int m) {
		List<Integer> tailNum = new ArrayList<Integer>();
		while(n != 1) {
			//偶数
			if(n % 2 == 0) {
				n = n / 2;
				m = 2 * m;
			}
			//奇数
			else {
				n = (n - 1) / 2;
				tailNum.add(m);
				m = 2 * m;
			}
		}
		int result = m;
		for(int i = 0; i < tailNum.size(); i++)
			result += tailNum.get(i);
		return result;
	}
	
	
}
