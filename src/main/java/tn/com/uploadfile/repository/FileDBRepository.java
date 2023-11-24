package tn.com.uploadfile.repository;

import tn.com.uploadfile.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FileDBRepository extends JpaRepository<FileDB,String>{

}
