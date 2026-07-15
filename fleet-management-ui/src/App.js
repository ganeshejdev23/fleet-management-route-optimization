import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Dashboard from "./components/Dashboard";

import DriverPage from "./pages/DriverPage";
import VehiclePage from "./pages/VehiclePage";
import RoutePage from "./pages/RoutePage";
import DeliveryPage from "./pages/DeliveryPage";

function App() {

    return (

        <BrowserRouter>

            <Navbar />

            <Routes>

                <Route path="/" element={<Dashboard />} />

                <Route path="/drivers" element={<DriverPage />} />

                <Route path="/vehicles" element={<VehiclePage />} />

                <Route path="/routes" element={<RoutePage />} />

                <Route path="/tasks" element={<DeliveryPage />} />

            </Routes>

        </BrowserRouter>

    );

}

export default App;