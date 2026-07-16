import api from "./api";

export const getDrivers = () => api.get("/drivers");

export const addDriver = (driver) => api.post("/drivers", driver);

export const deleteDriver = (id) => api.delete(`/drivers/${id}`);