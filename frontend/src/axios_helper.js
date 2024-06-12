import axios from 'axios';


export const getAuthToken = () => {
    return window.localStorage.getItem('token');
};

export const setAuthHeader = (token) => {
    if (token !== null) {
        window.localStorage.setItem("token", token);
    } else {
        window.localStorage.removeItem("token");
    }
};

console.log(process.env);

axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;
axios.defaults.headers.post['Content-Type'] = 'application/json';

export const request = (method, url, data) => {
    console.log("method");
    console.log(method);
    console.log("url");
    console.log(url);
    console.log("data");
    console.log(data);

    let headers = {};
    if (getAuthToken() !== null && getAuthToken() !== "null") {
        headers = {'Authorization': `Bearer ${getAuthToken()}`};
    }

    return axios({
        method: method,
        headers: headers,
        url: url,
        data: data
    });
};
