
public class Omega {
	
	String[] data;
	
	public Omega(String[] inData) {
		
		data = inData;
		
	}
	
	public float getOran() {
		float oran = Float.parseFloat(data[0]);
		return oran;
	}
	
	public float getPerformance() {
		String tempPerf = data[1];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float perf = sum/perfArray.length;
		
		return perf;
	} 
	
	public float getRakipPerformance() {
		String tempPerf = data[2];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
			//System.out.println(perfArray[i]);
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float perf = sum/perfArray.length;
		
		return perf;
	}
	
	public float getPerformanceOfFive() {
		String tempPerf = data[8];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float perf = sum/perfArray.length;
		
		return perf;
	} 
	
	public float getRakipPerformanceOfFive() {
		String tempPerf = data[9];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
			//System.out.println(perfArray[i]);
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float perf = sum/perfArray.length;
		
		return perf;
	}
	
	public float getRanking() {
		float rankFark = Integer.parseInt(data[4]) - Integer.parseInt(data[3]);
		return rankFark;
	}
	
	public float getConsensus() {
		float consensus = Float.parseFloat(data[5]);
		return consensus;
	}
	
	public float getAgainst() {
		//variable lar öncekinin kopyası ama doğru işliyor
		String tempPerf = data[6];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
			//System.out.println(perfArray[i]);
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float against = sum/perfArray.length;
		
		return against;
	}
	
	public float getPredict() {
		
		String tempPerf = data[7];
		int[] perfArray = new int[tempPerf.length()];
		for(int i=0; i<perfArray.length; i++) {
			perfArray[i] = Character.getNumericValue(tempPerf.charAt(i));
			//System.out.println(perfArray[i]);
		}
		float sum = 0;
		for(int j : perfArray){
			sum = sum + j;
		}
		
		float predict = sum/perfArray.length;
		
		return predict;
	}
	
}
