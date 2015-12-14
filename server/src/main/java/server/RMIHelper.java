package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dataServiceImpl.AccountDataServiceImpl;
import dataServiceImpl.ArrivalDataServiceImpl;
import dataServiceImpl.DeliveryDataServiceImpl;
import dataServiceImpl.EntruckDataServiceImpl;
import dataServiceImpl.EntryDataServiceImpl;
import dataServiceImpl.IncomeDataServiceImpl;
import dataServiceImpl.InstitutionDataServiceImpl;
import dataServiceImpl.InventoryDataServiceImpl;
import dataServiceImpl.LogDataServiceImpl;
import dataServiceImpl.LogisticsDataServiceImpl;
import dataServiceImpl.PaymentDataServiceImpl;
import dataServiceImpl.PriceConstDataServiceImpl;
import dataServiceImpl.ReceiveDataServiceImpl;
import dataServiceImpl.SalaryDataServiceImpl;
import dataServiceImpl.SendDataServiceImpl;
import dataServiceImpl.ShipmentDataServiceImpl;
import dataServiceImpl.TransferDataServiceImpl;
import dataServiceImpl.TruckDataServiceImpl;
import dataServiceImpl.UserDataServiceImpl;

/**
 * RMI远程调用方法的服务器端的RMIHelper类
 * 
 * @author 王栋
 *
 */
public class RMIHelper {

	// 建立一个Map 将 String 类型和 具体的类进行 键值对配对操作

	private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP = new HashMap<>();

	// 设置服务器的端口.号为1099
	private static final int PORT = 1099;

	// 设置初始化状态为false
	private static boolean inited = false;

	// 静态块 在该类加载的时候执行
	// 在构造之前就初始化惹 走在构造函数之前 先是加载静态变量 然后四静态语句块 最后是构造方法
	// 可以自己写代码试验一下
	static {

		// 将dataService 里面的实现类加入到这个哈希表图中通过键值对来进行RMI的远程调用

		NAMING_MAP.put("account-data", AccountDataServiceImpl.class);
		// NAMING_MAP.put("approve-data", ApproveDataServiceImpl.class);
		NAMING_MAP.put("arrival-data", ArrivalDataServiceImpl.class);
		NAMING_MAP.put("delivery-data", DeliveryDataServiceImpl.class);
		NAMING_MAP.put("entruck-data", EntruckDataServiceImpl.class);
		NAMING_MAP.put("entry-data", EntryDataServiceImpl.class);
		NAMING_MAP.put("payment-data", PaymentDataServiceImpl.class);
		NAMING_MAP.put("inventory-data", InventoryDataServiceImpl.class);
		NAMING_MAP.put("log-data", LogDataServiceImpl.class);
		NAMING_MAP.put("logistics-data", LogisticsDataServiceImpl.class);
		NAMING_MAP.put("income-data", IncomeDataServiceImpl.class);
//		NAMING_MAP.put("money-data", MoneyDataServiceImpl.class);
		NAMING_MAP.put("receive-data", ReceiveDataServiceImpl.class);
		NAMING_MAP.put("send-data", SendDataServiceImpl.class);
		NAMING_MAP.put("shipment-data", ShipmentDataServiceImpl.class);
		NAMING_MAP.put("transfer-data", TransferDataServiceImpl.class);
		NAMING_MAP.put("truck-data", TruckDataServiceImpl.class);
		NAMING_MAP.put("institution-data", InstitutionDataServiceImpl.class);
		NAMING_MAP.put("priceconst-data", PriceConstDataServiceImpl.class);
		NAMING_MAP.put("user-data", UserDataServiceImpl.class);
		NAMING_MAP.put("salary-data", SalaryDataServiceImpl.class);

	}

	// 初始化该类 抛出对应的异常
	public synchronized static void init() throws ServerInitException {
		// 如果该类已经被初始化了那么就不用再初始化 （inited一开始是false 初始化后才被设置为true）
		if (inited) {
			return;
		}

		// 如果没被初始化就开始进行如下操作
		try {
			LocateRegistry.createRegistry(PORT);
			for (Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP
					.entrySet()) {
				String name = entry.getKey();
				Class<? extends UnicastRemoteObject> clazz = entry.getValue();
				UnicastRemoteObject proxy = clazz.newInstance();
				Naming.rebind(name, proxy);
			}
			// 初始化完毕 设置初始化状态为真
			inited = true;
		} catch (Exception e) {
			throw new ServerInitException(e);
		}
	}
}
