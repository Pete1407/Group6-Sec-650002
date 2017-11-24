
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Font;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelFormat {
	private ArrayList<String> liststudent = new ArrayList<>();

	private ArrayList<String> idlist = new ArrayList<>();
	private ArrayList<String> scorelist = new ArrayList<>();
	private ArrayList<String> gradelist = new ArrayList<>();
	private WritableWorkbook workbook;
	private String a = "";
	private String title = "";

	public void ReadFile(File file) {
		//JFileChooser c = new JFileChooser();
		//int a = c.showOpenDialog(null);
		//if (a == c.APPROVE_OPTION) {
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String h = scan.nextLine();
					if (h.equals("Net score & Grade")) {
						// System.out.println(h);
						liststudent.add(h);
						break;
					}

				}

				while (scan.hasNextLine()) {
					liststudent.add(scan.nextLine());
				}

				// this.print(liststudent);
				title = liststudent.get(0);

				for (int count = 1; count < liststudent.size(); count++) {
					String id = liststudent.get(count).split(" ")[0].trim();
					System.out.println(id);
					idlist.add(id);
					String score = liststudent.get(count).split(" ")[1].trim();
					System.out.println(score);
					scorelist.add(score);
					String grade = liststudent.get(count).split(" ")[2].trim();
					System.out.println(grade);
					gradelist.add(grade);
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}

		//}

	}

	public void WriteFile() {
		JFileChooser c = new JFileChooser();
		int a = c.showSaveDialog(null);
		if (a == c.APPROVE_OPTION) {
			try (FileOutputStream fileOut = new FileOutputStream(c.getSelectedFile());) {

				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

				Row heading = worksheet.createRow(0);
				heading.createCell(0).setCellValue("ID Student:");
				heading.createCell(1).setCellValue("Grade:");
				for (int count = 0; count < 2; count++) {
					CellStyle taylor = workbook.createCellStyle();
					HSSFFont font = workbook.createFont();
					font.setItalic(false);
					font.setFontName(HSSFFont.FONT_ARIAL);
					font.setFontHeightInPoints((short) 11);
					taylor.setFont(font);
					taylor.setVerticalAlignment(CellStyle.ALIGN_CENTER);
					heading.getCell(count).setCellStyle(taylor);
				}

				for (int count3 = 1; count3 < idlist.size(); count3++) {
					Row row = worksheet.createRow(count3);
					Cell cellid = row.createCell(0);
					cellid.setCellValue(idlist.get(count3));

					// Cell cellscore = row.createCell(1);
					// cellscore.setCellValue(scorelist.get(count3));

					Cell cellgrade = row.createCell(1);
					cellgrade.setCellValue(gradelist.get(count3));
				}

				for (int count2 = 0; count2 < 3; count2++) {
					worksheet.autoSizeColumn(count2);
				}

				workbook.write(fileOut);

				System.out.println("Write File Success!!!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void print(ArrayList<String> a) {
		for (int count = 0; count < a.size(); count++) {
			System.out.println(a.get(count));
		}
	}

	public static void main(String[] args) {
		ExcelFormat f = new ExcelFormat();
		f.ReadFile(new File("student4.txt"));
		f.WriteFile();

	}

}
