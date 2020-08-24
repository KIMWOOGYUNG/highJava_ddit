package basic;



public class Score {
	
	public void calcScore(String name, int...scores){
		int tot = 0; 
		for(int i = 0; i < scores.length; i++){
			tot += scores[i];
		}
		
		double avg = (double)tot / scores.length;
		String g = "";
		
		if(avg >= 90){
			g = "A";
		}else if(avg >= 80){
			g = "B";
		}else if(avg >= 70){
			g = "C";
		}else if(avg >= 60){
			g = "D";
		}else{
			g = "F";
		}
		
		System.out.print(name + "\t");
		for(int score : scores){
			System.out.print(score + "\t");
		}
		System.out.println(avg + "\t" + g);
		
	}


	public static void main(String[] args) {
		Score score = new Score();
		
		score.calcScore("김우경", 100, 80, 90, 95);
		score.calcScore("남아름", 90, 70, 90);
		score.calcScore("전다희", 80, 100, 90, 95);
		score.calcScore("이제경", 70, 90, 90, 95, 100);
		
	}

}
