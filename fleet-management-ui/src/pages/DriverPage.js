import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getDrivers, deleteDriver } from "../api/DriverService";

function DriverPage() {

    const [drivers, setDrivers] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        loadDrivers();
    }, []);

    const loadDrivers = () => {
        getDrivers()
            .then(res => {
                console.log("API Response:", res.data);
                setDrivers(res.data);
            })
            .catch(err => {
                console.error("API Error:", err);
            });
    };

    const removeDriver = (id) => {

        if (window.confirm("Are you sure you want to delete this driver?")) {

            deleteDriver(id)
                .then(() => {
                    alert("Driver deleted successfully");
                    loadDrivers();
                })
                .catch(err => {
                    console.error(err);
                    alert("Failed to delete driver");
                });

        }

    };

    console.log("Drivers State:", drivers);

    return (
        <div className="container mt-4">

            <h2 className="mb-4">Driver Management</h2>

            <button
                className="btn btn-primary mb-3"
                onClick={() => navigate("/drivers/add")}
            >
                Add Driver
            </button>

            <table className="table table-bordered table-striped">

                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>License Number</th>
                        <th>Phone</th>
                        <th>Shift Hours</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>

                    {drivers.length > 0 ? (

                        drivers.map(driver => (

                            <tr key={driver.id}>
                                <td>{driver.id}</td>
                                <td>{driver.name}</td>
                                <td>{driver.licenseNumber}</td>
                                <td>{driver.phone}</td>
                                <td>{driver.shiftHours}</td>
                                <td>{driver.status}</td>
                                <td>
                                    <button
                                        className="btn btn-danger btn-sm"
                                        onClick={() => removeDriver(driver.id)}
                                    >
                                        Delete
                                    </button>
                                </td>
                            </tr>

                        ))

                    ) : (

                        <tr>
                            <td colSpan="6" className="text-center">
                                No Drivers Found
                            </td>
                        </tr>

                    )}

                </tbody>

            </table>

        </div>
    );
}

export default DriverPage;