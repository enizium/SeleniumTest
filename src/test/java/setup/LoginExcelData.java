package setup;

public class LoginExcelData {
	
	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getCloumnCount();
		Object userdata[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				
				String celldata1 = excel.getCellData(i, j);
				userdata[i - 1][j] = celldata1;
			}
		}
		return userdata;
	}
}
