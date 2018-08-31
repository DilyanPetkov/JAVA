package com.petkov.SpringJDBCexample;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
   public void setDataSource(DataSource ds);
   public void create(String firstName, String lastName, int age);
   public List<Student> listStudents();
   public void delete(int id);
   public void update(int id, int age);
}