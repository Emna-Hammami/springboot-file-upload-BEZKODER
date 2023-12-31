package tn.com.uploadfile.service;
/*
 The File Storage Service will use FileDBRepository to provide following methods:
store(file): receives MultipartFile object, transform to FileDB object and save it to Database
getFile(id): returns a FileDB object by provided Id
getAllFiles(): returns all stored files as list of code>FileDB objects
*/
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.com.uploadfile.model.*;
import tn.com.uploadfile.repository.*;

@Service
public class FileStorageService {
	
	@Autowired
	private FileDBRepository fileDBRepository;
	
	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
		return fileDBRepository.save(FileDB);
		
	}
	
	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}
	
	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
	
	

}
