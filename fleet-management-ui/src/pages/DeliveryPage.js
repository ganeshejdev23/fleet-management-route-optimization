import { useEffect, useState } from "react";
import { getDrivers } from "../api/DriverService";

function DriverPage() {

    const [drivers, setDrivers] = useState([]);

    useEffect(() => {
        loadDrivers();
    }, []);

    const loadDrivers = () => {

        getDrivers()
            .then(res => setDrivers(res.data))
            .catch(err => console.log(err));

    };

    return (

        <div className="container mt-4">

            <h2>Driver Management</h2>

            <table className="table table-bordered table-striped mt-3">

                <thead>

                    <tr>

                        <th>ID</th>
                        <th>Name</th>
                        <th>License</th>
                        <th>Phone</th>
                        <th>Status</th>

                    </tr>

                </thead>

                <tbody>

                    {drivers.map(driver => (

                        <tr key={driver.id}>

                            <td>{driver.id}</td>
                            <td>{driver.name}</td>
                            <td>{driver.licenseNumber}</td>
                            <td>{driver.phone}</td>
                            <td>{driver.status}</td>

                        </tr>

                    ))}

                </tbody>

            </table>

        </div>

    );

}

export default DriverPage;