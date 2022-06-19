/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocumentDAO;
import entity.Document;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author berat
 */
@Named("documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

    private Document documents;
    private List<Document> documentsList;
    private DocumentDAO documentsDao;

    private Part doc;
    private final String uploadTo = "C:\\Users\\berat\\Documents\\NetBeansProjects\\Assets\\";

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            documents = this.getDocuments();
            documents.setFilePath(f.getParent());
            documents.setFileName(f.getName());
            documents.setFileType(doc.getContentType());

            this.getDocumentsDao().insert(documents);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocuments() {
        if (this.documents == null) {
            this.documents = new Document();
        }
        return documents;
    }

    public DocumentDAO getDocumentsDao() {
        if (this.documentsDao == null) {
            this.documentsDao = new DocumentDAO();
        }
        return documentsDao;
    }

    public void setDocumentsDao(DocumentDAO documentsDao) {
        this.documentsDao = documentsDao;
    }

    public void setDocuments(Document documents) {
        this.documents = documents;
    }

    public List<Document> getDocumentsList() {
        this.documentsList = this.getDocumentsDao().findAll();
        return documentsList;
    }

    public void setDocumentsList(List<Document> documentsList) {
        this.documentsList = documentsList;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
}
