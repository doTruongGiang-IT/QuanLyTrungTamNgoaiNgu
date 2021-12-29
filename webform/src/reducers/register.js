import * as types from "../constants/ActionTypes";

const initialState = {};

const register = (state = initialState, action) => {
    switch(action.type) {
        case types.REGISTER:
            state.push(action.payload);
            return {...state};
        default:
            return {...state};
    };
};

export default register;