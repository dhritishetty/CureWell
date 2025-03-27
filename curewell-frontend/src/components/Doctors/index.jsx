import { Link } from 'react-router-dom';

const Doctors = (props) => {
    const { doctorName, image } = props.data;
    const defaultImage = "https://via.placeholder.com/150"; 

    return (
        <div className="col-sm-3 mb-4"> 
            <div className="card shadow">
                <img 
                    src={image || defaultImage} 
                    alt="Doctor" 
                    className="card-img-top"
                    style={{ height: "200px", objectFit: "cover" }} 
                /> 
                <div className="card-body text-center">
                    <h5 className="card-title">{doctorName}</h5>
                    <h6>
                        <span className="badge bg-secondary">Specialization</span>
                    </h6>
                    <p className="card-text">Short bio or specialization info</p>
                    <Link to={`/doctors/${doctorName}`} className="btn btn-success w-100">
                        Details
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default Doctors;
