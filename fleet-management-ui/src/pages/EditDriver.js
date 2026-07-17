import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getDriverById, updateDriver } from "../api/DriverService";

function EditDriver() {

    const { id } = useParams();
    const navigate = useNavigate();

    const [driver, setDriver] = useState({
        name: "",
        licenseNumber: "",
        phone: "",
        shiftHours: "",
        status: "AVAILABLE"
    });

    useEffect(() => {
        getDriverById(id)
            .then(res => setDriver(res.data))
            .catch(err => console.error(err));
    }, [id]);

    const handleChange = (e) => {
        setDriver({
            ...driver,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        updateDriver(id, driver)
            .then(() => {
                alert("Driver Updated Successfully");
                navigate("/drivers");
            })
            .catch(err => {
                console.error(err);
                alert("Update Failed");
            });
    };

    return (
        <div className="container mt-4">

            <h2>Edit Driver</h2>

            <form onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label>Name</label>
                    <input
                        className="form-control"
                        name="name"
                        value={driver.name}
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-3">
                    <label>License Number</label>
                    <input
                        className="form-control"
                        name="licenseNumber"
                        value={driver.licenseNumber}
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-3">
                    <label>Phone</label>
                    <input
                        className="form-control"
                        name="phone"
                        value={driver.phone}
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-3">
                    <label>Shift Hours</label>
                    <input
                        type="number"
                        className="form-control"
                        name="shiftHours"
                        value={driver.shiftHours}
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-3">
                    <label>Status</label>

                    <select
                        className="form-control"
                        name="status"
                        value={driver.status}
                        onChange={handleChange}
                    >
                        <option value="AVAILABLE">AVAILABLE</option>
                        <option value="ON_DUTY">ON_DUTY</option>
                        <option value="OFF_DUTY">OFF_DUTY</option>
                    </select>

                </div>

                <button className="btn btn-success">
                    Update Driver
                </button>

            </form>

        </div>
    );
}

export default EditDriver;