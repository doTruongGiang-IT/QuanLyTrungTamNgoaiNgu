import React, {useState, useEffect} from 'react';
import './CandidatePage.css';
import TableComponent from '../../components/Table';
import { useDispatch, useSelector } from 'react-redux';
import { Select } from 'antd';
import * as actions from "../../actions/index";

const { Option } = Select;

const CandidatePage = () => {
    const [examination, setExamination] = useState(0);
    const [room, setRoom] = useState(0);
    const dispatch = useDispatch();
    const examinations = useSelector(state => state.examination);
    const rooms = useSelector(state => state.room);
    let allExamination = JSON.parse(localStorage.getItem("all_examination"));
    let allRoomOfExamination = JSON.parse(localStorage.getItem("all_room_of_examination"));

    const handleChangeExamination = (value) => {
        setExamination(value);
        dispatch(actions.getAllRoomOfExaminationRequest(value));
    };

    const handleChangeRoom = (value) => {
        setRoom(value);
        dispatch(actions.getAllCandidateOfRoomOfExaminationRequest(value));
    };

    useEffect(() => {
        dispatch(actions.getAllExaminationRequest());
    }, [dispatch]);

    return (
        <div className='candidates'>
            <div className='candidates_select'>
                <Select placeholder="Chọn kỳ thi" style={{ width: 300 }} onChange={handleChangeExamination}>
                    {
                        examinations.data ?
                        examinations.data.map((examination, index) => {
                            return <Option key={index} value={examination.id}>{examination.name}</Option>
                        }) : ""
                    }
                </Select>
                <Select placeholder="Chọn phòng thi" style={{ width: 150 }} onChange={handleChangeRoom} >
                    {
                        rooms.data ?
                        rooms.data.map((room, index) => {
                            return <Option key={index} value={room.id}>{room.name}</Option>
                        }) : ""
                    }
                </Select>
            </div>
            <div className='candidates_results'>
                <TableComponent tab="candidates" examination={examination} room={room} />
            </div>
        </div>
    )
}

export default CandidatePage;
