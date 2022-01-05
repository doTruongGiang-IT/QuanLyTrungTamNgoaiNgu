import React, {useState} from 'react';
import './CandidatePage.css';
import TableComponent from '../../components/Table';
import { Select } from 'antd';

const { Option } = Select;

const CandidatePage = () => {
    const [examination, setExamination] = useState(0);
    const [room, setRoom] = useState(0);

    const handleChangeExamination = (value) => {
        console.log(`Examination: ${value}`);
        setExamination(value);
    };

    const handleChangeRoom = (value) => {
        console.log(`Room: ${value}`);
        setRoom(value);
    };

    return (
        <div className='candidates'>
            <div className='candidates_select'>
                <Select placeholder="Chọn kỳ thi" style={{ width: 150 }} onChange={handleChangeExamination}>
                    <Option value={1}>Noel</Option>
                    <Option value={2}>New Year</Option>
                    <Option value={3}>Summer</Option>
                </Select>
                <Select placeholder="Chọn phòng thi" style={{ width: 150 }} onChange={handleChangeRoom} >
                    <Option value={1}>A2001</Option>
                    <Option value={2}>B1002</Option>
                    <Option value={3}>A2003</Option>
                </Select>
            </div>
            <div className='candidates_results'>
                <TableComponent tab="candidates" examination={examination} room={room} />
            </div>
        </div>
    )
}

export default CandidatePage;
