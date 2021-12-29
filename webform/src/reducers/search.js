import * as types from "../constants/ActionTypes";

const initialState = [];

const search = (state = initialState, action) => {
    switch(action.type) {
        case types.SEARCH_SCORE:
            state = action.payload;
            return [...state];
        case types.SEARCH_SCHEDULE:
            state = action.payload;
            return [...state];
        default:
            return [...state];
    };
};

export default search;