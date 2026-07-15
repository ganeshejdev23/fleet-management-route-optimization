import { Link } from "react-router-dom";

function Navbar() {

    return (

        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">

            <div className="container">

                <Link className="navbar-brand" to="/">
                    Fleet Management
                </Link>

                <div className="navbar-nav">

                    <Link className="nav-link" to="/">
                        Dashboard
                    </Link>

                    <Link className="nav-link" to="/drivers">
                        Drivers
                    </Link>

                    <Link className="nav-link" to="/vehicles">
                        Vehicles
                    </Link>

                    <Link className="nav-link" to="/routes">
                        Routes
                    </Link>

                    <Link className="nav-link" to="/tasks">
                        Tasks
                    </Link>

                </div>

            </div>

        </nav>

    );

}

export default Navbar;