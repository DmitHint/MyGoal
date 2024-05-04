import './styles/App.css';
import {BrowserRouter as Router, Route, Routes, NavLink} from 'react-router-dom';
import Header from "./components/Header";
import PersonalTraining from "./components/PersonalTraining";
import Footer from "./components/Footer";
import UserContent from "./components/UserContent";
import VisitHistory from "./components/VisitHistory";
import CoachesPage from "./components/CoachesPage";


function App() {


    return (
        <Router>
            <div>
                <Header/>
                <main>
                    <Routes>
                        <Route path="/" element={<UserContent/>}/>
                        <Route path="/profile" element={<UserContent/>}/>
                        <Route path="/training" element={<PersonalTraining/>}/>
                        <Route path="/history" element={<VisitHistory/>}/>
                        <Route path="/coach" element={<CoachesPage/>}/>
                    </Routes>
                </main>
                <Footer/>
            </div>
        </Router>
    );
}

export default App;
