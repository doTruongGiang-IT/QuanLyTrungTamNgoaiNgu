import React from 'react';
import { Table } from 'antd';

const TableComponent = ({tab, search}) => {
    const columnsSchedule = [
        {
            title: 'Candidate Number',
            dataIndex: 'candidate_no',
            key: 'candidate_no',
            width: '25%'
        },
        {
            title: 'Level',
            dataIndex: 'level',
            key: 'level',
            width: '25%'
        },
        {
            title: 'Room',
            dataIndex: 'room',
            key: 'room',
            width: '25%'
        },
        {
            title: 'Time',
            key: 'time',
            dataIndex: 'time',
            width: '25%'
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

    const columnsCandidates = [
        {
            title: 'STT',
            dataIndex: 'stt',
            key: 'stt',
            width: '25%'
        },
        {
            title: 'Candidate Number',
            dataIndex: 'candidate_no',
            key: 'candidate_no',
            width: '25%'
        },
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
            width: '25%'
        },
        {
            title: 'Phone',
            key: 'phone',
            dataIndex: 'phone',
            width: '25%'
        },
    ];

    const dataSchedule = [
        {
            "key": 1,
            "candidate_no": "A2001",
            "level": "A2",
            "room": "A2P06",
            "time": "morning"
        }
    ];

    const dataScore = [
        {
            "key": 1,
            "listening": 8,
            "reading": 7.5,
            "writing": 6,
            "speaking": 5.5,
        }
    ];

    const dataCandidates = [
        {
            "key": 1,
            "stt": 1,
            "candidate_no": "A2001",
            "name": "Do Truong Giang",
            "phone": "0776134908",
        },
        {
            "key": 2,
            "stt": 2,
            "candidate_no": "A2002",
            "name": "Luu Thanh Dat",
            "phone": "0907236436",
        },
        {
            "key": 3,
            "stt": 3,
            "candidate_no": "A2003",
            "name": "Le Dang Khanh Dung",
            "phone": "0802436845",
        },
    ];

    return (
        <Table columns={tab === "schedule" ? columnsSchedule : (tab === "score" ? columnsScore : columnsCandidates)} dataSource={tab === "schedule" ? dataSchedule : (tab === "score" ? dataScore : dataCandidates)} pagination={false} />
    )
}

export default TableComponent;
