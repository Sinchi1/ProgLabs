public class Laba1{
	public static void main(String[] args){
		Double arr [][] = new Double[12][13];
		double x [] = new double[14];
		short c [] = new short[12];
		int j = 0;
		for (short i = 6; i <= 17 ; i++){
			c[j] = i;
			j++; 
		}
		for (int i = 0; i < 14; i++){
			x[i] = (Math.random()*23)-13;
			// Отрезок с 0 до 23, - 13 даёт нам нужное множество
		}
		for (int i = 0; i < arr.length;i++){
			for (int v = 0; v < arr[i].length;v++){
				switch(c[i]){
					case 6:
						arr[i][v] = Math.tan((Math.log10(Math.abs(x[v]))-2)/0.25);
						break;
					case 7:
					case 9:
					case 11:
					case 12:
					case 14:
					case 16:
						arr[i][v] = 0.25 * Math.sin(Math.pow(x[v],3.0));
						break;
					default:
						arr[i][v] = Math.pow( 1.0/3 * Math.pow(Math.E,x[v])*(1-Math.pow(Math.E,Math.log10(Math.pow(Math.sin(x[v]),2)))),2);
						break;
				}
			}
		}
		// Вывод Ответа 
		for (int i = 0; i < arr.length;i++){
			for (int v = 0; v < arr[i].length; v++){
				if (v == 12){
					System.out.printf("%.3f" + "\n",arr[i][v]);	
				}
				System.out.printf("%.3f" + "  ",arr[i][v]);
			}
		}

	}   
}
