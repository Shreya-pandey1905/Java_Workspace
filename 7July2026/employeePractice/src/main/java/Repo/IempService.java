package Repo;

import model.emp;

import java.util.List;

public interface IempService {

    void addEmp(emp emp);

    List<emp> getAllEmp();
}
