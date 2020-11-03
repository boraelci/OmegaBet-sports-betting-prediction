
public class Compare {
	
	float oran; //oran
	float perf; //performans son 10 favori
	float rakip; //rakip performans son 10
	float ligRank; //lig sıralaması farkı rakip-favori
	float consensus; //direkt 1
	float against; //against2019
	float predict; //predicttion websites
	float perf5; //performans son 5 favori
	float rakip5; //rakip performans son 5
	
	boolean s1; //oran
	boolean s2; //performans son 10
	boolean s3; //sıralama
	boolean s4; //consensus
	boolean s5; //against2019
	boolean s6; //predict
	boolean s8; //performans son 5
	
	public Compare(float inOran, float inPerf, float inRakip, float inLigRank, float inConsensus, float inAgainst, float inPredict, float inPerf5, float inRakip5) {
		
		oran = inOran;
		perf = inPerf;
		rakip = inRakip;
		perf5 = inPerf5;
		rakip5 = inRakip5;
		
		ligRank = inLigRank;
		consensus = inConsensus;
		against = inAgainst;
		predict = inPredict;
		
		s1= false;
		if(oran >= 1.3 && oran <= 2) {
			s1 = true;
		}
		
		s2 = false;
		if(perf>0 && rakip<0) {
			s2 = true;
		}
		else if(perf-rakip>=0.5) {
			s2 = true;
		}
		
		s8 = false;
		if(perf5>0 && rakip5<0) {
			s8 = true;
		}
		else if(perf5-rakip5>=0.5) {
			s8 = true;
		}
		
		s3 = false;
		if(ligRank>6) {
			s3 = true;
		}
		
		s4 = false;
		if(consensus>0.65) {
			s4 = true;
		}
		
		s5 = false;
		if(against>=0) {
			s5 = true;
		}
		
		s6 = false;
		if(predict>=0.66) {
			s6 = true;
		}
			
	}
	
	public boolean getResult() {
		boolean result = false;
		System.out.println("Oran " + s1);
		if(s8==true) {
			System.out.println("Performans 5: " + s8 + " F: " + perf5 + " R: " + rakip5); }
		else {
			System.out.println("Performans 10: " + s2 + " F: " + perf + " R: " + rakip);
		}
		System.out.println("Sıralama " + s3);
		System.out.println("Consensus " + s4);
		System.out.println("Against " + s5);
		System.out.println("Prediction " + s6);
		if(s1 && (s2 || s8) && s3 && s4 && s5 && s6) {
			result = true;
		}
		
		if(s1) {
			result = true;
		} 
		
		return result;
	}

}
