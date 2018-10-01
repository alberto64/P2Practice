

public class GpaManager {
	Class[] classes;
	int totalClasses;
	
	public GpaManager(int size) {
		classes = new Class[size];
		totalClasses = 0;
	}
	
	public GpaManager(GpaManager ogpa) {
		classes = ogpa.classes;
		totalClasses = ogpa.totalClasses;

	}
	
	public void addClass(int credit, grade grade) {
		if(totalClasses>=classes.length) {
			Class[] temp = new Class[classes.length*2];
			for(int idx=0; idx<classes.length;idx++) {
				temp[idx]=classes[idx];
			}		
			classes=temp;
		}
			classes[totalClasses++]= new Class(credit, grade);
	}
	
	public double getGpa() {
		double numerador = 0;
		int denominador = 0;
		for(Class info : classes) {
			numerador += info.getCredit()*info.getGrade().getGradePoints();
			denominador += info.getCredit();
		}
		return numerador/denominador;
	}
	
	public enum grade {A(4), B(3), C(2), D(1), F(0);
		private int gradingPoints;
		grade(int gradingPoints) {
			this.gradingPoints = gradingPoints;
		}
		public int getGradePoints() {
			return gradingPoints;
		}
		}
	
	public static class Class {
		int creditos;
		grade grade;
		
		public Class(int credits, grade grade) {
			creditos = credits;
			this.grade = grade;
			
		}
		
		public int getCredit() {
			return creditos;
		}
		
		public grade getGrade() {
			return grade;
		}
	}
}
