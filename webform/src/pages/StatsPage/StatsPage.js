import React from 'react';
import '../CandidatePage/CandidatePage.css';
import { Select } from 'antd';

const { Option } = Select;

const StatsPage = () => {
    const handleChangeExamination = (value) => {
        console.log(`Examination: ${value}`);
    };

    const handleChangeLevel = (value) => {
        console.log(`Level: ${value}`);
    };

    return (
        <div className='stats candidates'>
            <div className='stats_select candidates_select'>
                <Select placeholder="Select examination" style={{ width: 150 }} onChange={handleChangeExamination}>
                    <Option value="Noel">Noel</Option>
                    <Option value="New Year">New Year</Option>
                    <Option value="Summer">Summer</Option>
                </Select>
                <Select placeholder="Select level" style={{ width: 150 }} onChange={handleChangeLevel} >
                    <Option value="A2">A2</Option>
                    <Option value="B1">B1</Option>
                </Select>
            </div>
            <div className='stats_results candidates_results'>
                <h2><strong>Rooms:</strong> <span>32</span></h2>
                <h2><strong>Candidates:</strong> <span>132</span></h2>
            </div>
        </div>
    )
}

export default StatsPage;
