package businessLogic.financeBL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import po.financePO.IncomePO;
import po.financePO.PaymentPO;
import po.logPO.LogPO;
import presentation.MainFrame;
import util.DateUtil;
import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;
import businessLogic.businessHallBL.CashRegisterBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.logDataService.LogDataService;

public class FormBL {

	private List<IncomePO> incomes;
	private List<PaymentPO> payments;
	private LogDataService logDS;
	private File excel;

	public FormBL() {
		try {
			RMIHelper.initLogDataService();
			logDS = RMIHelper.getLogDataService();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出选定日期区间的经营情况表
	 * 
	 * @param start开始时间
	 * @param end截止时间
	 * @return 成功与否
	 */
	public void exportRunForm(Date start, Date end) {

		excel = new File(System.getProperty("user.home") + File.separator
				+ "Desktop" + File.separator + DateUtil.dateToString(start)
				+ "至" + DateUtil.dateToString(end) + "经营情况表" + ".xls");
		//写入数据 导出报表
		export(excel,createRunForm());
		try {
			logDS.add(new LogPO(new Date(),
					MainFrame.getUser().getIdentityID(), "导出"
							+ DateUtil.dateToString(start) + "至"
							+ DateUtil.dateToString(end) + "经营情况表"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出截至到当先日期的成本收益表
	 * 
	 * @return 成功显示与否
	 */
	public void exportCostForm() {
		excel = new File(System.getProperty("user.home") + File.separator
				+ "Desktop" + File.separator + "成本收益表" + ".xls");
		//写入数据 导入报表
		export(excel,createCostForm());
		try {
			logDS.add(new LogPO(new Date(),
					MainFrame.getUser().getIdentityID(), "导出成本收益表"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取截止到当前时间的收款单
	 */
	public void getIncomes() {
		try {
			CashRegisterBL cashBL = new CashRegisterBL();
			incomes = cashBL.getIncomeList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取截止到当前日期的付款单的list
	 */
	public void getPayments() {
		try {
			PaymentBL payBL = new PaymentBL();
			payments = payBL.getPaymentList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取时间范围内的付款单的list
	 * 
	 * @param start
	 * @param end
	 */
	public void getIncomes(Date start, Date end) {
		try {
			CashRegisterBL cashBL = new CashRegisterBL();
			incomes = cashBL.getIncomeBetweenDate(start, end);

		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 获取时间范围内的付款单的List
	 * 
	 * @param start
	 * @param end
	 */
	public void getPayments(Date start, Date end) {
		PaymentBL payBL;
		try {
			payBL = new PaymentBL();
			payments = payBL.betweenDate(start, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}



	/**
	 * 将符合条件的收款返回一个VO list
	 * 
	 * @return
	 */
	public List<IncomeVO> getIncomeList() {
		List<IncomeVO> result = new ArrayList<IncomeVO>();
		for (IncomePO po : incomes) {
			result.add(new IncomeVO(po));
		}
		return result;
	}

	/**
	 * 将符合条件的付款单的VO返回一个List
	 * 
	 * @return
	 */
	public List<PaymentVO> getPaymentList() {
		List<PaymentVO> result = new ArrayList<PaymentVO>();
		for (PaymentPO po : payments) {
			result.add(new PaymentVO(po));
		}
		return result;
	}


	
	//传入一个文件和一个工作簿的数据 将数据写入到文件中
	private void export(File file, HSSFWorkbook data) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream stream = FileUtils.openOutputStream(file);
			data.write(stream);
			data.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private HSSFWorkbook createRunForm(){
		HSSFWorkbook workbook = new HSSFWorkbook();
		String title1[] = {"单据状态","填写人工号","日期","快递员工号","收款金额"};
		String title2[] =  {"单据状态","填写人工号","日期","收款方姓名","付款类型","付款账号","备注","付款金额"};
		HSSFSheet incomeSheet= workbook.createSheet("收款单");
		HSSFSheet paySheet = workbook.createSheet("付款单");
		
		HSSFRow row_i = incomeSheet.createRow(0);
		HSSFRow row_p = paySheet.createRow(0);
		HSSFCell cell =null;
		//初始化表头
		for(int i = 0 ; i < title1.length ; i++){
			cell = row_i.createCell(i);
			cell.setCellValue(title1[i]);
		}
		for(int i = 0 ; i < title2.length ; i++){
			cell = row_p.createCell(i);
			cell.setCellValue(title2[i]);
		}
		for (int i = 1; i <= incomes.size() ; i++) {
			IncomePO po = incomes.get(i) ;
			HSSFRow next = incomeSheet.createRow(i);
			HSSFCell cell2 = next.createCell(0);
			cell2.setCellValue(po.getState().getReceiptsStateString());
			cell2 = next.createCell(1);
			cell2.setCellValue(po.getUserID());
			cell2 = next.createCell(2);
			cell2.setCellValue(po.getDate());
			cell2 = next.createCell(3);
			cell2.setCellValue(po.getKdyID());
			cell2 = next.createCell(4);
			cell2.setCellValue(po.getIncome());
		}
		for (int i = 1; i <= payments.size(); i++) {
			PaymentPO po = payments.get(i);
			HSSFRow next = paySheet.createRow(i);
			HSSFCell cell2 = next.createCell(0);
			cell2.setCellValue(po.getState().getReceiptsStateString());
			cell2 = next.createCell(1);
			cell2.setCellValue(po.getUserID());
			cell2 = next.createCell(2);
			cell2.setCellValue(po.getD());
			cell2 = next.createCell(3);
			cell2.setCellValue(po.getName());
			cell2 = next.createCell(4);
			cell2.setCellValue(po.getType());
			cell2 = next.createCell(5);
			cell2.setCellValue(po.getBankID());
			cell2 = next.createCell(6);
			cell2.setCellValue(po.getComment());
			cell2 = next.createCell(7);
			cell2.setCellValue(po.getAmmounts());
		}
		return workbook;
	}
	
	private HSSFWorkbook createCostForm(){
		Iterator<IncomePO> it_i = incomes.iterator();
		Iterator<PaymentPO> it_p = payments.iterator();
		double incomeTotal = incomeTotal();
		double payTotal = payTotal();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("成本收益表");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		String title[] = {"单据类型","时间","金额"};
		for(int i = 0 ; i < title.length ; i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		for(int i = 1 ; i <= incomes.size() ; i++){
			IncomePO po = it_i.next();
			HSSFRow next = sheet.createRow(i);
			HSSFCell cell2 = next.createCell(0);
			cell2.setCellValue("收款单");
			cell2 = next.createCell(1);
			cell2.setCellValue(po.getIncome());
		}
		row = sheet.createRow(incomes.size()+1);
		cell = row.createCell(0);
		cell.setCellValue("合计：");
		cell = row.createCell(1);
		cell.setCellValue(incomeTotal);
		for(int i = 2+incomes.size() ; i <= incomes.size()+payments.size()+1 ; i++){
			PaymentPO po = it_p.next();
			HSSFRow next = sheet.createRow(i);
			HSSFCell cell2 = next.createCell(0);
			cell2.setCellValue("收款单");
			cell2 = next.createCell(1);
			cell2.setCellValue(po.getAmmounts());
		}
		row = sheet.createRow(incomes.size()+2+payments.size());
		cell = row.createCell(0);
		cell.setCellValue("合计：");
		cell = row.createCell(1);
		cell.setCellValue(payTotal);
		row = sheet.createRow(incomes.size()+3+payments.size());
		cell = row.createCell(0);
		cell.setCellValue("收益：");
		cell = row.createCell(1);
		cell.setCellValue(incomeTotal-payTotal);
		return workbook;
	}
	
	public double incomeTotal(){
		double result= 0 ;
		for(IncomePO po : incomes){
			result+=po.getIncome();
		}
		return result;
	}
	
	public double payTotal(){
		double result =0;
		for(PaymentPO po : payments){
			result+=po.getAmmounts();
		}
     return result;
	}
}
