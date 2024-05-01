import React, {useEffect, useState} from 'react';
import '../styles/App.css';
import {LocalizationProvider, StaticDatePicker} from '@mui/x-date-pickers';
import {AdapterDayjs} from '@mui/x-date-pickers/AdapterDayjs';
import {Box, Button} from '@mui/material';
import 'dayjs/locale/ru';
import dayjs from 'dayjs';
import {useAuth} from './AuthProvider';
import {useNavigate} from 'react-router-dom';
import {request} from '../axios_helper';

function VerticalDivider() {
    return (
        <div
            style={{
                width: '3px',
                height: '80vh',
                backgroundColor: 'grey',
                margin: '0 10px',
                zIndex: '-1',
            }}
        />
    );
}

function TimeSlots({timeSlots}) {
    const userId = localStorage.getItem('id')

    const [currentTimeSlots, setCurrentTimeSlots] = useState(timeSlots);

    const groupedByCoach = timeSlots.reduce((acc, timeslot) => {
        const coachKey = `${timeslot.coach.name} ${timeslot.coach.surname}`;
        if (!acc[coachKey]) {
            acc[coachKey] = [];
        }
        acc[coachKey].push(timeslot);
        return acc;
    }, {});

    const handleClick = (id) => {
        request("POST", `/training/enroll/${userId}/${id}`)
            .then((response) => {
                console.log(response.data);
            })
            .catch((error) => {
            });
    };
    return (
        <Box sx={{width: "100%"}}>
            {Object.entries(groupedByCoach).map(([coach, timeslots]) => {
                timeslots.sort((a, b) => {
                    const dateA = new Date(...a.trainingDateTime);
                    const dateB = new Date(...b.trainingDateTime);
                    return dateA - dateB;
                });

                return (
                    <div key={coach} style={{margin: "10px"}}>
                        <h4>{coach}</h4>
                        {timeslots.map((timeslot) => {
                            let variant = "outlined";
                            if (timeslot.user !== null) {
                                if (timeslot.user.id == localStorage.getItem('id')) {
                                    variant = "contained";
                                } else {
                                    return null;
                                }
                            }
                            const [year, month, day, hour, minute, second] = timeslot.trainingDateTime;
                            const time = `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;

                            return (
                                <Button
                                    key={timeslot.id}
                                    variant={variant}
                                    style={{margin: '4px'}}
                                    onClick={() => handleClick(timeslot.id)}
                                >
                                    {time}
                                </Button>
                            );
                        })}
                    </div>
                );
            })}
        </Box>
    );

}

const PersonalTraining = () => {
    const [selectedDate, setSelectedDate] = useState(dayjs());
    const [timeSlots, setTimeSlots] = useState([]);
    const {isAuthenticated} = useAuth();
    const navigate = useNavigate();

    useEffect(() => {
        if (!isAuthenticated) {
            navigate('/profile');
        }
        request('GET', `/training/filter?date=${selectedDate.format('YYYY-MM-DDTHH:MM:ss')}`)
            .then((response) => {
                console.log(response.data);
                setTimeSlots(response.data);
            })
            .catch((error) => {
                console.error('Error fetching timeslots data:', error);
            });
    }, []);

    const handleDateChange = (date) => {
        setSelectedDate(date);
        request('GET', `/training/filter?date=${date.format('YYYY-MM-DDTHH:MM:ss')}`)
            .then((response) => {
                console.log(response.data);
                setTimeSlots(response.data);
            })
            .catch((error) => {
                console.error('Error fetching timeslots data:', error);
            });
    };

    return isAuthenticated ? (
        <div style={{height: '70vh'}}>
            <LocalizationProvider dateAdapter={AdapterDayjs} adapterLocale="ru">
                <Box sx={{display: 'flex'}}>
                    <Box sx={{display: 'flex', flexDirection: 'column', alignItems: 'center', width: '50%'}}>
                        <Box sx={{height: '5%'}}/>
                        <h1>Выберите дату</h1>

                        <Box sx={{height: '3%'}}/>
                        <StaticDatePicker orientation="landscape" value={selectedDate} onChange={handleDateChange}/>
                    </Box>

                    <VerticalDivider/>

                    <Box sx={{display: 'flex', flexDirection: 'column', alignItems: 'center', width: '50%'}}>
                        <Box sx={{height: '5%'}}/>
                        <h1>Выберите доступный слот</h1>
                        <Box sx={{height: '3%'}}/>
                        {timeSlots && (
                            <TimeSlots timeSlots={timeSlots}/>
                            // sx={{width: '10%'}}/>
                        )}
                    </Box>
                </Box>
            </LocalizationProvider>
        </div>
    ) : (
        <></>
    );
};

export default PersonalTraining;
