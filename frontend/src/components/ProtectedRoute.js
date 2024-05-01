import { Route, Navigate } from 'react-router-dom';
import { useAuth } from './AuthProvider';

const ProtectedRoute = ({ element, ...rest }) => {
    const { isAuthenticated } = useAuth();

    return (
        <Route
            {...rest}
            // element={isAuthenticated ? element : <Navigate to="/profile" />}
        />
    );
};

export default ProtectedRoute;