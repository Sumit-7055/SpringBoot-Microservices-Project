import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: {},
            department: {},
            organization: {},
            employeeId: new URLSearchParams(window.location.search).get('id') || '',
            loading: true,
            error: ''
        }
    }

    componentDidMount() {
        const employeeId = this.state.employeeId;
        if (!employeeId) {
            this.setState({ loading: false });
            return;
        }

        this.loadEmployee(employeeId);
    }

    loadEmployee = (employeeId) => {
        this.setState({ employeeId, loading: true, error: '' });
        window.history.replaceState({}, '', `?id=${employeeId}`);

        EmployeeService.getEmployee(employeeId).then((response) => {
            this.setState({
                employees: response.data.employee,
                department: response.data.department,
                organization: response.data.organization,
                loading: false
            });
        }).catch(() => {
            this.setState({
                loading: false,
                error: `Unable to load employee ${employeeId}. Check that this ID exists.`
            });
        });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const employeeId = event.target.elements.employeeId.value.trim();
        if (employeeId) {
            this.loadEmployee(employeeId);
        }
    }

 render() {
        if (this.state.loading) {
            return <div className="container mt-4"><EmployeeSearch employeeId={this.state.employeeId} onSubmit={this.handleSubmit} /><p className="text-center mt-4">Loading employee details...</p></div>;
        }

        if (this.state.error) {
            return <div className="container mt-4"><EmployeeSearch employeeId={this.state.employeeId} onSubmit={this.handleSubmit} /><p className="text-center mt-4 text-danger">{this.state.error}</p></div>;
        }

        return (
            <div className="container"> <br /><br />
                <EmployeeSearch employeeId={this.state.employeeId} onSubmit={this.handleSubmit} />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong> {this.state.employees.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Last Name: </strong> {this.state.employees.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Email: </strong> {this.state.employees.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong> {this.state.department.departmentName }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Description: </strong> {this.state.department.departmentDescription }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong> {this.state.department.departmentCode }</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Organization Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong> Organization Name: </strong> {this.state.organization.organizationName } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Description: </strong> {this.state.organization.organizationDescription } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Code: </strong> {this.state.organization.organizationCode } </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

function EmployeeSearch({ employeeId, onSubmit }) {
    return (
        <form className="row justify-content-center g-2 mb-4" onSubmit={onSubmit}>
            <div className="col-sm-6 col-md-4">
                <label className="visually-hidden" htmlFor="employeeId">Employee ID</label>
                <input id="employeeId" name="employeeId" className="form-control" type="number" min="1" defaultValue={employeeId} placeholder="Enter employee ID" required />
            </div>
            <div className="col-auto">
                <button className="btn btn-primary" type="submit">Load employee</button>
            </div>
        </form>
    );
}

export default EmployeeComponent;