package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Products;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String path = "C:\\temp\\ws-eclipse\\course\\in.csv";
		
		File sourceFile = new File(path);
		String sourceFolderStr = sourceFile.getParent();
		
		new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		List<Products> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				String[] list = line.split(",");
				products.add(new Products(list[0], Double.parseDouble(list[1]), Integer.parseInt(list[2])));
				line = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				
				for (Products product:products) {
					bw.write(product.getName() + ", " + String.format("%.2f", product.totalValue()));
					bw.newLine();
					}
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println("Success!");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
