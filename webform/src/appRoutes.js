import CandidatePage from './pages/CandidatePage/CandidatePage';
import RegisterPage from './pages/RegisterPage/RegisterPage';
import SearchPage from './pages/SearchPage/SearchPage';
import StatsPage from './pages/StatsPage/StatsPage';

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
    {
        path: "/candidates",
        exact: true,
        main: <CandidatePage />
    },
    {
        path: "/stats",
        exact: true,
        main: <StatsPage />
    },
];

export default routes;