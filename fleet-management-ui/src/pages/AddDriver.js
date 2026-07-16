import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { addDriver } from "../api/DriverService";

function AddDriver() {

    const navigate = useNavigate();

    const [driver, setDriver] = useState({
        name: "",
        licenseNumber: "",
        phone: "",
        shiftHours: "",
        status: "AVAILABLE"
    });

    const handleChange = (e) => {

        setDriver({
            ...driver,
            [e.target.name]: e.target.value
        });

    };

    const handleSubmit = (e) => {

        e.preventDefault();

        addDriver(driver)
            .then(() => {
                alert("Driver Added Successfully");
                navigate("/drivers");
            })
            .catch(err => {
                console.error(err);
                alert("Failed to add driver");
            });

    };

    return (

        <div className="container mt-4">

            <h2>Add Driver</h2>

            <form onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label>Name</label>
                    <input
                        type="text"
                        name="name"
                        className="form-control"
                        value={driver.name}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="mb-3">
                    <label>License Number</label>
                    <input
                        type="text"
                        name="licenseNumber"
                        className="form-control"
                        value={driver.licenseNumber}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="mb-3">
                    <label>Phone</label>
                    <input
                        type="text"
                        name="phone"
                        className="form-control"
                        value={driver.phone}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="mb-3">
                    <label>Shift Hours</label>
                    <input
                        type="number"
                        name="shiftHours"
                        className="form-control"
                        value={driver.shiftHours}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="mb-3">

                    <label>Status</label>

                    <select
                        name="status"
                        className="form-control"
                        value={driver.status}
                        onChange={handleChange}
                    >

                        <option value="AVAILABLE">AVAILABLE</option>
                        <option value="ACTIVE">ACTIVE</option>
                        <option value="INACTIVE">INACTIVE</option>

                    </select>

                </div>

                <button className="btn btn-success">
                    Save Driver
                </button>

            </form>

        </div>

    );

}

export default AddDriver;