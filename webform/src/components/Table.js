import React from 'react';
import { Table, Space } from 'antd';

const TableComponent = ({tab, search}) => {
    console.log(search);
    const columnsSchedule = [
        {
            title: 'Examination',
            dataIndex: 'examination',
            key: 'examination',
            width: '20%'
        },
        {
            title: 'Level',
            dataIndex: 'level',
            key: 'level',
            width: '20%'
        },
        {
            title: 'Room',
            dataIndex: 'room',
            key: 'room',
            width: '20%'
        },
        {
            title: 'Date',
            key: 'date',
            dataIndex: 'date',
            width: '20%'
        },
        {
            title: 'Time',
            key: 'time',
            dataIndex: 'time',
            width: '20%'
        },
    ];

    const columnsScore = [
        {
            title: 'Listening',
            dataIndex: 'listening',
            key: 'listening',
            width: '25%'
        },
        {
            title: 'Reading',
            dataIndex: 'reading',
            key: 'reading',
            width: '25%'
        },
        {
            title: 'Writing',
            dataIndex: 'writing',
            key: 'writing',
            width: '25%'
        },
        {
            title: 'Speaking',
            key: 'speaking',
            dataIndex: 'speaking',
            width: '25%'
        },
    ];

    const dataSchedule = [
        {
            "examination": "Noel",
            "level": "A2",
            "room": "A2P06",
            "date": "2019/10/24",
            "time": "morning"
        }
    ];

    const dataScore = [
        {
            "listening": 8,
            "reading": 7.5,
            "writing": 6,
            "speaking": 5.5,
        }
    ];

    return (
        <Table columns={tab === "schedule" ? columnsSchedule : columnsScore} dataSource={tab === "schedule" ? dataSchedule : dataScore} pagination={false} />
    )
}

export default TableComponent;
