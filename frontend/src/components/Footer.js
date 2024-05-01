import React from 'react';
import '../styles/Footer.css';
import { NavLink } from 'react-router-dom';

const Footer = () => {
    return (
        <footer className="footer">
            <div className="footer-section">
                <div className="footer-brand">
                    <img
                        src={require('../assets/logo.png')}
                        alt="MyGoal Logo"
                        className="logo"
                    />
                    <span>MyGoal - Fitness</span>
                </div>
                <nav className="footer-nav">
                    <NavLink to="/privacy-policy">Политика конфиденциальности</NavLink>
                    <NavLink to="/terms-of-service">Условия предоставления услуг</NavLink>
                    <NavLink to="/contact">Контакты</NavLink>
                </nav>
            </div>
            <div className="footer-section">
                <span>&copy; {new Date().getFullYear()} MyGoal - Fitness. Все права защищены.</span>
            </div>
        </footer>
    );
};

export default Footer;
