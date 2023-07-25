package com.quantaGenious.spring.login.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "files")
public class  File {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	    @NotBlank
	    private String fileName;
	    
	    @NotBlank
	    @Size(max = 20)
	    private String fileType;

	    @Lob
	    private byte[] data;

	    public File() {

	    }

	    public File(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }

}
