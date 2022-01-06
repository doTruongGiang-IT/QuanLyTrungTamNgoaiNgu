import { combineReducers } from "redux";
import search from "./search";
import register from "./register";
import examination from "./examination";
import room from "./room";
import candidate from "./candidate";

const appReducers = combineReducers({
    search,
    register,
    examination,
    room,
    candidate
});

export default appReducers;