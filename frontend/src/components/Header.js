import '../styles/App.css';
import '../styles/Header.css';
import {NavLink} from 'react-router-dom';


const Header = () => {
    return (
        <header>
            <div className="brand">
                <img
                    src={require('../assets/logo.png')}
                    width={100}
                    height={80}
                    style={{filter: 'invert(1)'}}
                />
                MyGoal - Fitness
            </div>
            <nav className="nav">
                <NavLink to="/profile">Личный кабинет</NavLink>
                <NavLink to="/training">Запись на тренировку</NavLink>
                <NavLink to="/history">История посещений</NavLink>
                <NavLink to="/coach">Тренеры</NavLink>
            </nav>
        </header>
    );
};

export default Header;