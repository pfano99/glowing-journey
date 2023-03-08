package za.co.glowing.journey.markets;

public class AlphaVantage implements StockApi {

	private final String apiKey = "UQO0GTPS0T2RYI1H";

	@Override
	public int requests(String symbol, String interval) {
		return 0;
	}

//	private String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol" +
//															 "={}&interval=5min&apikey=";
//
//	public AlphaVantage() {
//		url += apiKey;
//	}
//
//	public int requests(String symbol, String interval) {
//		url = url.replace("{}", symbol);
//
//		String response = sendRequest(url);
//		return 0;
//	}

//	private String sendRequest(String url) throws IOException, InterruptedException {
//// create a client
//		HttpClient httpClient = HttpClient.newHttpClient();
//
//// create a request
//		HttpRequest request = HttpRequest.newBuilder(
//										URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
//						.header("accept", "application/json")
//						.build();
//
//// use the client to send the request
//		HttpResponse<Object> response = httpClient.send(request, null);
//
//// the response:
//		System.out.println(response.body().get().title);

	// Create a neat value object to hold the URL
//		URL _url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

// Open a connection(?) on the URL(??) and cast the response(???)
//		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();

// Now it's "open", we can set the request method, headers etc.
//		connection.setRequestProperty("accept", "application/json");


// This line makes the request
//		InputStream responseStream = connection.getInputStream();

// Manually converting the response body InputStream to APOD using Jackson
//		ObjectMapper mapper = new ObjectMapper();
//		APOD apod = mapper.readValue(responseStream, APOD.class);

// Finally we have the response
//		System.out.println(apod.title);

//	}

}
