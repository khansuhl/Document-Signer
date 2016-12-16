package org.bridgelabz.docsigner.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.bridgelabz.docsigner.model.Document;
import org.bridgelabz.docsigner.service.DocumentService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@Autowired
	private SessionFactory sessionFactory;

	private Session session = sessionFactory.getCurrentSession();

	@RequestMapping(value = "/addDocuments", method = RequestMethod.GET)
	public String getData(Model model) {
		Document document = new Document();

		model.addAttribute("document", document);
		return "addDocuments";
	}

	@RequestMapping(value = "/addDocuments", method = RequestMethod.POST)
	public String addDocument(@ModelAttribute("document") Document document, BindingResult result,
			@RequestParam("file") MultipartFile file) {

		System.out.println("Name:" + document.getName());
		System.out.println("Desc:" + document.getDescription());
		System.out.println("File:" + file.getName());
		System.out.println("ContentType:" + file.getContentType());

		try {

			byte[] fileBytes = file.getBytes();

			Blob blob = Hibernate.getLobCreator(session).createBlob(fileBytes);

			document.setFilename(file.getOriginalFilename());
			document.setContent(blob);
			document.setContentType(file.getContentType());

			session.save(blob);

			try {
				blob.free();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		documentService.addDocument(document);
		return "success";

	}

}