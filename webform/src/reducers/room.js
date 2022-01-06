import * as types from "../constants/ActionTypes";

const initialState = {};

const room = (state = initialState, action) => {
    switch(action.type) {
        case types.GET_ALL_ROOM_OF_EXAMINATION:
            state = action.payload;
            localStorage.setItem("all_room_of_examination", JSON.stringify(state));
            return {...state};
        case types.GET_ALL_ROOM_OF_EXAMINATION_AND_LEVEL:
            state = action.payload;
            localStorage.setItem("all_room_of_examination_and_level", JSON.stringify(state));
            return {...state};
        default:
            return {...state};
    };
};

export default room;