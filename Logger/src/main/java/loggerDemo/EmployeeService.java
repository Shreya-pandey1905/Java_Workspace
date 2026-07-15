package loggerDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);

    public void addEmployee(String name){
        if (name==null) {
            logger.error("Employee name cannot be null");
            throw new IllegalStateException("404 NOT FOUND.");
        }else {
            logger.debug("Employee {} logged in",name);
            logger.info("Employee {} created",name);
        }
        logger.info("Employee creation started");

    }
}
