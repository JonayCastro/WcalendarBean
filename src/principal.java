import java.util.Calendar;

import beans.Calendario;

public class principal {
	
	public static void main(String[] args) {
		
		
		
		Calendario c = new Calendario();
		
		c.getMonthGrid();
		
		/*
		for(int x = 1;x<13;x++) {
			Calendario c = new Calendario(2020,x,1);
			System.out.println(c.getNameMonth());
			c.getMonthGrid();
			System.out.println();
		}
		
		//System.out.println(c.getToday());
		//System.out.println(c.getMonth());
		//System.out.println(c.getYear());
		//System.out.println(c.getNameMonth());
		
		
		
		//c.getMonth("agosto");
		/*
		int mes = Calendar.JANUARY;
		
		int begin = c.getFirstDayOfWeek(2020, mes, 1);
		int primerDia = begin;
		//System.out.println(begin);
		
		int weeks = c.getNWeeksOfMonth();
		//System.out.println(weeks);
		
		
		int maxDay = c.getMaxDayNotActualMonth(2020, mes, 1);
		//System.out.println(maxDay);

		int nDay=1;
		int[][] fMonth;
		if(begin == 1 || begin ==7) {
			fMonth = new int[weeks+1][7];
		}else {
			fMonth = new int[weeks][7];
		}
		
		
		
		if(begin > 1)begin-=2;
		else begin = 6;
		
		//System.out.println(begin);
		for(int x=0; x<weeks;x++) {
			//System.out.println();
			for(int y=begin;y<fMonth[x].length;y++) {
				//System.out.println("Semana "+(x)+" "+"|dia "+nDay+" "+"|dia de la semana " +(begin));
				
				if(nDay <= maxDay) {
					fMonth[x][y]=nDay;
					nDay++;
				}else {
					fMonth[x][y]=0;
				}
				begin++;
				if(begin > 6) {
					begin = 0;
					break;
				}
			}
		}
		
		if(primerDia == 1) {
			fMonth[weeks][0]=30;
			fMonth[weeks][1]=31;
			
		}
		
		if(primerDia == 7) {
			fMonth[weeks][0] = 31;
			if(mes == Calendar.FEBRUARY) {
				fMonth[weeks][0] = 0;
			}
		}
		for(int z=0;z<fMonth.length;z++) {
			System.out.println();
			for(int j=0;j<fMonth[z].length;j++) {
				System.out.print(fMonth[z][j]+" ");

			}
		}
		*/

	}
	
}
