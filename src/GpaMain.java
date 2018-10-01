
public class GpaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double gpaCalculation(int[] classGrade, int[] classCredit) {
		// Grades: 4:A, 3:B, 2:C, 1:D, 0:F
		// GPA = (Credito*Nota + ... ) / (Creditos + ... ); 
		if(classGrade.length != classCredit.length) {
			return -1;
		}
		double numerador = 0;
		int denominador = 0;
		for(int idx = 0; idx < classGrade.length; idx++) {
			numerador += classCredit[idx]*classGrade[idx];
			denominador += classCredit[idx];
		}
		return numerador / denominador;
		
	}
	
	public static double gpaCalculation(int[][] classes) {
		// Dim 1: Cantidad Clases
		// Dim 2: Par de credito y nota
		// classes[0] -> {4, 2}, classes[0][0] - > 4 (Credits), classes[0][1] -> 2 (Grade)
		// GPA = (Credito*Nota + ... ) / (Creditos + ... ); 
		double numerador = 0;
		int denominador = 0;
		for(int[] info : classes) {
			numerador += info[0]*info[1];
			denominador += info[0];
		}
		return numerador/denominador;
		
	}
	
	public static double gpaCalculation(Class[] classes) {
		// Dim 1: Cantidad Clases
		// Dim 2: Par de credito y nota
		// classes[0] -> {4, 2}, classes[0][0] - > 4 (Credits), classes[0][1] -> 2 (Grade)
		// GPA = (Credito*Nota + ... ) / (Creditos + ... ); 
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
