import React, {useEffect, useState} from 'react';
import '../styles/UserProfile.css';
import {useAuth} from "./AuthProvider";
import {request} from "../axios_helper";

function UserProfile() {

    const {login, logout, isAuthenticated} = useAuth();

    const [userInfo, setUserInfo] = useState({
        firstName: '',
        lastName: '',
        email: '',
        height: '',
        weight: '',
        fat: '',
        shoulderWidth: '',
        shoulderCircumference: '',
        chestCircumference: '',
        waistCircumference: '',
        hipCircumference: '',
        calfCircumference: '',
    });

    const getUserInfo = (userId) => {
        request("GET", `/profile?id=${userId}`)
            .then((response) => {
                setUserInfo(response.data);
            })
            .catch((error) => {
                logout();
            });
    };

    const userId = localStorage.getItem('id');

    useEffect(() => {
        getUserInfo(userId);
    }, []);

    const [isEditableEmail, setIsEditableEmail] = useState(false);
    const [isEditableParams, setIsEditableParams] = useState(false);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setUserInfo({...userInfo, [name]: value});
    };

    const enableEditingEmail = () => {
        if (isEditableEmail) {
            request("POST", `/profile/email?id=${userId}&email=${userInfo.email}`)
                .then((response) => {
                })
                .catch((error) => {
                    logout();
                });
        }
        setIsEditableEmail(!isEditableEmail);
    };

    const sendEmailParameter = () => {
        request("POST", `/profile/sendParams?id=${userId}`)
            .then((response) => {
            })
            .catch((error) => {
                logout();
            });
    };


    const enableEditingParams = () => {
        if (isEditableParams) {
            request("POST", `/profile/params?id=${userId}`,
                {
                    height: userInfo.height,
                    weight: userInfo.weight,
                    fat: userInfo.fat,
                    shoulderWidth: userInfo.shoulderWidth,
                    shoulderCircumference: userInfo.shoulderCircumference,
                    chestCircumference: userInfo.chestCircumference,
                    waistCircumference: userInfo.waistCircumference,
                    hipCircumference: userInfo.hipCircumference,
                    calfCircumference: userInfo.calfCircumference
                }
            )
                .then((response) => {
                })
                .catch((error) => {
                    logout();
                });
        }
        setIsEditableParams(!isEditableParams);
    };

    return (
        <div className="user-info">
            <div className="card-info">
                <h2>Личный кабинет</h2>

                <div className="form-group">
                    <label>Имя:</label>
                    <input
                        type="text"
                        name="firstName"
                        value={userInfo.firstName}
                        className="input-field"
                        disabled={true}
                    />

                </div>

                <div className="form-group">
                    <label>Фамилия:</label>
                    <input
                        type="text"
                        name="lastName"
                        value={userInfo.lastName}
                        className="input-field"
                        disabled={true}
                    />
                </div>

                <div className="form-group">
                    <label>Логин:</label>
                    <input
                        type="text"
                        name="login"
                        value={userInfo.login}
                        className="input-field"
                        disabled={true}
                    />
                </div>
                <div className="form-group">
                    <label>Почта:</label>
                    <input
                        type="email"
                        name="email"
                        value={userInfo.email}
                        onChange={handleInputChange}
                        className="input-field"
                        disabled={!isEditableEmail}
                    />
                </div>

                <div className="buttons-row">
                    <button onClick={logout} className="button">
                        Выйти из системы
                    </button>

                    <button onClick={enableEditingEmail} className="button">
                        Сменить почту
                    </button>
                </div>

            </div>

            <div className="card-info">
                <h3>Параметры тела</h3>

                <div className="body-measurements-row">
                    <div className="form-group">
                        <label>Рост:</label>
                        <input
                            type="number"
                            name="height"
                            value={userInfo.height}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>

                    <div className="form-group">
                        <label>Вес (кг):</label>
                        <input
                            type="number"
                            name="weight"
                            value={userInfo.weight}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>

                    <div className="form-group">
                        <label>Жир (%):</label>
                        <input
                            type="number"
                            name="fat"
                            value={userInfo.fat}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>
                </div>

                <div className="body-measurements-row">

                    <div className="form-group">

                        <label>Ширина плеч:</label>
                        <input
                            type="number"
                            name="shoulderWidth"
                            value={userInfo.shoulderWidth}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>

                    <div className="form-group">
                        <label>Обхват плеча:</label>
                        <input
                            type="number"
                            name="shoulderCircumference"
                            value={userInfo.shoulderCircumference}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>

                    <div className="form-group">
                        <label>Обхват груди:</label>
                        <input
                            type="number"
                            name="chestCircumference"
                            value={userInfo.chestCircumference}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>
                </div>


                <div className="body-measurements-row">
                    <div className="form-group">
                        <label>Обхват талии:</label>
                        <input

                            type="number"
                            name="waistCircumference"
                            value={userInfo.waistCircumference}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>


                    <div className="form-group">
                        <label>Обхват бедра:</label>
                        <input
                            type="number"
                            name="hipCircumference"
                            value={userInfo.hipCircumference}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>

                    <div className="form-group">
                        <label>Обхват икр:</label>
                        <input
                            type="number"
                            name="calfCircumference"
                            value={userInfo.calfCircumference}
                            onChange={handleInputChange}
                            className="input-field"
                            disabled={!isEditableParams}
                        />
                    </div>
                </div>

                <div className="buttons-row">
                    <button onClick={enableEditingParams} className="button">
                        Редактировать параметры тела
                    </button>

                    <button onClick={sendEmailParameter} className="button">
                        Отправить показатели на почту
                    </button>
                </div>
            </div>


        </div>

    )
        ;
}

export default UserProfile;