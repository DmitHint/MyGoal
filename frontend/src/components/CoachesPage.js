import React, {useEffect, useState} from 'react';
import '../styles/CoachesPage.css';
import {request} from "../axios_helper";
import {useAuth} from "./AuthProvider";
import {useNavigate} from "react-router-dom"; // Импортируем стили

function CoachCard({id, name, surname, rating}) {
    return (
        <div className="coach-card">
            <img src={require(`../assets/coaches/coach${id}.png`)} alt={`${name} ${surname}`}
                 className="coach-photo"/>
            <div className="coach-info">
                <h3 className="coach-name">{name} {surname}</h3>
                <p className="coach-rating">Рейтинг: {rating}</p>
            </div>
        </div>
    );
}

function CoachesPage() {

    const [trainers, setTrainers] = useState([]);

    const {isAuthenticated, login, logout} = useAuth();
    const userId = localStorage.getItem("id");

    const navigate = useNavigate();

    const getCoachesInfo = () => {
        request("GET", `/coach/all`)
            .then((response) => {
                setTrainers(response.data);
            })
            .catch((error) => {
                console.error('Error fetching coaches data:', error);
            });
    };

    useEffect(() => {
        if (!userId) {
            navigate('/profile');
        }
        getCoachesInfo();
    }, []);

    return (
        isAuthenticated ? (
            <div style={{height: '70vh'}}>
                <div className="coach-page">
                    {trainers.map((coach, index) => (
                        <CoachCard
                            key={index}
                            id={coach.id}
                            name={coach.name}
                            surname={coach.surname}
                            rating={coach.rating}
                        />
                    ))}
                </div>
            </div>
        ) : (
            <></>
        )
    );
}

export default CoachesPage;