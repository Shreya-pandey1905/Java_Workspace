package Service;

public class EmpService implements Repo.IempService {

    dao.empDao empDao = new dao.empDao();

    @Override
    public void addEmp(model.emp emp) {
        empDao.addEmp(emp);
    }

    @Override
    public java.util.List<model.emp> getAllEmp() {
        return empDao.getAllEmp();
    }
}
