package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;

import dataService.businessHallDataService.ArrivalDataService;
import dataService.businessHallDataService.DeliveryDataService;
import dataService.businessHallDataService.DriverDataService;
import dataService.businessHallDataService.EntruckDataService;
import dataService.businessHallDataService.TruckDataService;
import dataService.deliveryDataService.ReceiveDataService;
import dataService.deliveryDataService.SendDataService;
import dataService.financeDataService.AccountDataService;
import dataService.financeDataService.IncomeDataService;
import dataService.financeDataService.PaymentDataService;
import dataService.intermidateDataService.TransferDataService;
import dataService.inventoryDataService.EntryDataService;
import dataService.inventoryDataService.InventoryDataService;
import dataService.inventoryDataService.ShipmentDataService;
import dataService.logDataService.LogDataService;
import dataService.logisticsDataService.LogisticsDataService;
import dataService.manageDataService.InstitutionDataService;
import dataService.manageDataService.PriceConstDataService;
import dataService.manageDataService.SalaryDataService;
import dataService.manageDataService.UserDataService;

public class RMIHelper {

	private static File config;
	private static String IP;
	private static String PORT;
	private static String urlPrefix;

	static {
		// InputStream is = RMIHelper.class
		// .getResourceAsStream("/client/config.txt");
		config = new File(RMIHelper.class.getResource("/client/config.txt")
				.getFile());

		// config = new File(Runtime.getRuntime().getClass()
		// .getResource("/client/config.txt").getFile());
		// config = new File("src/main/java/client/config.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(config));
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(is));
			IP = br.readLine();
			PORT = br.readLine();
			urlPrefix = "rmi://" + IP + ":" + PORT + "/";
			br.close();

		} catch (IOException e) {
			IP = "localhost";
			PORT = "1099";
			urlPrefix = "rmi://" + IP + ":" + PORT + "/";
			e.printStackTrace();
		}

	}
	// 定义各种 dataService 的引用 根据不同的人员以及执行的操作进行不同的初始化

	private static AccountDataService accountDataService;
	private static ArrivalDataService arrivalDataService;
	private static DeliveryDataService deliveryDataService;
	private static DriverDataService driverDataService;
	private static EntruckDataService entruckDataService;
	private static EntryDataService entryDataService;
	private static PaymentDataService paymentDataService;
	private static InventoryDataService inventoryDataService;
	private static LogDataService logDataService;
	private static LogisticsDataService logisticsDataService;
	private static IncomeDataService incomeDataService;
	// private static MoneyDataService moneyDataService;
	private static ReceiveDataService receiveDataService;
	private static SendDataService sendDataService;
	private static ShipmentDataService shipmentDataService;
	private static TransferDataService transferDataService;
	private static TruckDataService truckDataService;
	private static UserDataService userDataService;
	private static PriceConstDataService priceConstDataService;
	private static InstitutionDataService institutionDataService;
	private static SalaryDataService salaryDataService;

	// //
	// public synchronized static void init() throws ClientInitException {
	// if (inited) {
	// return;
	// }
	//
	// try {
	// initAccountDataService();
	// inited = true;
	// } catch (Exception e) {
	// throw new ClientInitException(e);
	// }
	// }
	//
	// //

	// 初始化AccountDataService对象 下面的各个方法都是对对应的DataService进行相应的初始化
	public static void initAccountDataService() throws ClientInitException {
		try {
			accountDataService = (AccountDataService) Naming.lookup(urlPrefix
					+ "account-data");
			System.out.println("RMI远程调用AccountDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initArrivalDataService() throws ClientInitException {
		try {
			arrivalDataService = (ArrivalDataService) Naming.lookup(urlPrefix
					+ "arrival-data");
			System.out.println("RMI远程调用ArrivalDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initDeliveryDataService() throws ClientInitException {
		try {
			deliveryDataService = (DeliveryDataService) Naming.lookup(urlPrefix
					+ "delivery-data");
			System.out.println("RMI远程调用DeliveryDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initDriverDataService() throws ClientInitException {
		try {
			driverDataService = (DriverDataService) Naming.lookup(urlPrefix
					+ "driver-data");
			System.out.println("RMI远程调用DriverDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initEntruckDataService() throws ClientInitException {
		try {
			entruckDataService = (EntruckDataService) Naming.lookup(urlPrefix
					+ "entruck-data");
			System.out.println("RMI远程调用EntruckDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initEntryDataService() throws ClientInitException {
		try {
			entryDataService = (EntryDataService) Naming.lookup(urlPrefix
					+ "entry-data");
			System.out.println("RMI远程调用EntryDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initPaymentDataService() throws ClientInitException {
		try {
			paymentDataService = (PaymentDataService) Naming.lookup(urlPrefix
					+ "payment-data");
			System.out.println("RMI远程调用FormDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initInventoryDataService() throws ClientInitException {
		try {
			inventoryDataService = (InventoryDataService) Naming
					.lookup(urlPrefix + "inventory-data");
			System.out.println("RMI远程调用InventoryDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initLogDataService() throws ClientInitException {
		try {
			logDataService = (LogDataService) Naming.lookup(urlPrefix
					+ "log-data");
			System.out.println("RMI远程调用LogDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initLogisticsDataService() throws ClientInitException {
		try {
			logisticsDataService = (LogisticsDataService) Naming
					.lookup(urlPrefix + "logistics-data");
			System.out.println("RMI远程调用LogisticsDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initInstitutionDataService() throws ClientInitException {
		try {
			institutionDataService = (InstitutionDataService) Naming
					.lookup(urlPrefix + "institution-data");
			System.out.println("RMI远程调用InstitutionDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	public static void initIncomeDataService() throws ClientInitException {
		try {
			incomeDataService = (IncomeDataService) Naming.lookup(urlPrefix
					+ "income-data");
			System.out.println("RMI远程调用IncomeDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}
	}

	// public static void initMoneyDataService() throws ClientInitException {
	// try {
	// moneyDataService = (MoneyDataService) Naming.lookup(urlPrefix
	// + "money-data");
	// System.out.println("RMI远程调用MoneyDataService成功");
	// } catch (Exception e) {
	// throw new ClientInitException(e);
	// }
	// }

	public static void initReceiveDataService() throws ClientInitException {
		try {
			receiveDataService = (ReceiveDataService) Naming.lookup(urlPrefix
					+ "receive-data");
			System.out.println("RMI远程调用ReceiveDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initSendDataService() throws ClientInitException {
		try {
			sendDataService = (SendDataService) Naming.lookup(urlPrefix
					+ "send-data");
			System.out.println("RMI远程调用SendDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initShipmentDataService() throws ClientInitException {
		try {
			shipmentDataService = (ShipmentDataService) Naming.lookup(urlPrefix
					+ "shipment-data");
			System.out.println("RMI远程调用ShipmentDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initTransferDataService() throws ClientInitException {
		try {
			transferDataService = (TransferDataService) Naming.lookup(urlPrefix
					+ "transfer-data");
			System.out.println("RMI远程调用TrandferDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initTruckDataService() throws ClientInitException {
		try {
			truckDataService = (TruckDataService) Naming.lookup(urlPrefix
					+ "truck-data");
			System.out.println("RMI远程调用TruckDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initUserDataService() throws ClientInitException {
		try {
			userDataService = (UserDataService) Naming.lookup(urlPrefix
					+ "user-data");
			System.out.println("RMI远程调用UserDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initPriceConstDataService() throws ClientInitException {
		try {
			priceConstDataService = (PriceConstDataService) Naming
					.lookup(urlPrefix + "priceconst-data");
			System.out.println("RMI远程调用PriceConstDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	public static void initSalaryDataService() throws ClientInitException {
		try {
			salaryDataService = (SalaryDataService) Naming.lookup(urlPrefix
					+ "salary-data");
			System.out.println("RMI远程调用SalaryDataService成功");
		} catch (Exception e) {
			throw new ClientInitException(e);
		}

	}

	// 获取各类的DataService 的对象 根据方法名字自己看
	// 就是各种private 的dataService 属性的Getter方法
	// 不需要Setter方法
	public static AccountDataService getAccountDataService() {
		return accountDataService;
	}

	public static ArrivalDataService getArrivalDataService() {
		return arrivalDataService;
	}

	public static DeliveryDataService getDeliveryDataService() {
		return deliveryDataService;
	}

	public static DriverDataService getDriverDataService() {
		return driverDataService;
	}

	public static EntruckDataService getEntruckDataService() {
		return entruckDataService;
	}

	public static EntryDataService getEntryDataService() {
		return entryDataService;
	}

	public static PaymentDataService getPaymentDataService() {
		return paymentDataService;
	}

	public static InventoryDataService getInventoryDataService() {
		return inventoryDataService;
	}

	public static LogDataService getLogDataService() {
		return logDataService;
	}

	public static LogisticsDataService getLogisticsDataService() {
		return logisticsDataService;
	}

	public static IncomeDataService getIncomeDataService() {
		return incomeDataService;
	}

	// public static MoneyDataService getMoneyDataService() {
	// return moneyDataService;
	// }

	public static ReceiveDataService getReceiveDataService() {
		return receiveDataService;
	}

	public static SendDataService getSendDataService() {
		return sendDataService;
	}

	public static ShipmentDataService getShipmentDataService() {
		return shipmentDataService;
	}

	public static TransferDataService getTransferDataService() {
		return transferDataService;
	}

	public static TruckDataService getTruckDataService() {
		return truckDataService;
	}

	public static UserDataService getUserDataService() {
		return userDataService;
	}

	public static InstitutionDataService getInstitutionDataService() {
		return institutionDataService;
	}

	public static PriceConstDataService getPriceConstDataService() {
		return priceConstDataService;
	}

	public static SalaryDataService getSalaryDataService() {
		return salaryDataService;

	}

	public static String getIP() {
		return IP;
	}

	public static String getPORT() {
		return PORT;
	}

	public static void applyConfig(String ip, String port) {
		IP = ip;
		PORT = port;
		urlPrefix = "rmi://" + IP + ":" + PORT + "/";
		try {
			FileWriter fw = new FileWriter(config);
			fw.write("");
			fw.append(ip + "\n");
			fw.append(port);
			fw.flush();
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
