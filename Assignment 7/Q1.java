

class Q1{

  public static void main(String[] args) {
    SmartPhone iPhone = new SmartPhone("12");
    iPhone.powerOn();
    iPhone.connectToNetwork("Airtel_Cresc");
    System.out.println(iPhone.toString());
    iPhone.disconnectFromNetwork();
    iPhone.powerOff();
    System.out.println(iPhone.toString());


  }

}

interface PoweredDevice{
  void powerOn();
  void powerOff();
}

interface NetworkEnabled{
  void connectToNetwork(String networkName);
  void disconnectFromNetwork();
}

class SmartPhone implements PoweredDevice,NetworkEnabled{
  Boolean isPoweredOn;
  String connectedNetwork;
  String model;

  

  public SmartPhone(String model) {
    this.model = model;
  }

  @Override
  public void connectToNetwork(String networkName) {
    this.connectedNetwork = networkName;
    System.out.println("Phone connected to Network " + this.connectedNetwork);
  }

  @Override
  public void disconnectFromNetwork() {
    System.out.println("Phone disconnected from Network " + this.connectedNetwork);
    this.connectedNetwork = null;
  }

  @Override
  public void powerOn() {
    System.out.println("Phone Powered On.");
    this.isPoweredOn = true;

  }

  @Override
  public void powerOff() {
    System.out.println("Phone Powered off.");
    this.isPoweredOn = false;
  }

  @Override
  public String toString(){
    String s = "Model Name : " + this.model + "\nPowered On : " + this.isPoweredOn + "\nConnected Network : " + this.connectedNetwork;
    return s;
  }
  
}
