import Navbar from "../../components/Navbar";

const AddDoctorPage = () => {
    return (
        <>
            <Navbar />
            <div className="container mt-5">
                <h2 className="text-center mb-4 text-success">Add New Doctor</h2>
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card shadow p-4 border border-success"> 
                            <form>
                                <div className="mb-3">
                                    <label className="form-label fw-bold text-success">Doctor's Name</label>
                                    <input 
                                        type="text" 
                                        className="form-control border-success"
                                        placeholder="Enter doctor's name" 
                                        required 
                                    />
                                </div>

                                <div className="mb-3">
                                    <label className="form-label fw-bold text-success">Specializations</label>
                                    <input 
                                        type="text" 
                                        className="form-control border-success"
                                        placeholder="Enter specialization (example: Cardiology, Internal Medicine)" 
                                        required 
                                    />
                                </div>

                                <div className="mb-3">
                                    <label className="form-label fw-bold text-success">Profile Image</label>
                                    <input 
                                        type="file" 
                                        className="form-control border-success"
                                        accept="image/*" 
                                        required 
                                    />
                                </div>

                                <button 
                                    type="submit" 
                                    className="btn btn-success w-100 fw-bold"
                                    style={{ transition: "0.3s", fontSize: "1.1rem" }}
                                >
                                    Add Doctor
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default AddDoctorPage;
