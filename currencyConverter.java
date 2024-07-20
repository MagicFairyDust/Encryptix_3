import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class currencyConvertor{

	public static void convertRStoUSD()throws  IOException {
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the amount in IND RS:");
		 double Amount = sc.nextDouble();
		  var url_usin = "https://v6.exchangerate-api.com/v6/4b3a1fca94f62bc98155eaeb/pair/INR/USD/"+Amount;
			var request1 = HttpRequest.newBuilder().GET().uri(URI.create(url_usin)).build();
			var client1 = HttpClient.newBuilder().build();
			HttpResponse<String> response1 = null;
			try {
				response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
				System.out.println(response1.body());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
    public static void convertUSDtoRS() {
    	Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter the amount in USD:");
    	 double Amount = sc.nextDouble();
    	 var url_inus = "https://v6.exchangerate-api.com/v6/4b3a1fca94f62bc98155eaeb/pair/USD/INR/"+Amount;
 		var request2 = HttpRequest.newBuilder().GET().uri(URI.create(url_inus)).build();
 		var client2 = HttpClient.newBuilder().build();
 		HttpResponse<String> response2 = null;
		try {
			response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
			 System.out.println(response2.body());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public static void main(String arg[])throws  IOException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		
		System.out.println("Welcome to my currency convertor!!");
		System.out.println("Press 1 for IND RS to USD .");
		System.out.println("Press 2 for USD to IND RS.");
		System.out.println("Press 3 to exit.");
		do {
		  System.out.println("Please enter your choice:");
		  ch = sc.nextInt();
		  switch(ch) {
		  case 1: convertRStoUSD(); break;
		  case 2: convertUSDtoRS(); break;
		  }
		}while(ch<3);
		System.out.println("Thank you for using my currency convertor!!");
		sc.close();
	}
	
}