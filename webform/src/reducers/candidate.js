import * as types from "../constants/ActionTypes";

const initialState = {};

const candidate = (state = initialState, action) => {
    switch(action.type) {
        case types.GET_ALL_CANDIDATE_OF_ROOM_OF_EXAMINATION:
            state = action.payload;
            localStorage.setItem("all_candidate_of_room_of_examination", JSON.stringify(state));
            return {...state};
        default:
            return {...state};
    };
};

export default candidate;