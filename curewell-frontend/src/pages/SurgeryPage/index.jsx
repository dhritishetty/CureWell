import Navbar from "../../components/Navbar";

const SurgeryPage = () => {

    const surgeries = [
        { id: 1, doctorId: 1, date: "2025-26-24", startTime: "10:00 AM", endTime: "12:00 PM", category: "CARD" },
        { id: 2, doctorId: 2, date: "2025-26-24", startTime: "11:30 AM", endTime: "01:30 PM", category: "NEUR" },
        { id: 3, doctorId: 3, date: "2025-26-24", startTime: "02:00 PM", endTime: "04:00 PM", category: "ORTH" }
    ];

    return (
        <>
            <Navbar />
            <div className="container mt-5">
                <h2 className="text-center mb-4">Scheduled Surgeries</h2>
                <div className="table-responsive">
                    <table className="table table-bordered table-striped">
                        <thead className="table-success">
                            <tr>
                                <th>Surgery ID</th>
                                <th>Doctor ID</th>
                                <th>Date</th>
                                <th>Start Time</th>
                                <th>End Time</th>
                                <th>Category</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {surgeries.map((surgery, index) => (
                                <tr key={index}>
                                    <td>{surgery.id}</td>
                                    <td>{surgery.doctorId}</td>
                                    <td>{surgery.date}</td>
                                    <td>{surgery.startTime}</td>
                                    <td>{surgery.endTime}</td>
                                    <td>{surgery.category}</td>
                                    <td>
                                        <button className="btn btn-success btn-sm">
                                            Edit Surgery Time
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

export default SurgeryPage;
