import React, {useEffect, useState} from 'react';
import {request} from "../axios_helper";
import {Box} from "@mui/material";
import dayjs from "dayjs";
import {useAuth} from "./AuthProvider";
import {useNavigate} from "react-router-dom";

const VisitHistory = () => {
    const [trainings, setTrainings] = useState([]);
    const {isAuthenticated} = useAuth();
    const userId = localStorage.getItem("id");

    const navigate = useNavigate();

    useEffect(() => {
        if (!userId) {
            navigate('/profile');
        }
        request('GET', `/training/filter?userId=${userId}`)
            .then((response) => {
                setTrainings(response.data);
            })
            .catch((error) => {
                console.error('Error fetching training history:', error);
            });
    }, [isAuthenticated, navigate, userId]);

    return isAuthenticated ? (
        <div style={{
            minHeight: '70vh',
            display: "flex",
            alignItems: "center",
            flexDirection: "column"
        }}>
            <h2 style={{margin: "1%"}}>История тренировок</h2>
            <Box sx={{width: '100%'}}>
                {trainings.map((training) => {

                    const trainingDateTime = dayjs(new Date(...training.trainingDateTime));
                    const formattedDate = trainingDateTime.format('DD.MM.YYYY');
                    const formattedTime = trainingDateTime.format('HH:mm');

                    let bgColor = '';
                    if (training.status === 'finished') {
                        bgColor = '#54b35a';
                    } else if (training.status === 'ongoing') {
                        bgColor = 'darkslategrey';
                    } else if (training.status === 'not started') {
                        bgColor = '#3288ad';
                    }

                    return (
                        <Box
                            key={training.id}
                            sx={{
                                backgroundColor: bgColor,
                                padding: '10px',
                                marginBottom: '10px',
                                marginLeft: '10%',
                                marginRight: '10%',
                                borderRadius: '5px',
                                color: 'white',
                                display: 'flex',
                                justifyContent: 'space-between',
                            }}
                        >
                            <div><strong>Дата:</strong> {formattedDate}</div>
                            <div><strong>Время:</strong> {formattedTime}</div>
                            <div><strong>Имя тренера:</strong> {training.coach.name} {training.coach.surname}</div>
                            <div>
                                <strong>Статус:</strong> {training.status === 'finished' ? 'Завершена' : training.status === 'ongoing' ? 'Идет прямо сейчас' : 'Не начата'}
                            </div>
                        </Box>
                    );
                })}
            </Box>
        </div>
    ) : (
        <></>
    );
};

export default VisitHistory;
