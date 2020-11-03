import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {
	String url;
	String url2;	
	Boolean result;
	String favoriName;
	String rakipName;
	Boolean err;
	
	public Scraper(String inURL, String inURL2) {
		
		url = inURL;
		url2 = inURL2;
		result = false;
		err = false;
	}
	
	public boolean doit() {
		
		try {
			
			//iddaa sayfasına bağlan
			final Document document = Jsoup.connect(url).get();
			
			//ORAN
			//oranları al favoriyi belirle
			String[] oranlar = document.select("span.widget-iddaa-markets__value").text().split(" ");
			float team1deger = Float.parseFloat(oranlar[0]);
			float team2deger = Float.parseFloat(oranlar[2]);
			
			//System.out.println(team1deger);
			//System.out.println(team2deger);
			
			int favori = 0; //takım 1 veya 2
			float macOran = 0; //ORAN BURADA
			
			if (team1deger < team2deger) {
				favori = 1;
				macOran = team1deger;
			}
			else if (team1deger > team2deger) {
				favori = 2;
				macOran = team2deger;
			}
			else {
				System.out.println("ORANLAR EŞİT");
				err = true;
			}
			
			System.out.println(macOran); //IMPRORTANT favori oran here
			if(macOran<1.3 || macOran>2.0) {
				err = true;
				return false;
			}
			
			//karşılaştırma sayfasına bağlan
			final Document karsilastirma = Jsoup.connect(url2).get();
			
			favoriName = "";
			rakipName = "";
			
			if(favori == 1) {
				favoriName = karsilastirma.select("a.p0c-soccer-match-details-header__team-name.p0c-soccer-match-details-header__team-name--home").text();
				rakipName = karsilastirma.select("a.p0c-soccer-match-details-header__team-name.p0c-soccer-match-details-header__team-name--away").text();
			} 
			else if (favori == 2) {
				favoriName = karsilastirma.select("a.p0c-soccer-match-details-header__team-name.p0c-soccer-match-details-header__team-name--away").text();
				rakipName = karsilastirma.select("a.p0c-soccer-match-details-header__team-name.p0c-soccer-match-details-header__team-name--home").text();
				}
			else {
				System.err.println("favori bulunamadı");
				err = true;
			}
			
			//PERFORMANS
			String[] performans = karsilastirma.select("div.p0c-team-matches__match-result").text().split(" ");
			
			String[] team1PerfArray = new String[10];	
			for(int i=0; i<10; i++) {
				String current1 = "e";
				switch (performans[i]) {
					case "G":
						current1 = "1";
						break;
					case "B":
						current1 = "0";
						break;
					case "M":
						current1 = "-";
						break;
					default:
						break;
				}
				team1PerfArray[i] = current1;
			}
			
			String[] team2PerfArray = new String[10];
			for(int j=10; j<20; j++) {
				String current2 = "e";
				switch (performans[j]) {
					case "G":
						current2 = "1";
						break;
					case "B":
						current2 = "0";
						break;
					case "M":
						current2 = "-";
						break;
					default:
						break;
				}
				team2PerfArray[j-10] = current2;
			}
			
			String team1Perf = "";
			String team2Perf = "";
			
			for(String s : team1PerfArray) {
				team1Perf += s;
			}
			
			for(String g : team2PerfArray) {
				team2Perf += g;
			}
			
			String favPerf = "";
			String rakipPerf = "";
			String favRank = "e";
			String rakipRank = "e";
			String[] team1Split = karsilastirma.select("tr.p0c-competition-tables__row.p0c-competition-tables__row--rank-status.p0c-competition-tables__row--rank-status-.p0c-competition-tables__row--highlighted.p0c-competition-tables__row--home").text().split(" ", 2);
			String[] team2Split = karsilastirma.select("tr.p0c-competition-tables__row.p0c-competition-tables__row--rank-status.p0c-competition-tables__row--rank-status-.p0c-competition-tables__row--highlighted.p0c-competition-tables__row--away").text().split(" ", 2);
			System.out.println(favoriName);
			
			if(favori == 1 && team1Split[1].contains(favoriName)) {
				favRank = team1Split[0];
				rakipRank = team2Split[0];
				favPerf = team1Perf;
				rakipPerf = team2Perf;
			}
			else if (favori==2 && team2Split[1].contains(favoriName)) {
				favRank = team2Split[0];
				rakipRank = team1Split[0];
				favPerf = team2Perf;
				rakipPerf = team1Perf;
			}
			else {
				System.err.println("Performans bölümünde hata!");
				err = true;
			}
			
			System.out.println(favPerf);
			System.out.println(rakipPerf);
			
			System.out.println(favRank);
			System.out.println(rakipRank);
			
			//PERFORMANS SON 5
			String sonPerf5 = "";
			for(int i=favPerf.length()-5; i<favPerf.length(); i++) {
				sonPerf5 += favPerf.charAt(i);
			}
			
			String sonRakipPerf5 = "";
			for(int j=rakipPerf.length()-5; j<rakipPerf.length(); j++) {
				sonRakipPerf5 += rakipPerf.charAt(j);
			}
			
			String[] data = new String[10];
			
			data[0] = Float.toString(macOran);
			data[1] = favPerf;
			data[2] = rakipPerf;
			data[3] = favRank;
			data[4] = rakipRank;
			
			String son2019 = "e";
			for(Element row : karsilastirma.select("div.p0c-match-head-to-head__last-games div.p0c-match-head-to-head__last-games--row")) {
				int favPuan = 0;
				int rakipPuan = 0;
				if(row.text().contains("/19")) {
					String[] rowAsArray = row.text().split("-");
					if(rowAsArray.length>2) {
						System.err.println("ERROR in head to head games");
						err=true;
					}
					if(rowAsArray[0].contains(favoriName)) {
						favPuan = Character.getNumericValue(rowAsArray[0].charAt(rowAsArray[0].length()-1));
						rakipPuan = Character.getNumericValue(rowAsArray[1].charAt(0));
					}
					else if(rowAsArray[1].contains(favoriName)) {
						favPuan = Character.getNumericValue(rowAsArray[1].charAt(0));
						rakipPuan = Character.getNumericValue(rowAsArray[0].charAt(rowAsArray[0].length()-1));
					}
					else {
						System.err.println("favPuan error");
						err = true;
					}
					if(son2019.equals("e")) {
						son2019 = "";
					}
					int diff = favPuan - rakipPuan;
					if (diff > 0) {
						son2019 += "1";
					}
					else if (diff == 0) {
						son2019 += "0";
					}
					else if (diff < 0) {
						son2019 += "-";
					}
					else {
						System.err.println("ERROR fark hesaplama against");
					}
				}
				if(son2019.equals("e")) {
					son2019 = "0";
				}
			}
			
			System.out.println(son2019);
			
			data[5] = "0.7";
			data[6] = son2019;
			data[7] = "1";
			data[8] = sonPerf5;
			data[9] = sonRakipPerf5;
			
			Omega bet = new Omega(data);
			
			float oran = bet.getOran();
			float perf = bet.getPerformance();
			float rakip = bet.getRakipPerformance();
			float rankFark = bet.getRanking();
			float consensus = bet.getConsensus();
			float against = bet.getAgainst();
			float predict = bet.getPredict();
			float perf5 = bet.getPerformanceOfFive();
			float rakip5 = bet.getRakipPerformanceOfFive();
			
			Compare comp = new Compare(oran, perf, rakip, rankFark, consensus, against, predict, perf5, rakip5);
			
			result = comp.getResult();
			System.out.println("Result is " + result +"\n");
			
		} catch (Exception e) {
			System.out.println(url);
			System.out.println(url2);
			System.err.println("FAILED");
			err = true;
		}
		if(err==true) {
			result = false;
		}
		return result;
	}
}
