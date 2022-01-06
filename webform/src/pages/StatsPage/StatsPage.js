import React, {useEffect, useState} from 'react';
import '../CandidatePage/CandidatePage.css';
import { Select } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../../actions/index";

const { Option } = Select;

const StatsPage = () => {
    const dispatch = useDispatch();
    const [examination, setExamination] = useState(0);
    const examinations = useSelector(state => state.examination);
    const rooms = useSelector(state => state.room);
    let allExamination = JSON.parse(localStorage.getItem("all_examination"));
    let allRoomOfExaminationAndLevel = JSON.parse(localStorage.getItem("all_room_of_examination_and_level"));

    useEffect(() => {
        dispatch(actions.getAllExaminationRequest());
    }, [dispatch]);

    const handleChangeExamination = (value) => {
        setExamination(value);
    };

    const handleChangeLevel = (value) => {
        dispatch(actions.getAllRoomOfExaminationAndLevelRequest(examination, value));
    };

    return (
        <div className='stats candidates'>
            <div className='stats_select candidates_select'>
                <Select placeholder="Chọn kỳ thi" style={{ width: 300 }} onChange={handleChangeExamination}>
                    {
                        allExamination.data.length > 0 ?
                        allExamination.data.map((examination, index) => {
                            return <Option key={index} value={examination.id}>{examination.name}</Option>
                        }) : ""
                    }
                </Select>
                <Select placeholder="Chọn trình độ" style={{ width: 150 }} onChange={handleChangeLevel} >
                    <Option value="A2">A2</Option>
                    <Option value="B1">B1</Option>
                </Select>
                <span style={{marginLeft: 10, color: "gray"}}><strong>Số lượng kỳ thi:</strong> <span>{allExamination.data.length}</span></span>
            </div>
            <div className='stats_results candidates_results'>
                <h2><strong>Số lượng phòng thi:</strong> <span>{allRoomOfExaminationAndLevel.data.length}</span></h2>
                <h2><strong>Số lượng thí sinh:</strong> <span>132</span></h2>
            </div>
        </div>
    )
}

export default StatsPage;
