package com.recurision;

public class MiGong {
	public static void main(String[] args) {
		//用二维数组表示地图
		int[][] map = setMap();
		//使用表示墙
		list(map);
		
		setWay(map,2,1);
		System.out.println("------------------------");
		list(map);
		
	}
	//。使用递归来给小球找路
	//1.map 表示地图
	//2.i 和j表示从地图的哪个位置开始
	//3.1表示该点是墙，2表示通路可以走，3表示已经走过了，但是走不通
	//4.遵循规则，下-》右-》上-》左
	
	
	/***
	 * 
	 * @param map 表示地图
	 * @param i 从哪个位置开始找
	 * @param j
	 * 
	 * @return 如果找到通路，就返回true
	 * */
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			if(map[i][j] == 0) {
				map[i][j] =2;//假定该点可以走动
				//怎样知道如何走动, 就要按照下右上左的规则走一遍
				if((setWay(map,i+1,j))) {//向下走
					return true;
				}else if(setWay(map,i,j+1)) {//向右走
					return true;
				}else if(setWay(map,i-1,j)) {//向上走
					return true;
				}else if(setWay(map,i,j-1)) {//向左走
					return true;
				}else {
					//说明该点是走不通的,是死路
					map[i][j] = 3;
					return false;
				}
				
			}else {//
				return false;
			}
		}
	}
	
	
	public static void list(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] setMap(){
		
		int[][] map = new int[8][7];
		
		for(int i = 0 ; i < 7 ;i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		
		for(int i = 1; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		
		map[3][1] = 1;
		map[3][2] = 1;
		
		return map;
	}
}
