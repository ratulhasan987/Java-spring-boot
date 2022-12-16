package com.fileupload.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fileupload.model.FileModel;

@Repository
public interface FileRepo extends JpaRepository<FileModel, Long> {

}
