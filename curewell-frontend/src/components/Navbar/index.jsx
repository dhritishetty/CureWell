import { Link, useNavigate } from "react-router-dom";
import React, { useState, useEffect } from "react";

const Navbar = () => {
    const navigate = useNavigate();
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        let token = localStorage.getItem("token");
        if (!token) {
            setIsLoggedIn(false);
        } else {
            setIsLoggedIn(true);
        }
    }, [isLoggedIn]);

    const onLogoutHandler = () => {
        localStorage.clear();
        setIsLoggedIn(false);
        navigate("/");
    };
    return (
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <Link class="navbar-brand" to="/">CureWell</Link>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
  
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav ms-auto"> 
                        {/* <li className="nav-item">
                            <Link className="nav-link text-white px-3 py-1 bg-success rounded-pill mx-2" to="/">Home</Link>
                        </li> */}
                        <li className="nav-item">
                            <Link class="nav-link" to="/doctors">View Doctors</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/specializations">View Specializations</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/surgery">View Today's Surgery</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/add/doctor">Add Doctor</Link>
                        </li>
                    </ul>
                    <div className="form-inline my-2 my-lg-0">
                    {!isLoggedIn ? (
                        <Link className="btn btn-primary" to={"/login"}>
                            Login
                        </Link>
                    ) : (
                        <button className="btn btn-danger" onClick={onLogoutHandler}>
                            Logout
                        </button>
                    )}

                </div>
                </div>
            {/* </div> */}
        </nav>
    );
}

export default Navbar;
