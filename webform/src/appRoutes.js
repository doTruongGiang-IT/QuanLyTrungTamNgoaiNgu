import RegisterPage from './pages/RegisterPage/RegisterPage';
import SearchPage from './pages/SearchPage/SearchPage';

const routes = [
    {
        path: "/",
        exact: true,
        main: <RegisterPage />
    },
    {
        path: "/search",
        exact: true,
        main: <SearchPage />
    },
];

export default routes;