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

export const searchResult = (response) => {
    return {
        type: types.SEARCH_RESULT,
        payload: response
    };
};

export const searchResultRequest = (name, phone) => {
    return (dispatch) => {
        return callApi(`CandidateRoom/information?name=${name}&phone=${phone}`, "GET", null)
                    .then(res => {
                        dispatch(searchResult(res.data));
                    })
                    .catch(error => {
                        dispatch(searchResult({"message": error.message}));
                    });
    }
};

export const getCurrentExamination = (examination) => {
    return {
        type: types.GET_CURRENT_EXAMINATION,
        payload: examination
    };
};

export const getCurrentExaminationRequest = () => {
    return (dispatch) => {
        return callApi("Examination/current", "GET", null)
                    .then(res => {
                        dispatch(getCurrentExamination(res.data));
                    })
                    .catch(error => {
                        console.log("get current examination error");
                    });
    }
};

export const getAllExamination = (examinations) => {
    return {
        type: types.GET_ALL_EXAMINATION,
        payload: examinations
    };
};

export const getAllExaminationRequest = () => {
    return (dispatch) => {
        return callApi("Examination", "GET", null)
                    .then(res => {
                        dispatch(getAllExamination(res.data));
                    })
                    .catch(error => {
                        console.log("get all examination error");
                    });
    }
};

export const getAllRoomOfExamination = (rooms) => {
    return {
        type: types.GET_ALL_ROOM_OF_EXAMINATION,
        payload: rooms
    };
};

export const getAllRoomOfExaminationRequest = (id) => {
    return (dispatch) => {
        return callApi(`Room/Examination/${id}`, "GET", null)
                    .then(res => {
                        dispatch(getAllRoomOfExamination(res.data));
                    })
                    .catch(error => {
                        console.log("get all room of examination error");
                    });
    }
};

export const getAllCandidateOfRoomOfExamination = (candidates) => {
    return {
        type: types.GET_ALL_CANDIDATE_OF_ROOM_OF_EXAMINATION,
        payload: candidates
    };
};

export const getAllCandidateOfRoomOfExaminationRequest = (id) => {
    return (dispatch) => {
        return callApi(`Candidate/Room/${id}`, "GET", null)
                    .then(res => {
                        dispatch(getAllCandidateOfRoomOfExamination(res.data));
                    })
                    .catch(error => {
                        console.log("get all candidate of room of examination error");
                    });
    }
};

export const getDetailOfCandidate = (candidate) => {
    return {
        type: types.GET_DETAIL_OF_CANDIDATE,
        payload: candidate
    };
};

export const getDetailOfCandidateRequest = (id) => {
    return (dispatch) => {
        return callApi(`Candidate/${id}`, "GET", null)
                    .then(res => {
                        dispatch(getDetailOfCandidate(res.data));
                    })
                    .catch(error => {
                        console.log("get detail of candidate error");
                    });
    }
};

export const getAllRoomOfExaminationAndLevel = (candidates) => {
    return {
        type: types.GET_ALL_ROOM_OF_EXAMINATION_AND_LEVEL,
        payload: candidates
    };
};

export const getAllRoomOfExaminationAndLevelRequest = (id, level) => {
    return (dispatch) => {
        return callApi(`Room/Examination/Level/${id}/${level}`, "GET", null)
                    .then(res => {
                        dispatch(getAllRoomOfExaminationAndLevel(res.data));
                    })
                    .catch(error => {
                        console.log("get all room of examination and level error");
                    });
    }
};

export const numberOfCandidate = (data) => {
    return {
        type: types.GET_NUMBER_OF_CANDIDATES,
        payload: data
    };
};