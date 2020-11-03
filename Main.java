import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main {
	
	public static void main(String args[]) {
		
		String[] allLigs = new String[] {"https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/fikstur/482ofyysbdbeoxauk19yg7tdt"
				,"https://www.mackolik.com/puan-durumu/ingiltere-premier-lig/fikstur/2kwbbcootiqqgmrzs6o5inle5"
				,"https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-tff-1-lig/fikstur/2o9svokc5s7diish3ycrzk7jm"
				,"https://www.mackolik.com/puan-durumu/italya-serie-a/fikstur/1r097lpxe0xn03ihb7wi98kao"
				,"https://www.mackolik.com/puan-durumu/fransa-ligue-1/fikstur/dm5ka0os1e3dxcp3vh05kmp33"
				,"https://www.mackolik.com/puan-durumu/bel%C3%A7ika-1-lig-a/fikstur/4zwgbb66rif2spcoeeol2motx"
				,"https://www.mackolik.com/puan-durumu/hollanda-eredivisie/fikstur/akmkihra9ruad09ljapsm84b3"
				,"https://www.mackolik.com/puan-durumu/almanya-bundesliga/fikstur/6by3h89i2eykc341oz7lv1ddd"
				,"https://www.mackolik.com/puan-durumu/arjantin-premier-lig/fikstur/581t4mywybx21wcpmpykhyzr3"
				,"https://www.mackolik.com/puan-durumu/avusturya-bundesliga/fikstur/5c96g1zm7vo5ons9c42uy2w3r"
				,"https://www.mackolik.com/puan-durumu/azerbaycan-premier-lig/3428tckxcirwwh3o3jgc1m8ji"
				,"https://www.mackolik.com/puan-durumu/rusya-premier-lig/fikstur/3ab1uwtoyjopdj1y1fynyy9jg"
				,"https://www.mackolik.com/puan-durumu/ukrayna-premier-lig/fikstur/6wubmo7di3kdpflluf6s8c7vs"
				,"https://www.mackolik.com/puan-durumu/isko%C3%A7ya-premiership/fikstur/e21cf135btr8t3upw0vl6n6x0"
				,"https://www.mackolik.com/puan-durumu/polonya-ekstraklasa/fikstur/7hl0svs2hg225i2zud0g3xzp2"
				,"https://www.mackolik.com/puan-durumu/yunanistan-s%C3%BCper-lig/fikstur/c0r21rtokgnbtc0o2rldjmkxu"
				,"https://www.mackolik.com/puan-durumu/avustralya-a-lig/fikstur/xwnjb1az11zffwty3m6vn8y6"
				,"https://www.mackolik.com/puan-durumu/beyaz-rusya-premier-lig/fikstur/8y29fg2s85ppcb8uugm5ee8s4"
				,"https://www.mackolik.com/puan-durumu/bosna-hersek-1-lig/fikstur/4yngyfinzd6bb1k7anqtqs0wt"
				,"https://www.mackolik.com/puan-durumu/brezilya-serie-a/fikstur/scf9p4y91yjvqvg5jndxzhxj"
				,"https://www.mackolik.com/puan-durumu/bulgaristan-1-lig/fikstur/c0yqkbilbbg70ij2473xymmqv"
				,"https://www.mackolik.com/puan-durumu/%C3%A7ek-cumhuriyeti-czech-liga/fikstur/bu1l7ckihyr0errxw61p0m05"
				,"https://www.mackolik.com/puan-durumu/danimarka-superliga/fikstur/29actv1ohj8r10kd9hu0jnb0n"
				,"https://www.mackolik.com/puan-durumu/ekvador-premier-a/fikstur/6lwpjhktjhl9g7x2w7njmzva6"
				,"https://www.mackolik.com/puan-durumu/endonezya-lig-1/fikstur/117yqo02rs8dykkxpm274w3bd"
				,"https://www.mackolik.com/puan-durumu/fas-botola-pro/fikstur/1eruend45vd20g9hbrpiggs5u"
				,"https://www.mackolik.com/puan-durumu/g%C3%BCney-afrika-psl/fikstur/yv73ms6v1995b5wny16jcfi3"
				,"https://www.mackolik.com/puan-durumu/g%C3%BCney-kore-k-lig-classic/fikstur/avs3xposm3t9x1x2vzsoxzcbu"
				,"https://www.mackolik.com/puan-durumu/h%C4%B1rvatistan-1-hnl/fikstur/1b70m6qtxrp75b4vtk8hxh8c3"
				,"https://www.mackolik.com/puan-durumu/honduras-ulusal-lig/fikstur/1wwro3z1eb3fl601dju6inlc6"
				,"https://www.mackolik.com/puan-durumu/israil-ligat-haal/fikstur/2xg0qvif1rh7du6wmk2eleku3"
				,"https://www.mackolik.com/puan-durumu/isvi%C3%A7re-s%C3%BCper-lig/fikstur/e0lck99w8meo9qoalfrxgo33o"
				,"https://www.mackolik.com/puan-durumu/jamaika-premier-lig/fikstur/6lrwyoy74oz0t5udrnmuyql6a"
				,"https://www.mackolik.com/puan-durumu/japonya-japon-1-ligi/fikstur/8o5tv5viv4hy1qg9jp94k7ayb"
				,"https://www.mackolik.com/puan-durumu/k%C4%B1br%C4%B1s-rum-kesimi-1-lig/fikstur/btouq8t23agr62ij7e0ju5p6n"
				,"https://www.mackolik.com/puan-durumu/kosta-rika-premier-lig/fikstur/civf31q1inxohs4a03y8reetf"
				,"https://www.mackolik.com/puan-durumu/macaristan-nb-i/fikstur/47s2kt0e8m444ftqvsrqa3bvq"
				,"https://www.mackolik.com/puan-durumu/malta-premier-lig/fikstur/5taraea6mqjjldg9zxswo825y"
				,"https://www.mackolik.com/puan-durumu/meksika-liga-mx/fikstur/2hsidwomhjsaaytdy9u5niyi4"
				,"https://www.mackolik.com/puan-durumu/m%C4%B1s%C4%B1r-premier-lig/fikstur/8k1xcsyvxapl4jlsluh3eomre"
				,"https://www.mackolik.com/puan-durumu/norve%C3%A7-eliteserien/fikstur/9ynnnx1qmkizq1o3qr3v0nsuk"
				,"https://www.mackolik.com/puan-durumu/peru-premier-lig/fikstur/a9vrdkelbgif0gtu3wxsr75xo"
				,"https://www.mackolik.com/puan-durumu/romanya-1-lig/fikstur/89ovpy1rarewwzqvi30bfdr8b"
				,"https://www.mackolik.com/puan-durumu/s%C4%B1rbistan-s%C3%BCper-lig/fikstur/3ww12jab49q8q8mk9avdwjqgk"
				,"https://www.mackolik.com/puan-durumu/slovakya-s%C3%BCper-lig/fikstur/1mpjd0vbxbtu9zw89yj09xk3z"
				,"https://www.mackolik.com/puan-durumu/venezuela-premier-lig/fikstur/46b141eaqq9q7o4gz5gtdpikk"
				,"https://www.mackolik.com/puan-durumu/yeni-zellanda-premiership/fikstur/2pzq7x2gxohh2k98afrlqck0k"
				,"https://www.mackolik.com/puan-durumu/el-salvador-premier-lig/fikstur/ein4fkggto3pdh5msp8huafiq"
				,"https://www.mackolik.com/puan-durumu/almanya-2-bundesliga/fikstur/722fdbecxzcq9788l6jqclzlw"
				,"https://www.mackolik.com/puan-durumu/arjantin-primera-nacional/fikstur/byu00jvt1j6csyv4y1lkt2fm2"
				,"https://www.mackolik.com/puan-durumu/avusturya-2-liga/fikstur/a7247po5qs29o3zsfmt222ydu"
				,"https://www.mackolik.com/puan-durumu/azerbaycan-1lig/fikstur/1pz0ch210cun5hthsvq0lb7x3"
				,"https://www.mackolik.com/puan-durumu/bel%C3%A7ika-1-lig-b/fikstur/af79lqrc0ntom74zq13ccjslo"
				,"https://www.mackolik.com/puan-durumu/beyaz-rusya-1-lig/fikstur/zs18qaehvhg3w1208874zvfa"
				,"https://www.mackolik.com/puan-durumu/brezilya-serie-b/fikstur/5zr0b05eyx25km7z1k03ca9jx"
				,"https://www.mackolik.com/puan-durumu/danimarka-1-lig/fikstur/6ifaeunfdelecgticvxanikzu"
				,"https://www.mackolik.com/puan-durumu/fransa-ligue-2/fikstur/4w7x0s5gfs5abasphlha5de8k"
				,"https://www.mackolik.com/puan-durumu/ingiltere-championship/fikstur/7ntvbsyq31jnzoqoa8850b9b8"
				,"https://www.mackolik.com/puan-durumu/ispanya-2-lig/fikstur/3is4bkgf3loxv9qfg3hm8zfqb"
				,"https://www.mackolik.com/puan-durumu/isvi%C3%A7re-challenge-lig/fikstur/8v97rcbthsxmzqk4ufxws9mug"
				,"https://www.mackolik.com/puan-durumu/italya-serie-b/fikstur/8ey0ww2zsosdmwr8ehsorh6t7"
				,"https://www.mackolik.com/puan-durumu/portekiz-2-lig/fikstur/8sdpk4aerruf515yh76ezo7vi"
				,"https://www.mackolik.com/puan-durumu/rusya-fnl/fikstur/bpo885893xeevnzypvifeaqru"
				,"https://www.mackolik.com/puan-durumu/slovakya-2-lig/fikstur/4qehj8hfxmy6o2ohp4fxinnzo"
				};
		
		//String[] allLigs2 = new String[] {"https://www.mackolik.com/kupa/avrupa-%C5%9Fampiyonlar-ligi/fikstur/4oogyu6o156iphvdvphwpck10"};
		
		try {
			
			
			String endResultAll = "";
			for(String oneLig : allLigs) {
			final Document document = Jsoup.connect(oneLig).get();
			
			/*ArrayList<String> links = new ArrayList<String>();
			for(Element row : document.select("a.p0c-competition-match-list__match-link")) {
				//links.add(row.attr("href"));
			}*/
			
			String ligResult = "";
			
			ArrayList<String> newList = new ArrayList<String>();
			for(Element row : document.select("div.p0c-competition-match-list__match-content a.p0c-competition-match-list__status.p0c-competition-match-list__status--timestamp")) {
				newList.add(row.attr("data-alt-href"));
			}
			
			/*ArrayList<String> links = new ArrayList<String>();
			links.add("https://www.mackolik.com/mac/osmanl%C4%B1spor-fk-vs-altay/7ewq3xgqxdw3l1l4fzv6p8vhm");*/
			
			for (String s : newList) {
				String url = "";
				String url2 = "";
				String[] temp = s.split("karsilastirma/");
			
					for (int i=0; i<temp.length; i++) {
						if(i==temp.length-1) {
							url += "iddaa/";
						}
							url += temp[i];
					}
					
					url2 = s;
			
					//TEK MAÇ TESTİ İÇİN BURASI
					//url = "https://www.mackolik.com/mac/asteras-tripolis-vs-olympiakos/iddaa/em8h0xcr7elcaeuy9c9ozapgq";
					//url2 = "https://www.mackolik.com/mac/asteras-tripolis-vs-olympiakos/karsilastirma/em8h0xcr7elcaeuy9c9ozapgq";
					
					Scraper scraper = new Scraper(url, url2);
					boolean result = scraper.doit();
					
					if(result==true) {

						ligResult += (scraper.favoriName + " vs " + scraper.rakipName + "\n");
					
					}	
				}
			
			endResultAll += ligResult;
			String fileName = "ALLRESULTS";
			FileWriter writer = new FileWriter(new File(fileName+".txt"));
			writer.flush();
			writer.write(endResultAll);	
			writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//String url = "https://www.mackolik.com/mac/hatayspor-vs-boluspor/iddaa/7g68acnftk43jp318lzrdc60a";
		//String url2 = "https://www.mackolik.com/mac/hatayspor-vs-boluspor/karsilastirma/7g68acnftk43jp318lzrdc60a";
		
	/*System.out.println("oran performans rakipperf ligsıraf ligsırau consensus against2019 predictweb");
	
	Scanner scanner = new Scanner(System.in);
	String[] data = scanner.nextLine().split(" ");
	
	Omega bet = new Omega(data);
	
	float oran = bet.getOran();
	float perf = bet.getPerformance();
	float rakip = bet.getRakipPerformance();
	float ligRank = bet.getRanking();
	float consensus = bet.getConsensus();
	float against = bet.getAgainst();
	float predict = bet.getPredict();
	
	Compare comp = new Compare(oran, perf, rakip, ligRank, consensus, against, predict);
	
	System.err.println("\nResult is " + comp.getResult());
	
	*/
		
		/*final String url = "https://sharestobeclosed.telegraph.co.uk/indices/financials/index/MCX";
		
		try {
			
			final Document document = Jsoup.connect(url).get();
			//System.out.println(document.outerHtml());
			
			for(Element row : document.select("table.tablesorter.full tr")) {
				if(row.select("td:nth-of-type(1)").text().equals("")) {
					continue;
				}
				else {
					final String ticker = row.select("td:nth-of-type(1)").text();
					System.out.println(ticker);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//final String firstU = "https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/fikstur/482ofyysbdbeoxauk19yg7tdt";
		/*otomaitik lig almak için
		try {
		Document bla = Jsoup.connect(firstU).get();
		System.out.println(bla.select("span.p0c-competition-list__competition-name"));
		} catch (Exception e) {
			
		}*/
		//String[] allLigs = new String[] {};
	}
}
