package com.Christus.Alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Christus.Alunos.entity.Directory;

public interface DirectoryRepository extends JpaRepository<Directory, String>  {

}
