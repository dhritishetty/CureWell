import Navbar from "../../components/Navbar";

const SpecializationPage = () => {
    // Sample Data (Replace with actual data from API)
    const specializations = [
        { code: "CARD", name: "Cardiology" },
        { code: "ORTH", name: "Orthopedics" },
        { code: "DERM", name: "Dermatology" },
        { code: "NEUR", name: "Neurology" },
    ];

    return (
        <>
            <Navbar />
            <div className="container mt-5">
                <h2 className="text-center mb-4">Specializations</h2>
                <div className="table-responsive">
                    <table className="table table-bordered table-striped">
                        <thead className="table-success">
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {specializations.map((specialization, index) => (
                                <tr key={index}>
                                    <td>{specialization.code}</td>
                                    <td>{specialization.name}</td>
                                    <td>
                                        <button className="btn btn-success btn-sm">
                                            View Doctors
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    );
}

export default SpecializationPage;
