
import java.util.List;
import java.util.stream.Stream;

public class Q3 {

  public static void main(String[] args) {

List<String> stockBatch = List.of("AAPL", "GOOGL", "TSLA");
StockProcessor stockProcessor = new StockProcessor("StockMarket", stockBatch);
stockProcessor.loadData();
stockProcessor.processData(); 

Stream<String> stockStream = Stream.of("AAPL", "AMZN", "TSLA"); 
stockProcessor.processData(stockStream);

List<String> transactionBatch = List.of("TXN1", "TXN2", "TXN3");
TransactionProcessor transactionProcessor = new TransactionProcessor("BankTransactions", transactionBatch);
transactionProcessor.loadData(); 
transactionProcessor.processData();
transactionProcessor.aggregateData("User123", "High Risk");

List<String> cryptoBatch = List.of("BTC", "ETH", "XRP");
Stream<String> cryptoStream = Stream.of("BTC", "ETH", "XRP");
CryptoProcessor cryptoProcessor = new CryptoProcessor("CryptoExchange", cryptoBatch);
cryptoProcessor.loadData();
cryptoProcessor.processData();
cryptoProcessor.aggregateData("Ethereum");
cryptoProcessor.processData(cryptoStream);

  }
  

}

// DISTRIBUTED DATA PROCESSOR

abstract class DistributedDataProcessor{
  String sourceName;
  List<String>data;

  DistributedDataProcessor(String sourceName,List<String>data){
    this.sourceName = sourceName;
    this.data = data;
  }

  abstract void processData();
  abstract void processData(Stream<String>rts);

  abstract void aggregateData(String aggregationType);

  void loadData(){
    System.out.println("Loading data in : ");
    data.forEach(comp->{
      System.out.println("-" + comp + "-" );
    });
  }


}

// STOCK PROCESSOR

class StockProcessor extends DistributedDataProcessor{



  StockProcessor(String sourceName, List<String> data) {
    super(sourceName, data);
  }

  @Override
  void processData() {
    System.out.println("Processing batched data for stock processing : ");
    data.forEach(itm->{
      System.out.println("Processing " + itm);
    });
  }

  @Override
  void processData(Stream<String> rts) {
    System.out.println("Processing Real Time Stream of Stock Data.");
    rts.parallel().forEach(data->{
      System.out.println("Processing " + data + " in parallel execution method.");
    });

    
    
  }

  @Override
  void aggregateData(String agType) {
    System.out.println("Aggregating with type : " + agType);

    if( agType.equalsIgnoreCase("hourly") || agType.equalsIgnoreCase("weekly") || agType.equalsIgnoreCase("daily")){
      System.out.println("Aggregation performing on stock data with aggr. type " + agType);
    }
   
  }
  
}

// TRANSACTION PROCESSOR

class TransactionProcessor extends DistributedDataProcessor{

  TransactionProcessor(String sourceName, List<String> data) {
    super(sourceName, data);
  }

  @Override
  void processData() {
    System.out.println("Processing batched data for transaction processing : ");
    data.forEach(itm->{
      System.out.println("Processing " + itm);
    });
  }

  @Override
  void processData(Stream<String> rts) {
    System.out.println("Processing Real Time Stream of Transaction Data.");
    rts.parallel().forEach(data->{
      System.out.println("Processing " + data + " in parallel execution method.");
    });


  }

  @Override
  void aggregateData(String user) {
    System.out.println("Performing aggregation on data for user : "+user);
  }

  void aggregateData(String user,String riskScore){
    System.out.println("Performing aggregation on data for user " + user + " with risk score " + riskScore);
  }

  
  
}

// CRYPTOCURRENCY PROCESSOR

class CryptoProcessor extends DistributedDataProcessor{

  CryptoProcessor(String sourceName, List<String> data) {
    super(sourceName, data);
  }

  @Override
  void processData() {
    System.out.println("Processing batched data for Cryptocurrency processing : ");
    data.forEach(itm->{
      System.out.println("Processing " + itm);
    });

  }

  @Override
  void processData(Stream<String> rts) {
    System.out.println("Processing Real Time Stream of CryptoCurrency Data.");
    rts.parallel().forEach(data->{
      System.out.println("Processing " + data + " in parallel execution method.");
    });

  }

  @Override
  void aggregateData(String currency) {
    System.out.println("Aggregation of currency " + currency);

  }
  
}