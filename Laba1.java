import java.util.Random;

public class Laba1{
	public static void main(String[] args){
		Random rn = new Random();
		short [] c = new short[12];
		int j = 0;
		for (short i = 6; i <= 17 ; i++){
			c[j] = i;
			j++; 
		}
		double [] x = new double[14];
		for (int i = 0; i < 14; i++){
			x[i] = rn.nextDouble(23)-13;
		}
		Double arr [][] = new Double[12][13];
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
						arr[i][v] = Math.pow((1/3)*Math.pow(Math.E,x[v])*(1-Math.pow(Math.E,Math.log10(Math.pow(Math.sin(x[v]),2)))),2);

				}

				
			}
		}
	}
}
