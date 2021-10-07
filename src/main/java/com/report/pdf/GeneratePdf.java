/**
 * 
 */
package com.report.pdf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

/**
 * @author Dell
 *
 */
public class GeneratePdf {
	
	public GeneratePdf( ArrayList<String> listUsers) {
    }
 	    private List<String> listUsers;

	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	         
	        cell.setPhrase(new Phrase("User ID", font));
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (User user : listUsers) {
	            table.addCell(String.valueOf(user.getId()));
	            table.addCell(user.getEmail());
	            table.addCell(user.getFullName());
	            table.addCell(user.getRoles().toString());
	            table.addCell(String.valueOf(user.isEnabled()));
	        }
	    }
	         
	    @GetMapping("/users/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<User> listUsers = service.listAll();
	         
	        exporter.export(response);
	         
	    }
	}
}
