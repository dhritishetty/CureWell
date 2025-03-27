import axios from "axios";

// creating the axios instance
const ApiClient = axios.create({
    baseURL: "http://localhost:8080/api",
    headers: {        
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json; charset=UTF-8"
    },
})

// retrive the auth token from localstorage
function getAuthToken() {
    return localStorage.getItem("token");
}

// a request interceptor to include the auth token in every request
ApiClient.interceptors.request.use(config => {
    const token = getAuthToken();
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, error => Promise.reject(error));

export default ApiClient;