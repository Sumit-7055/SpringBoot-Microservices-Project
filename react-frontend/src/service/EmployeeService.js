import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL = "/api/employees";

class EmployeeService {
    getEmployee(employeeId) {
       return axios.get(EMPLOYEE_SERVICE_BASE_URL + '/' + employeeId);
    }
}

export default new EmployeeService();