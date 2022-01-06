import * as types from "../constants/ActionTypes";

const initialState = {};

const search = (state = initialState, action) => {
    switch(action.type) {
        case types.SEARCH_RESULT:
            state = action.payload;
            if(state.message === undefined) {
                localStorage.setItem("search_result", JSON.stringify(state));
            };
            return {...state};
        default:
            return {...state};
    };
};

export default search;