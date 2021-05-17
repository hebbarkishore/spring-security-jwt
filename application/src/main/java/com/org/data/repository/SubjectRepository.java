package com.org.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.org.data.entity.Subject;
 
public interface SubjectRepository  extends JpaRepository<Subject,Long>{
}
