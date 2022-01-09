import * as types from "../constants/ActionTypes";

const initialState = {
    allCandidate: {},
    candidate: {},
};
let numberOfCandidate = 0;

const candidate = (state = initialState, action) => {
    switch(action.type) {
        case types.GET_ALL_CANDIDATE_OF_ROOM_OF_EXAMINATION:
            state.allCandidate = action.payload;
            localStorage.setItem("all_candidate_of_room_of_examination", JSON.stringify(state));
            return {...state};
        case types.GET_DETAIL_OF_CANDIDATE:
            state.candidate = action.payload;
            return {...state};
        case types.GET_NUMBER_OF_CANDIDATES:
            let candidateObj = localStorage.getItem("number_of_candidate") !== undefined ? JSON.parse(localStorage.getItem("number_of_candidate")) : null;
            let candidatesOfRoom = JSON.parse(localStorage.getItem("all_candidate_of_room_of_examination"));
            if(candidateObj !== null) {
                if(candidateObj.level !== action.payload.level) {
                    numberOfCandidate = 0;
                    numberOfCandidate+=candidatesOfRoom.allCandidate.data.length;
                    localStorage.setItem("number_of_candidate", JSON.stringify({examination: action.payload.examination, level: action.payload.level, numberOfCandidate}));
                }else {
                    numberOfCandidate+=candidatesOfRoom.allCandidate.data.length;
                    localStorage.setItem("number_of_candidate", JSON.stringify({examination: action.payload.examination, level: action.payload.level, numberOfCandidate}));
                };
            }else {
                numberOfCandidate+=candidatesOfRoom.allCandidate.data.length;
                localStorage.setItem("number_of_candidate", JSON.stringify({examination: action.payload.examination, level: action.payload.level, numberOfCandidate}));
            };
            return {...state};
        default:
            return {...state};
    };
};

export default candidate;