import React, { useState } from "react";
import styles from "./styles.module.css";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";

const RegisterPage = () => {
  const [ requstResponse, setRequestRespose ] = useState({
    message: "",
    alertClassName: ""
  });

  const initialValues = {
    firstName: "",
    email: "",
    mobile: "",
    password: "",
  };
  const onSubmit = (values) => {
    values = {
      ...values,
      username: values.firstName,
      name: values.firstName,
      role: "USER",
    };
    axios
      .post("http://localhost:8080/api/auth/register", values)
      .then(
        (response) => {
          setRequestRespose({
            message: 'user registered successfully',
            alertClassName: "alert alert-success"
          })
        },
        (error) => {
          console.log(error);
          setRequestRespose({
            message: error.response.data.message,
            alertClassName: "alert alert-danger"
          })
        }
      )
      .catch((error) => console.log(error));
  };

  const validationSchema = Yup.object({
    firstName: Yup.string().required("first name is required"),
    email: Yup.string()
      .email("Invalid email format")
      .required("email is required"),
    mobile: Yup.string().required("mobile is required"),
    password: Yup.string()
      .required("password is required")
      .min(6, "password must be at least 6 characters"),
  });

  const formik = useFormik({
    initialValues,
    onSubmit,
    // validate,
    validationSchema,
    validateOnMount: true,
  });

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-3"></div>
        <div className="col-md-6">
          <div className={styles.wrapper}>
            <div class={ requstResponse.alertClassName } role="alert">
              { requstResponse.message }
            </div>
            <h2>Register</h2>
            <hr />
            <form onSubmit={formik.handleSubmit}>
              <div className="form-group">
                <label>First Name</label>
                <input
                  type="text"
                  className={
                    formik.errors.firstName && formik.touched.firstName
                      ? "form-control is-invalid"
                      : "form-control"
                  }
                  name="firstName"
                  value={formik.values.firstName}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.firstName && formik.touched.firstName ? (
                  <small className="text-danger">
                    {formik.errors.firstName}
                  </small>
                ) : null}
              </div>

              <div className="form-group">
                <label>Email</label>
                <input
                  type="text"
                  className={
                    formik.errors.email && formik.touched.email
                      ? "form-control is-invalid"
                      : "form-control"
                  }
                  name="email"
                  value={formik.values.email}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.email && formik.touched.email ? (
                  <small className="text-danger">{formik.errors.email}</small>
                ) : null}
              </div>

              <div className="form-group">
                <label>Mobile</label>
                <input
                  type="text"
                  className={
                    formik.errors.mobile && formik.touched.mobile
                      ? "form-control is-invalid"
                      : "form-control"
                  }
                  name="mobile"
                  value={formik.values.mobile}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.mobile && formik.touched.mobile ? (
                  <small className="text-danger">{formik.errors.mobile}</small>
                ) : null}
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className={
                    formik.errors.password && formik.touched.password
                      ? "form-control is-invalid"
                      : "form-control"
                  }
                  name="password"
                  value={formik.values.password}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.password && formik.touched.password ? (
                  <small className="text-danger">
                    {formik.errors.password}
                  </small>
                ) : null}
              </div>

              <input
                type="submit"
                value="Register"
                className="btn btn-primary btn-block"
                disabled={!formik.isValid}
              />
            </form>
            <br />
            <p className="text-center">
              Already Registered? <a href="/">Click Here</a>
            </p>
          </div>
        </div>
        <div className="col-md-3"></div>
      </div>
    </div>
  );
};
export default RegisterPage;