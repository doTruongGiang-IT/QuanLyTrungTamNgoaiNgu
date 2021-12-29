import * as types from "../constants/ActionTypes";
import callApi from "../utils/apiCaller";

export const register = (response) => {
    return {
        type: types.REGISTER,
        payload: response
    };
};

export const registerRequest = (registerForm) => {
    return (dispatch) => {
        return callApi("candidates", "POST", registerForm)
                    .then(res => {
                        dispatch(register(res.data));
                    })
                    .catch(error => {
                        dispatch(register(error));
                    });
    }
};

export const searchScore = (response) => {
    return {
        type: types.SEARCH_SCORE,
        payload: response
    };
};

export const searchScoreRequest = (id) => {
    return (dispatch) => {
        return callApi(`stats/score/${id}`, "GET", null)
                    .then(res => {
                        dispatch(register(res.data));
                    })
                    .catch(error => {
                        dispatch(register(error));
                    });
    }
};

export const searchSchedule = (response) => {
    return {
        type: types.SEARCH_SCHEDULE,
        payload: response
    };
};

export const searchScheduleRequest = (id) => {
    return (dispatch) => {
        return callApi(`stats/schedule/${id}`, "GET", null)
                    .then(res => {
                        dispatch(register(res.data));
                    })
                    .catch(error => {
                        dispatch(register(error));
                    });
    }
};