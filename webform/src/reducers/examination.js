import * as types from "../constants/ActionTypes";

const initialState = {};

const examination = (state = initialState, action) => {
    switch(action.type) {
        case types.GET_CURRENT_EXAMINATION:
            state = action.payload;
            localStorage.setItem("current_examination", JSON.stringify(state));
            return {...state};
        case types.GET_ALL_EXAMINATION:
            state = action.payload;
            localStorage.setItem("all_examination", JSON.stringify(state));
            return {...state};
        default:
            return {...state};
    };
};

export default examination;