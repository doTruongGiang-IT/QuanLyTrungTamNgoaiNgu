import { combineReducers } from "redux";
import search from "./search";
import register from "./register";

const appReducers = combineReducers({
    search,
    register
});

export default appReducers;