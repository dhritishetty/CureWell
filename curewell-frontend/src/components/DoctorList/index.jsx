// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import Doctors from '../Doctors';

// const DoctorList = () => {
//     const [doctors, setDoctors] = useState([]);

//     const getDoctorList = async () => {
//         try {
//             const response = await axios.get("http://localhost:9002/api/doctors", {
//                 withCredentials: true,
//                 headers: {
//                     "Authorization": `Bearer ${localStorage.getItem("token")}`
//                 }
//             });
//             setDoctors(response.data);
//         } catch (error) {
//             console.error("Error fetching doctor data:", error);
//         }
//     };

//     useEffect(() => {
//         getDoctorList();
//     }, []);

//     return (
//         <div className="container">
//             <h2 className="text-center my-4 text-success">All Doctors</h2>
//             <div className="row">
//                 {doctors.length > 0 ? (
//                     doctors.map((doctor, index) => <Doctors data={doctor} key={index} />)
//                 ) : (
//                     <p className="text-center text-muted">No doctors available.</p>
//                 )}
//             </div>
//         </div>
//     );
// };

// export default DoctorList;

// import { useState, useEffect } from "react";
// import { useNavigate } from "react-router-dom";
// import { Button, Table, Container } from "react-bootstrap";
// import axios from "axios";

// const DoctorList = () => {
//   const navigate = useNavigate();
//   const [doctors, setDoctors] = useState([]);
//   const [specializations, setSpecializations] = useState([]);
//   const [doctorSpec, setDoctorSpec] = useState([]);
//   const [loading, setLoading] = useState(true);
//   const [error, setError] = useState(null);

//   const token = localStorage.getItem("token");
//   console.log("Token:", token);

//   useEffect(() => {
//     if (!token) {
//       setError("Unauthorized! Please log in first.");
//       return;
//     }

//     const fetchAllData = async () => {
//       try {
//         const [doctorRes, specRes, docSpecRes] = await Promise.all([
//           axios.get("http://localhost:8080/api/doctors", { headers: { Authorization: `Bearer ${token}` } }),
//           axios.get("http://localhost:8080/api/specialisations", { headers: { Authorization: `Bearer ${token}` } }),
//           axios.get("http://localhost:8080/api/doctor-specializations", { headers: { Authorization: `Bearer ${token}` } }),
//         ]);

//         setDoctors(doctorRes.data);
//         setSpecializations(specRes.data);
//         setDoctorSpec(docSpecRes.data);
//         setLoading(false);
//       } catch (err) {
//         setError("Failed to fetch data");
//         setLoading(false);
//       }
//     };

//     fetchAllData();
//   }, [token]);

//   if (loading) return <div className="text-center mt-4">Loading...</div>;
//   if (error) return <div className="alert alert-danger">{error}</div>;

//   const combinedDoctors = doctors.map((doctor) => {
//     const docSpec = doctorSpec.filter((ds) => ds.doctor.doctorId === doctor.doctorId);

//     const doctorSpecializations = docSpec.map((ds) => {
//       const spec = specializations.find((spec) => spec.specCode === ds.specialisation.specCode);
//       return spec ? spec.specName : "Unknown";
//     });

//     return {
//       ...doctor,
//       specializations: doctorSpecializations.length > 0 ? doctorSpecializations : ["No Specialization"],
//     };
//   });

//   return (
//     <Container className="mt-4">
//       <h2 className="text-center mb-4">Doctors List</h2>
//       <Table bordered striped hover className="text-center">
//         <thead className="table-dark">
//           <tr>
//             <th>Doctor ID</th>
//             <th>Name</th>
//             <th>Specialization</th>
//             <th>Actions</th>
//           </tr>
//         </thead>
//         <tbody>
//           {combinedDoctors.length > 0 ? (
//             combinedDoctors.map((doctor) => (
//               <tr key={doctor.doctorId}>
//                 <td>{doctor.doctorId}</td>
//                 <td>{doctor.doctorName}</td>
//                 <td>{doctor.specializations.join(", ")}</td>
//                 <td>
//                   <Button variant="primary" onClick={() => navigate(`/update-doctor/${doctor.doctorId}`)}>
//                     Edit
//                   </Button>
//                 </td>
//               </tr>
//             ))
//           ) : (
//             <tr>
//               <td colSpan="4" className="text-center">No doctors found</td>
//             </tr>
//           )}
//         </tbody>
//       </Table>
//       <div className="text-center">
//         <Button variant="success" onClick={() => navigate("/add-doctor")}>Add Doctor</Button>
//       </div>
//     </Container>
//   );
// };

// export default DoctorList;


// import { useState, useEffect } from "react";
// import { useNavigate } from "react-router-dom";
// import { Button, Table, Container } from "react-bootstrap";
// import axios from "axios";

// const DoctorList = () => {
//   const navigate = useNavigate();
//   const [doctors, setDoctors] = useState([]);
//   const [loading, setLoading] = useState(true);
//   const [error, setError] = useState(null);

//   const token = localStorage.getItem("token");

//   useEffect(() => {
//     if (!token) {
//       setError("Unauthorized! Please log in first.");
//       return;
//     }

//     const fetchDoctors = async () => {
//       try {
//         const response = await axios.get("http://localhost:8080/api/doctors", {
//           headers: { Authorization: `Bearer ${token}` },
//         });
//         setDoctors(response.data);
//         setLoading(false);
//       } catch (err) {
//         setError("Failed to fetch doctors");
//         setLoading(false);
//       }
//     };

//     fetchDoctors();
//   }, [token]);

//   if (loading) return <div className="text-center mt-4">Loading...</div>;
//   if (error) return <div className="alert alert-danger">{error}</div>;

//   return (
//     <Container className="mt-4">
//       <h2 className="text-center mb-4">Doctors List</h2>
//       <Table bordered striped hover className="text-center">
//         <thead className="table-dark">
//           <tr>
//             <th>Doctor ID</th>
//             <th>Name</th>
//             <th>Actions</th>
//           </tr>
//         </thead>
//         <tbody>
//           {doctors.length > 0 ? (
//             doctors.map((doctor) => (
//               <tr key={doctor.doctorId}>
//                 <td>{doctor.doctorId}</td>
//                 <td>{doctor.doctorName}</td>
//                 <td>
//                   <Button
//                     variant="primary"
//                     onClick={() => navigate(`/update-doctor/${doctor.doctorId}`)}
//                   >
//                     Edit Details
//                   </Button>
//                 </td>
//               </tr>
//             ))
//           ) : (
//             <tr>
//               <td colSpan="3" className="text-center">No doctors found</td>
//             </tr>
//           )}
//         </tbody>
//       </Table>
//       <div className="text-center">
//         <Button variant="success" onClick={() => navigate("/add-doctor")}>
//           Add Doctor
//         </Button>
//       </div>
//     </Container>
//   );
// };

// export default DoctorList;



import React, { useState, useEffect } from "react";
import ApiClient from "../../client/ApiClient";
import { useNavigate } from "react-router-dom";
import { Button, Table, Container } from "react-bootstrap";

const DoctorList = () => {
  const navigate = useNavigate();
  const [doctors, setDoctors] = useState([]);

  const getDoctors = () => {
    ApiClient.get("/doctors")
      .then((response) => {
        console.log(response.data);
        setDoctors(response.data);
      })
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    getDoctors();
  }, []);

  return (
    <Container className="mt-4">
      <h2 className="text-center">View Doctor</h2>
      <Table bordered striped hover className="text-center">
        <thead className="table-dark">
          <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {doctors.length > 0 ? (
            doctors.map((doctor, index) => (
              <tr key={index}>
                <td>{doctor.doctorId}</td>
                <td>{doctor.doctorName}</td>
                <td>
                  <Button
                    variant="primary"
                    onClick={() => navigate(`/update-doctor/${doctor.doctorId}`)}
                  >
                    Edit Details
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="3" className="text-center">No doctors found</td>
            </tr>
          )}
        </tbody>
      </Table>
      <div className="text-center">
        <Button variant="success" onClick={() => navigate("/add-doctor")}>
          Add Doctor
        </Button>
      </div>
    </Container>
  );
};

export default DoctorList;
