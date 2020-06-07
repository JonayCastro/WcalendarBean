package beans;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

public class Calendario implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int weeks = 5;
	private Calendar calendario;
	
	private static int actualDay;
	public int numDaysOfMonth;
	private int year, month, today, maxDay, firstDayOfWeek;
	private String  nameMonth;
	private String[] listOfMonth, listOfDaysOfWeek;
	private int[] listOfNumOfWeeks;
	
	
	public Calendario() {
		
		calendario = Calendar.getInstance(Locale.getDefault());
		
		year = calendario.get(Calendar.YEAR);
		month = calendario.get(Calendar.MONTH)+1;
		today = calendario.get(Calendar.DATE);
		
		actualDay = today;
		
		maxDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		//firstDayOfWeek = calendario.get(Calendar.DAY_OF_WEEK)-5;//el 5 antes era 1
		firstDayOfWeek = getFirstDayOfWeek()-2;
		System.out.println(firstDayOfWeek);
		
	}
	
	public Calendario(int year, int month, int day) {
		
		calendario = Calendar.getInstance(Locale.getDefault());
		calendario.set(year, month-1, day);
		
		this.year = year;
		this.month = month;
		this.today = day;
		
		maxDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		//firstDayOfWeek = calendario.get(Calendar.DAY_OF_WEEK)-2;
		firstDayOfWeek = getFirstDayOfWeek()-2;
		System.out.println(firstDayOfWeek);
	}
	
	public int getFirstDayOfWeek() {
		calendario.set(Calendar.DATE, 1);
		firstDayOfWeek = calendario.get(Calendar.DAY_OF_WEEK);
		
		return firstDayOfWeek;
	}
	
	public int[][] getMonthGrid(){
		int begin = firstDayOfWeek;
		
		if(begin < 0)begin = 6;
		
		int firstDay = begin;
		
		if(firstDay >= 5 && maxDay > 29) {
			weeks++;
			if(firstDay == 5 && maxDay == 30) weeks --;
		}else if(firstDay == 0 && maxDay <= 28)weeks--;
		
		int [][] monthGrid = new int [weeks][7];
		
		int nDay = 1;
		
		for(int x=0;x<weeks;x++) {
			for(int y=begin;y<7;y++) {
				if(nDay > maxDay) break;
				
				monthGrid[x][y]=nDay;
				nDay++;
			}
			if(firstDay != 0) begin=0;
			
		}
		/*
		for(int z=0;z<monthGrid.length;z++) {
			System.out.println();
			for(int j=0;j<monthGrid[z].length;j++) {
				System.out.print(monthGrid[z][j]+" ");

			}
		}*/
		return monthGrid;
		
	}
	//Getters------------------------------------------------------------------------------------------------
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getToday() {
		return today;
	}
	
	//Setters------------------------------------------------------------------------------------------------

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setToday(int today) {
		this.today = today;
	}
	//Utilidades---------------------------------------------------------------------------------------------
	
	public static int getNumOfMonth(String nameMonth) {
		int mes = Calendar.JANUARY;
		
		if (nameMonth.equalsIgnoreCase("febrero")) mes = Calendar.FEBRUARY;
		else if(nameMonth.equalsIgnoreCase("marzo")) mes = Calendar.MARCH;
		else if(nameMonth.equalsIgnoreCase("abril")) mes = Calendar.APRIL;
		else if(nameMonth.equalsIgnoreCase("mayo")) mes = Calendar.MAY;
		else if(nameMonth.equalsIgnoreCase("junio")) mes = Calendar.JUNE;
		else if(nameMonth.equalsIgnoreCase("julio")) mes = Calendar.JULY;
		else if(nameMonth.equalsIgnoreCase("agosto")) mes = Calendar.AUGUST;
		else if(nameMonth.equalsIgnoreCase("septiembre")) mes = Calendar.SEPTEMBER;
		else if(nameMonth.equalsIgnoreCase("octubre")) mes = Calendar.OCTOBER;
		else if(nameMonth.equalsIgnoreCase("noviembre")) mes = Calendar.NOVEMBER;
		else if(nameMonth.equalsIgnoreCase("diciembre")) mes = Calendar.DECEMBER;
		
		
		return mes+1;
	}
	

	public String[] getListOfDaysOfWeek() {
		listOfDaysOfWeek = new String[7];
		
		listOfDaysOfWeek[0] = "Lunes";
		listOfDaysOfWeek[1] = "Martes";
		listOfDaysOfWeek[2] = "Miercoles";
		listOfDaysOfWeek[3] = "Jueves";
		listOfDaysOfWeek[4] = "Viernes";
		listOfDaysOfWeek[5] = "Sabado";
		listOfDaysOfWeek[6] = "Domingo";
		
		return listOfDaysOfWeek;
	}
	
	public String[] getListOfMonth() {

		listOfMonth = new String[12];

		listOfMonth[0] = "Enero";
		listOfMonth[1] = "Febrero";
		listOfMonth[2] = "Marzo";
		listOfMonth[3] = "Abril";
		listOfMonth[4] = "Mayo";
		listOfMonth[5] = "Junio";
		listOfMonth[6] = "Julio";
		listOfMonth[7] = "Agosto";
		listOfMonth[8] = "Septiembre";
		listOfMonth[9] = "Octubre";
		listOfMonth[10] = "Noviembre";
		listOfMonth[11] = "Diciembre";

		return listOfMonth;
	}
	
	public int getIndexOfMonth(String month) {
		
		int index = 0;
		
		String[] list = this.getListOfMonth();		
		for(int x=0;x<list.length;x++) {
			if(month.equalsIgnoreCase(list[x])) index = x+1;
		}
		
		return index;
	}
	
	public String getNameMonth() {
		switch(month) {
			case(1): {
				nameMonth = "Enero";
				break;
			}
			case(2): {
				nameMonth = "Febrero";
				break;
			}
			case(3): {
				nameMonth = "Marzo";
				break;
			}
			case(4): {
				nameMonth = "Abril";
				break;
			}
			case(5): {
				nameMonth = "Mayo";
				break;
			}
			case(6): {
				nameMonth = "Junio";
				break;
			}
			case(7): {
				nameMonth = "Julio";
				break;
			}
			case(8): {
				nameMonth = "Agosto";
				break;
			}
			case(9): {
				nameMonth = "Septiembre";
				break;
			}
			case(10): {
				nameMonth = "Octubre";
				break;
			}
			case(11): {
				nameMonth = "Noviembre";
				break;
			}
			case(12): {
				nameMonth = "Diciembre";
				break;
			}
		}
		
		return nameMonth;
	}
	
	//Descartes----------------------------------------------------------------------------------------------
	
	/*
	public int getNumDaysOfMonth() {
		numDaysOfMonth = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		return numDaysOfMonth;
	}
	
	public int getActualDay() {
		actualDay = calendario.get(Calendar.DAY_OF_WEEK);
		return actualDay;
	}
	public int[] getListOfNumsOfDays() {
		
		
		listOfNumsOfDays = new int[maxDay];
		
		
		for (int x=1; x<maxDay; x++) {
			listOfNumsOfDays[x] = x;
		}
		return listOfNumsOfDays;
	}
	public int[] getlistOfNumOfWeeks() {
		
		
		listOfNumOfWeeks = new int[nWeeksOfMonth];
		for(int x=0; x<nWeeksOfMonth;x++) {
			listOfNumOfWeeks[x] = (x+1);
		}
		
		return listOfNumOfWeeks;
	}
	public int getMaxDayNotActualMonth() {
		
		calendario.set(Calendar.DATE, 1);
		int maxDayNotActualMonth = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDayNotActualMonth;
	}
	public int getNWeeksOfMonth() {
		return nWeeksOfMonth;
	}
	public int[][] getMonthGrid(){
		//int month = getNumOfMonth(month);
		//int month = Calendar.JANUARY;
		
		//int begin = this.getFirstDayOfWeek();
		int begin = this.getFirstDayOfWeek();
		
		int primerDia = begin;
		
		//int weeks = this.getNWeeksOfMonth();
		//int weeks = nWeeksOfMonth;
		
		//int maxDay = this.getMaxDayNotActualMonth();
		//int maxDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		int nDay=1;
		int[][] fMonth;
		
		if(begin == 1 || begin ==7) {
			fMonth = new int[weeks+1][7];
		}else {
			fMonth = new int[weeks][7];
		}
		
		if(begin > 1)begin-=2;
		else begin = 6;		
		
		for(int x=0; x<weeks;x++) {			
			for(int y=begin;y<fMonth[x].length;y++) {
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
		
		if(primerDia == 1 && month != 2) {
			fMonth[weeks][0]=30;
			fMonth[weeks][1]=31;
		}
		if(primerDia == 7) {
			fMonth[weeks][0] = 31;
			if(month == 2) {
				fMonth[weeks][0] = 0;
			}
		}	
		
		for(int z=0;z<fMonth.length;z++) {
			System.out.println();
			for(int j=0;j<fMonth[z].length;j++) {
				System.out.print(fMonth[z][j]+" ");

			}
		}
		
		return fMonth;
	}
	*/
	
	
}



