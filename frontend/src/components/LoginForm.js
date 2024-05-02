import React, {useState} from 'react';
import {Button, Tab, Tabs, TextField, Box, Paper} from '@mui/material';
import PropTypes from "prop-types";

const LoginForm = ({onLogin, onRegister}) => {
    const [activeTab, setActiveTab] = useState(0);
    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        login: "",
        password: "",
    });

    const onChangeHandler = (event) => {
        const {name, value} = event.target;
        setFormData((prevFormData) => ({
            ...prevFormData,
            [name]: value,
        }));
    };

    const onSubmitLogin = (e) => {
        e.preventDefault();
        onLogin(formData.login, formData.password);
    };

    const onSubmitRegister = (e) => {
        e.preventDefault();
        onRegister(formData.firstName, formData.lastName, formData.login, formData.password);
    };

    const handleTabChange = (event, newValue) => {
        setActiveTab(newValue);
    };

    return (
        <Box display="flex" justifyContent="center" mt={"3%"}>
            <Paper elevation={3} style={{padding: '20px', width: '400px'}}>
                <Tabs value={activeTab} onChange={handleTabChange} centered>
                    <Tab label="Авторизация"/>
                    <Tab label="Регистрация"/>
                </Tabs>

                <div hidden={activeTab !== 0}>
                    <form onSubmit={onSubmitLogin}>
                        <Box mt={2}>
                            <TextField
                                label="Логин"
                                name="login"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.login}
                            />
                        </Box>
                        <Box mt={2}>
                            <TextField
                                label="Пароль"
                                name="password"
                                type="password"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.password}
                            />
                        </Box>
                        <Box mt={2}>
                            <Button type="submit" variant="contained" color="primary" fullWidth>
                                Войти
                            </Button>
                        </Box>
                    </form>
                </div>

                <div hidden={activeTab !== 1}>
                    <form onSubmit={onSubmitRegister}>
                        <Box mt={0}>
                            <TextField
                                label="Имя"
                                name="firstName"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.firstName}
                            />
                        </Box>
                        <Box mt={0}>
                            <TextField
                                label="Фамилия"
                                name="lastName"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.lastName}
                            />
                        </Box>
                        <Box mt={0}>
                            <TextField
                                label="Логин"
                                name="login"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.login}
                            />
                        </Box>
                        <Box mt={0}>
                            <TextField
                                label="Пароль"
                                name="password"
                                type="password"
                                fullWidth
                                margin="normal"
                                variant="outlined"
                                onChange={onChangeHandler}
                                value={formData.password}
                            />
                        </Box>
                        <Box mt={2}>
                            <Button type="submit" variant="contained" color="primary" fullWidth>
                                Заригистрироваться
                            </Button>
                        </Box>
                    </form>
                </div>
            </Paper>
        </Box>
    );
};

LoginForm.propTypes = {
    onLogin: PropTypes.func.isRequired,
    onRegister: PropTypes.func.isRequired,
};

export default LoginForm;