import React, { useEffect, useState } from "react";
import api from "../api/api";

function Dashboard() {

    const [drivers, setDrivers] = useState(0);
    const [vehicles, setVehicles] = useState(0);
    const [routes, setRoutes] = useState(0);
    const [tasks, setTasks] = useState(0);

    useEffect(() => {

        api.get("/drivers")
            .then(res => setDrivers(res.data.length))
            .catch(() => setDrivers(0));

        api.get("/vehicles")
            .then(res => setVehicles(res.data.length))
            .catch(() => setVehicles(0));

        api.get("/routes")
            .then(res => setRoutes(res.data.length))
            .catch(() => setRoutes(0));

        api.get("/tasks")
            .then(res => setTasks(res.data.length))
            .catch(() => setTasks(0));

    }, []);

    return (

        <div className="container mt-5">

            <h1>Fleet Management Dashboard</h1>

            <hr/>

            <div className="row">

                <div className="col-md-3">
                    <div className="card">
                        <div className="card-body">
                            <h3>Drivers</h3>
                            <h2>{drivers}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card">
                        <div className="card-body">
                            <h3>Vehicles</h3>
                            <h2>{vehicles}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card">
                        <div className="card-body">
                            <h3>Routes</h3>
                            <h2>{routes}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card">
                        <div className="card-body">
                            <h3>Tasks</h3>
                            <h2>{tasks}</h2>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    );

}

export default Dashboard;