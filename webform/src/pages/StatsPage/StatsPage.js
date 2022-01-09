import React, {useEffect, useState} from 'react';
import '../CandidatePage/CandidatePage.css';
import { Select } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from "../../actions/index";
import TableComponent from '../../components/Table';

const { Option } = Select;

const StatsPage = () => {
    const dispatch = useDispatch();
    const [examination, setExamination] = useState(0);
    const examinations = useSelector(state => state.examination);
    const rooms = useSelector(state => state.room);
    // const candidates = useSelector(state => state.candidate);
    let allExamination = JSON.parse(localStorage.getItem("all_examination"));
    let candidatesOfRoom = JSON.parse(localStorage.getItem("all_candidate_of_room_of_examination"));
    let numberOfCandidate = JSON.parse(localStorage.getItem("number_of_candidate"));

    useEffect(() => {
        dispatch(actions.getAllExaminationRequest());
    }, [dispatch]);

    const handleChangeExamination = (value) => {
        setExamination(value);
    };

    const handleChangeLevel = async (value) => {
        await dispatch(actions.getAllRoomOfExaminationAndLevelRequest(examination, value));
        // statsCandidate(value);
    };

    // const statsCandidate = async (level) => {
    //     for(let i = 0; i < allRoomOfExaminationAndLevel.data.length; i++ ) {
    //         await dispatch(actions.getAllCandidateOfRoomOfExaminationRequest(Number.parseInt(allRoomOfExaminationAndLevel.data[i].id)));
    //         await dispatch(actions.numberOfCandidate({examination, level}));
    //     };
    // };

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
                <span style={{marginLeft: 10, color: "gray"}}><strong>Số lượng kỳ thi:</strong> <span>{examinations.data?.length}</span></span>
            </div>
            <div className='candidates_results'>
                <TableComponent tab="stats" />
                {/* <h2><strong>Số lượng phòng thi:</strong> <span>{rooms.data?.length}</span></h2>
                <h2><strong>Số lượng thí sinh:</strong> <span>{examination === Number.parseInt(numberOfCandidate?.examination) ? numberOfCandidate?.numberOfCandidate : ""}</span></h2> */}
            </div>
        </div>
    )
}

export default StatsPage;
