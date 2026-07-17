import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Dashboard from "./components/Dashboard";

import DriverPage from "./pages/DriverPage";
import VehiclePage from "./pages/VehiclePage";
import RoutePage from "./pages/RoutePage";
import DeliveryPage from "./pages/DeliveryPage";
import AddDriver from "./pages/AddDriver";
import EditDriver from "./pages/EditDriver";

function App() {

    return (

        <BrowserRouter>

            <Navbar />

            <Routes>

                <Route path="/" element={<Dashboard />} />

                <Route path="/drivers" element={<DriverPage />} />

                <Route path="/drivers/add" element={<AddDriver/>}/>

                <Route path="/vehicles" element={<VehiclePage />} />

                <Route path="/routes" element={<RoutePage />} />

                <Route path="/tasks" element={<DeliveryPage />} />

                <Route path="/drivers/edit/:id" element={<EditDriver />} />

            </Routes>

        </BrowserRouter>

    );

}

export default App;