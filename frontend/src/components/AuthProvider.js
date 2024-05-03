import React, {createContext, useContext, useEffect, useState} from 'react';
import {useNavigate} from "react-router-dom";

const AuthContext = createContext();

export const useAuth = () => {
    return useContext(AuthContext);
};

export const AuthProvider = ({children}) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [authHeader, setAuthHeader] = useState(null);

    const login = (token, userId) => {
        console.log("LOOGIN")
        localStorage.setItem("token", token);
        localStorage.setItem("id", userId);
        setAuthHeader(token);
        setIsAuthenticated(true);
    };

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem("id");
        setAuthHeader(null);
        setIsAuthenticated(false);
    };


    useEffect(() => {
        const token = localStorage.getItem('token');

        if (!token) {
            setAuthHeader(null);
            setIsAuthenticated(false);
            return;
        }

        setAuthHeader(token);
        setIsAuthenticated(true);
    }, [login, logout]);


    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout, authHeader}}>
            {children}
        </AuthContext.Provider>
    );
};