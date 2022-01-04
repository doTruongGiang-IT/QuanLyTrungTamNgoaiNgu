import React from 'react';
import './CandidatePage.css';
import TableComponent from '../../components/Table';
import { Select } from 'antd';

const { Option } = Select;

const CandidatePage = () => {
    const handleChangeExamination = (value) => {
        console.log(`Examination: ${value}`);
    };

    const handleChangeRoom = (value) => {
        console.log(`Room: ${value}`);
    };

    return (
        <div className='candidates'>
            <div className='candidates_select'>
                <Select placeholder="Select examination" style={{ width: 150 }} onChange={handleChangeExamination}>
                    <Option value="Noel">Noel</Option>
                    <Option value="New Year">New Year</Option>
                    <Option value="Summer">Summer</Option>
                </Select>
                <Select placeholder="Select room" style={{ width: 150 }} onChange={handleChangeRoom} >
                    <Option value="A2001">A2001</Option>
                    <Option value="B1002">B1002</Option>
                    <Option value="A2003">A2003</Option>
                </Select>
            </div>
            <div className='candidates_results'>
                <TableComponent tab="candidates" />
            </div>
        </div>
    )
}

export default CandidatePage;
