package com.cadastro.service;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cadastro.model.Usuario;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import lombok.Setter;

@Setter
public class GeradorPdfService {
 
	
	private List<Usuario> usuarioList;
	
	public void generate(HttpServletResponse response) throws DocumentException, IOException {
  
  Document document = new Document(PageSize.A4);
  // get the document and write the response to output stream
  PdfWriter.getInstance(document, response.getOutputStream());
  document.open();
  // Add Font
  Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
  fontTiltle.setSize(20);
  // Create Object of Paragraph
  Paragraph paragraph = new Paragraph("Relatório de Alunos", fontTiltle);
  paragraph.setAlignment(Paragraph.ALIGN_CENTER);
  // Add to the document

  document.add(paragraph);
  PdfPTable table = new PdfPTable(4);
  table.setWidthPercentage(100f);
  table.setWidths(new int[] {4, 1, 4, 4 });
  table.setSpacingBefore(5);
  // Create Table Header
  PdfPCell cell = new PdfPCell();
  cell.setBackgroundColor(Color.BLACK);
  cell.setPadding(4);
  // Add Font
  Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
  font.setColor(Color.WHITE);
  
  cell.setPhrase(new Phrase("Nome", font));
  table.addCell(cell);
  cell.setPhrase(new Phrase("Idade", font));
  table.addCell(cell);
  cell.setPhrase(new Phrase("Email", font));
  table.addCell(cell);
  cell.setPhrase(new Phrase("Curso", font));
  table.addCell(cell);
  for (Usuario usuario : usuarioList) {
	
	  
   table.addCell(usuario.getNome());
   table.addCell(String.valueOf(usuario.getIdade()));
   table.addCell(usuario.getEmail());
   table.addCell(usuario.getCurso());

  }

  document.add(table);
  document.close();
 }
}
